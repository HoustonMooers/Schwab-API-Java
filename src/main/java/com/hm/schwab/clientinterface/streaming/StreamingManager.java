package com.hm.schwab.clientinterface.streaming;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hm.schwab.clientinterface.streaming.listeners.AccountActivityListener;
import com.hm.schwab.clientinterface.streaming.listeners.ChartEquityListener;
import com.hm.schwab.clientinterface.streaming.listeners.ChartFuturesListener;
import com.hm.schwab.clientinterface.streaming.listeners.LevelOneEquitiesListener;
import com.hm.schwab.clientinterface.streaming.listeners.LevelOneForexListener;
import com.hm.schwab.clientinterface.streaming.listeners.LevelOneFuturesListener;
import com.hm.schwab.clientinterface.streaming.listeners.LevelOneFuturesOptionsListener;
import com.hm.schwab.clientinterface.streaming.listeners.LevelOneOptionsListener;
import com.hm.schwab.clientinterface.streaming.listeners.LevelTwoListener;
import com.hm.schwab.clientinterface.streaming.listeners.ScreenerListener;
import com.hm.schwab.clientinterface.streaming.listeners.StreamListener;
import com.hm.schwab.clientinterface.streaming.requests.StreamingRequest;
import com.hm.schwab.clientinterface.streaming.responses.AccountActivityResponse;
import com.hm.schwab.clientinterface.streaming.responses.ChartEquityResponse;
import com.hm.schwab.clientinterface.streaming.responses.ChartFuturesResponse;
import com.hm.schwab.clientinterface.streaming.responses.LevelOneEquitiesResponse;
import com.hm.schwab.clientinterface.streaming.responses.LevelOneForexResponse;
import com.hm.schwab.clientinterface.streaming.responses.LevelOneFuturesOptionsResponse;
import com.hm.schwab.clientinterface.streaming.responses.LevelOneFuturesResponse;
import com.hm.schwab.clientinterface.streaming.responses.LevelOneOptionsResponse;
import com.hm.schwab.clientinterface.streaming.responses.ScreenerResponse;
import com.hm.schwab.clientinterface.streaming.responses.level2.LevelTwoResponse;
import com.hm.schwab.clientinterface.streaming.requests.Command;
import com.hm.schwab.datastructs.schwab.StreamerInfo;
import com.hm.schwab.datastructs.schwab.UserPreference;
import com.hm.schwab.oauth.Authenticator;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Executors;

public class StreamingManager {
	private final Authenticator authenticator;
	private final UserPreference userPreference;
	private WebSocketClient webSocketClient;
	private final List<AccountActivityListener> accountactivitylisteners;
	private final List<LevelOneEquitiesListener> leveloneequitieslisteners;
	private final List<LevelOneOptionsListener> leveloneoptionslisteners;
	private final List<LevelOneFuturesListener> levelonefutureslisteners;
	private final List<LevelOneFuturesOptionsListener> levelonefuturesoptionslisteners;
	private final List<LevelOneForexListener> leveloneforexlisteners;
	private final List<LevelTwoListener> nyseleveltwolisteners;
	private final List<LevelTwoListener> nasdaqleveltwolisteners;
	private final List<LevelTwoListener> optionsleveltwolistener;
	private final List<ChartEquityListener> chartequitylisteners;
	private final List<ChartFuturesListener> chartfutureslisteners;
	private final List<ScreenerListener> equityscreenerlisteners;	
	private final List<ScreenerListener> optionsscreenerlistener;	
	private final ObjectMapper objectMapper = new ObjectMapper();
	private int requestid;
	private CountDownLatch loginLatch;
	private Exception loginException;
	private ScheduledExecutorService heartbeatExecutor;
	private static final int HEARTBEAT_INTERVAL = 30; // seconds

	public StreamingManager(Authenticator authenticator, UserPreference userPreference) throws Exception {
		this.authenticator = authenticator;
		this.userPreference = userPreference;
		this.heartbeatExecutor = Executors.newSingleThreadScheduledExecutor();
		this.accountactivitylisteners = new ArrayList<>();
		this.leveloneequitieslisteners = new ArrayList<>();
		this.leveloneoptionslisteners = new ArrayList<>();
		this.levelonefutureslisteners = new ArrayList<>();
		this.levelonefuturesoptionslisteners = new ArrayList<>();
		this.leveloneforexlisteners = new ArrayList<>();
		this.chartequitylisteners = new ArrayList<>();
		this.chartfutureslisteners = new ArrayList<>();
		this.equityscreenerlisteners = new ArrayList<>();
		this.optionsscreenerlistener = new ArrayList<>();
		this.nyseleveltwolisteners = new ArrayList<>();
		this.nasdaqleveltwolisteners = new ArrayList<>();
		this.optionsleveltwolistener = new ArrayList<>();
		connect();
	}

	private void connect() throws Exception {
		StreamerInfo streamerInfo = userPreference.streamerInfo.get(0);
		URI uri = new URI(streamerInfo.streamerSocketUrl);
		webSocketClient = new WebSocketClient(uri) {
			@Override
			public void onOpen(ServerHandshake handshake) {
				System.out.println("WebSocket connected");
			}

			@Override
			public void onMessage(String message) {
				try {
					Map<String, Object> responseMap = objectMapper.readValue(message, Map.class);

					// Handle "response" messages (e.g., login or subscription responses)
					List<Map<String, Object>> responses = (List<Map<String, Object>>) responseMap.get("response");
					if (responses != null) {
						for (Map<String, Object> resp : responses) {
							String requestId = (String) resp.get("requestid");
							if (requestId != null && Integer.parseInt(requestId) == requestid) {
								// Handle login response
								Map<String, Object> content = (Map<String, Object>) resp.get("content");
								int code = (int) content.get("code");
								if (code == 0) {
									loginLatch.countDown(); // Login successful
									requestid++;
								} else {
									String msg = (String) content.get("msg");
									loginException = new Exception("Login failed: " + msg);
									loginLatch.countDown();
								}
							} else {
								// Handle other responses (e.g., subscription confirmations)
//								for (StreamingListener listener : accountactivitylisteners) {
//									listener.onAccountActivity(message); // Could refine based on service
//								}
							}
						}
						return; // Exit after handling responses
					}

					// Handle "data" messages (real-time updates)
					List<Map<String, Object>> data = (List<Map<String, Object>>) responseMap.get("data");
					if (data != null) {
						for(Map<String, Object> datapoint : data) {
							long timestamp = (long) datapoint.get("timestamp");
							String service = (String) datapoint.get("service");
							List<Map<String, Object>> listofdata = (List<Map<String, Object>>) datapoint.get("content");
							for(Map<String, Object> dt : listofdata) {
								routeDataToListeners(dt, service, timestamp);
							}
						}
						return; // Exit after handling data
					}

					// Handle "notify" messages (e.g., heartbeats)
					List<Map<String, Object>> notify = (List<Map<String, Object>>) responseMap.get("notify");
					if (notify != null) {
						for (Map<String, Object> notifyItem : notify) {
							if (notifyItem.containsKey("heartbeat")) {
								//System.out.println("Heartbeat received: " + notifyItem.get("heartbeat"));
							}
						}
						return; // Exit after handling notify
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			@Override
			public void onClose(int code, String reason, boolean remote) {
				System.out.println("WebSocket closed: " + reason);
				if (loginLatch != null) {
					loginLatch.countDown();
				}
				StreamingManager.this.webSocketClient = null;
			}

			@Override
			public void onError(Exception ex) {
				System.out.println(ex.toString());
			}
		};
		webSocketClient.connectBlocking();
		login();
		waitForLogin();
	}
	
	private void routeDataToListeners(Map<String, Object> data, String service, long timestamp) {
		switch (service) {
		case "LEVELONE_EQUITIES":
			processLevelOneEquities(data, timestamp);
			break;
		case "LEVELONE_OPTIONS":
			processLevelOneOptions(data, timestamp);
			break;
		case "LEVELONE_FUTURES":
			processLevelOneFutures(data, timestamp);
			break;
		case "LEVELONE_FUTURES_OPTIONS":
			processLevelOneFuturesOptions(data, timestamp);
			break;
		case "LEVELONE_FOREX":
			processLevelOneForex(data, timestamp);
			break;
		case "NYSE_BOOK":
			processNYSEBook(data, timestamp);
			break;
		case "NASDAQ_BOOK":
			processNasdaqBook(data, timestamp);
			break;
		case "OPTIONS_BOOK":
			processOptionsBook(data, timestamp);
			break;
		case "CHART_EQUITY":
			processChartEquity(data, timestamp);
			break;
		case "CHART_FUTURES":
			processChartFutures(data, timestamp);
			break;
		case "SCREENER_EQUITY":
			processScreenerEquity(data, timestamp);
			break;
		case "SCREENER_OPTION":
			processScreenerOption(data, timestamp);
			break;
		case "ACCT_ACTIVITY":
			processAccountActivity(data, timestamp);
			break;
		default:
			throw new RuntimeException("Unknown service");
		}
	}

	private void processAccountActivity(Map<String, Object> data, long timestamp) {
		AccountActivityResponse screenerresponse = new AccountActivityResponse(data, timestamp);
		for(AccountActivityListener listener : accountactivitylisteners) {
			listener.onData(screenerresponse);
		}
	}

	private void processScreenerOption(Map<String, Object> data, long timestamp) {
		ScreenerResponse screenerresponse = new ScreenerResponse(data, timestamp);
		for(ScreenerListener listener : optionsscreenerlistener) {
			listener.onData(screenerresponse);
		}
	}

	private void processScreenerEquity(Map<String, Object> data, long timestamp) {
		ScreenerResponse screenerresponse = new ScreenerResponse(data, timestamp);
		for(ScreenerListener listener : equityscreenerlisteners) {
			listener.onData(screenerresponse);
		}
	}

	private void processChartFutures(Map<String, Object> data, long timestamp) {
		ChartFuturesResponse chartfuturesresponse = new ChartFuturesResponse(data, timestamp);
		for(ChartFuturesListener listener : chartfutureslisteners) {
			listener.onData(chartfuturesresponse);
		}	
	}

	private void processChartEquity(Map<String, Object> data, long timestamp) {
		ChartEquityResponse chartequityresponse = new ChartEquityResponse(data, timestamp);
		for(ChartEquityListener listener : chartequitylisteners) {
			listener.onData(chartequityresponse);
		}	
	}

	private void processOptionsBook(Map<String, Object> data, long timestamp) {
		LevelTwoResponse leveltworesponse = new LevelTwoResponse(data, timestamp);
		for(LevelTwoListener listener : optionsleveltwolistener) {
			listener.onData(leveltworesponse);
		}
	}

	private void processNasdaqBook(Map<String, Object> data, long timestamp) {
		LevelTwoResponse leveltworesponse = new LevelTwoResponse(data, timestamp);
		for(LevelTwoListener listener : nasdaqleveltwolisteners) {
			listener.onData(leveltworesponse);
		}
	}

	private void processNYSEBook(Map<String, Object> data, long timestamp) {
		LevelTwoResponse leveltworesponse = new LevelTwoResponse(data, timestamp);
		for(LevelTwoListener listener : nyseleveltwolisteners) {
			listener.onData(leveltworesponse);
		}	
	}

	private void processLevelOneForex(Map<String, Object> data, long timestamp) {
		LevelOneForexResponse forexresponse = new LevelOneForexResponse(data, timestamp);
		for(LevelOneForexListener listener : leveloneforexlisteners) {
			listener.onData(forexresponse);
		}	
	}

	private void processLevelOneFuturesOptions(Map<String, Object> data, long timestamp) {
		LevelOneFuturesOptionsResponse fopresponse = new LevelOneFuturesOptionsResponse(data, timestamp);
		for(LevelOneFuturesOptionsListener listener : levelonefuturesoptionslisteners) {
			listener.onData(fopresponse);
		}				
	}

	private void processLevelOneFutures(Map<String, Object> data, long timestamp) {
		LevelOneFuturesResponse eqr = new LevelOneFuturesResponse(data, timestamp);
		for(LevelOneFuturesListener listener : levelonefutureslisteners) {
			listener.onData(eqr);
		}
	}

	private void processLevelOneOptions(Map<String, Object> data, long timestamp) {
		LevelOneOptionsResponse eqr = new LevelOneOptionsResponse(data, timestamp);
		for(LevelOneOptionsListener listener : leveloneoptionslisteners) {
			listener.onData(eqr);
		}
	}

	private void processLevelOneEquities(Map<String, Object> data, long timestamp) {
		LevelOneEquitiesResponse eqr = new LevelOneEquitiesResponse(data, timestamp);
		for(LevelOneEquitiesListener listener : leveloneequitieslisteners) {
			listener.onData(eqr);
		}
	}

	private void login() throws Exception {        
		requestid++;
		loginLatch = new CountDownLatch(1);
		loginException = null;

		StreamerInfo streamerInfo = userPreference.streamerInfo.get(0);

		Map<String, Object> parammap = new HashMap<>();
		parammap.put("service", "ADMIN");
		parammap.put("requestid", Integer.toString(requestid));
		parammap.put("command", "LOGIN");
		parammap.put("SchwabClientCustomerId", streamerInfo.schwabClientCustomerId);
		parammap.put("SchwabClientCorrelId", streamerInfo.schwabClientCorrelId);
		Map<String, Object> innerparammap = new HashMap<String, Object>();
		innerparammap.put("Authorization", authenticator.getActiveToken());
		innerparammap.put("SchwabClientChannel", streamerInfo.schwabClientChannel);
		innerparammap.put("SchwabClientFunctionId", streamerInfo.schwabClientFunctionId);
		parammap.put("parameters", innerparammap);

		Map<String, List<Map<String, Object>>> requestRoot = new HashMap<>();
		List<Map<String, Object>> requestlist = new ArrayList<>();
		requestlist.add(parammap);
		requestRoot.put("requests", requestlist);
		String jsonRequest = objectMapper.writeValueAsString(requestRoot);
		webSocketClient.send(jsonRequest);
	}

	private void waitForLogin() throws Exception {
		if (!loginLatch.await(10, TimeUnit.SECONDS)) {
			throw new Exception("Login timed out");
		}
		if (loginException != null) {
			throw loginException;
		}
		//startHeartbeat(); // Start heartbeat after successful login
	}

	private void startHeartbeat() {
		heartbeatExecutor.scheduleAtFixedRate(() -> {
			if (isConnected()) {
				sendHeartbeat();
			}
		}, HEARTBEAT_INTERVAL, HEARTBEAT_INTERVAL, TimeUnit.SECONDS);
	}

	private void sendHeartbeat() {
		try {
			Map<String, Object> heartbeatRequest = new HashMap<>();
			heartbeatRequest.put("service", "ADMIN");
			heartbeatRequest.put("requestid", Integer.toString(requestid++));
			heartbeatRequest.put("command", "QOS");
			heartbeatRequest.put("SchwabClientCustomerId", userPreference.streamerInfo.get(0).schwabClientCustomerId);
			heartbeatRequest.put("SchwabClientCorrelId", userPreference.streamerInfo.get(0).schwabClientCorrelId);
			
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("qoslevel", "0"); // Basic quality of service
			heartbeatRequest.put("parameters", parameters);

			Map<String, List<Map<String, Object>>> requestRoot = new HashMap<>();
			List<Map<String, Object>> requestList = new ArrayList<>();
			requestList.add(heartbeatRequest);
			requestRoot.put("requests", requestList);
			
			String jsonRequest = objectMapper.writeValueAsString(requestRoot);
			webSocketClient.send(jsonRequest);
			
			System.out.println("Heartbeat sent");
		} catch (Exception e) {
			System.err.println("Failed to send heartbeat: " + e.getMessage());
		}
	}

	public void submitStreamingRequest(StreamListener listener, Service service, Command command, String keys, String fields) throws JsonProcessingException {
		StreamerInfo streamerInfo = userPreference.streamerInfo.get(0);
		String requeststr = StreamingRequest.GetStreamingRequest(service, requestid++, streamerInfo, command, keys, fields, objectMapper);
		webSocketClient.send(requeststr);
		if(command == Command.SUBS || command == Command.ADD) {
			addStreamListener(service, listener);
		}
		else if(command == Command.UNSUBS) {
			removeStreamListeners(service);
		}
	}

	private void removeStreamListeners(Service service) {
        switch (service) {
        case ACCT_ACTIVITY:
        	accountactivitylisteners.clear();
        	break;
        case LEVELONE_EQUITIES:
    		leveloneequitieslisteners.clear();
            break;
        case LEVELONE_OPTIONS:
        	leveloneequitieslisteners.clear();
            break;
        case LEVELONE_FUTURES:
            levelonefutureslisteners.clear();
            break;
        case LEVELONE_FUTURES_OPTIONS:
        	levelonefuturesoptionslisteners.clear();
            break;
        case LEVELONE_FOREX:
            leveloneforexlisteners.clear();
            break;
        case NYSE_BOOK:
            nyseleveltwolisteners.clear();
            break;
        case NASDAQ_BOOK:
            nasdaqleveltwolisteners.clear();
            break;
        case OPTIONS_BOOK:
            optionsleveltwolistener.clear();
            break;
        case CHART_EQUITY:
            chartequitylisteners.clear();
            break;
        case CHART_FUTURES:
            chartfutureslisteners.clear();
            break;
        case SCREENER_EQUITY:
            equityscreenerlisteners.clear();
            break;
        case SCREENER_OPTION:
            optionsscreenerlistener.clear();
            break;
        default:
            System.out.println("Unknown service: " + service);
            // Handle unknown service
            break;
    }
	}

	private void addStreamListener(Service service, StreamListener listener) {
	        switch (service) {
	            case LEVELONE_EQUITIES:
	            	LevelOneEquitiesListener newlistener = (LevelOneEquitiesListener) listener;
	        		for(LevelOneEquitiesListener cur : leveloneequitieslisteners) {
	        			if(cur == newlistener) {
	        				return;
	        			}
	        		}
	        		leveloneequitieslisteners.add(newlistener);
	                break;
	            case LEVELONE_OPTIONS:
	            	LevelOneOptionsListener newlisteneroptions = (LevelOneOptionsListener) listener;
	        		for(LevelOneOptionsListener cur : leveloneoptionslisteners) {
	        			if(cur == newlisteneroptions) {
	        				return;
	        			}
	        		}
	        		leveloneoptionslisteners.add(newlisteneroptions);
	                break;
	            case LEVELONE_FUTURES:
	            	LevelOneFuturesListener newlistenerfutures = (LevelOneFuturesListener) listener;
	        		for(LevelOneFuturesListener cur : levelonefutureslisteners) {
	        			if(cur == newlistenerfutures) {
	        				return;
	        			}
	        		}
	        		levelonefutureslisteners.add(newlistenerfutures);
	                break;
	            case LEVELONE_FUTURES_OPTIONS:
	            	LevelOneFuturesOptionsListener newlistenerfuturesoptions = (LevelOneFuturesOptionsListener) listener;
	        		for(LevelOneFuturesListener cur : levelonefutureslisteners) {
	        			if(cur == newlistenerfuturesoptions) {
	        				return;
	        			}
	        		}
	        		levelonefuturesoptionslisteners.add(newlistenerfuturesoptions);
	                break;
	            case LEVELONE_FOREX:
	            	LevelOneForexListener newlistenerforex = (LevelOneForexListener) listener;
	        		for(LevelOneForexListener cur : leveloneforexlisteners) {
	        			if(cur == newlistenerforex) {
	        				return;
	        			}
	        		}
	        		leveloneforexlisteners.add(newlistenerforex);
	                break;
	            case NYSE_BOOK:
	            	LevelTwoListener leveltwonyselistener = (LevelTwoListener) listener;
	        		for(LevelTwoListener cur : this.nyseleveltwolisteners) {
	        			if(cur == leveltwonyselistener) {
	        				return;
	        			}
	        		}
	        		nyseleveltwolisteners.add(leveltwonyselistener);
	                break;
	            case NASDAQ_BOOK:
	            	LevelTwoListener leveltwonasdaqlistener = (LevelTwoListener) listener;
	        		for(LevelTwoListener cur : this.nasdaqleveltwolisteners) {
	        			if(cur == leveltwonasdaqlistener) {
	        				return;
	        			}
	        		}
	        		nasdaqleveltwolisteners.add(leveltwonasdaqlistener);
	                break;
	            case OPTIONS_BOOK:
	            	LevelTwoListener leveltwooptionslistener = (LevelTwoListener) listener;
	        		for(LevelTwoListener cur : this.optionsleveltwolistener) {
	        			if(cur == leveltwooptionslistener) {
	        				return;
	        			}
	        		}
	        		optionsleveltwolistener.add(leveltwooptionslistener);
	                break;
	            case CHART_EQUITY:
	            	ChartEquityListener newchartequitylistener = (ChartEquityListener) listener;
	        		for(ChartEquityListener cur : chartequitylisteners) {
	        			if(cur == newchartequitylistener) {
	        				return;
	        			}
	        		}
	        		chartequitylisteners.add(newchartequitylistener);
	                break;
	            case CHART_FUTURES:
	            	ChartFuturesListener newchartefutureslistener = (ChartFuturesListener) listener;
	        		for(ChartFuturesListener cur : chartfutureslisteners) {
	        			if(cur == newchartefutureslistener) {
	        				return;
	        			}
	        		}
	        		chartfutureslisteners.add(newchartefutureslistener);
	                break;
	            case SCREENER_EQUITY:
	            	ScreenerListener screenerlistenereqty = (ScreenerListener) listener;
	        		for(ScreenerListener cur : equityscreenerlisteners) {
	        			if(cur == screenerlistenereqty) {
	        				return;
	        			}
	        		}
	        		equityscreenerlisteners.add(screenerlistenereqty);
	                break;
	            case SCREENER_OPTION:
	            	ScreenerListener screenerlisteneropt = (ScreenerListener) listener;
	        		for(ScreenerListener cur : equityscreenerlisteners) {
	        			if(cur == screenerlisteneropt) {
	        				return;
	        			}
	        		}
	        		optionsscreenerlistener.add(screenerlisteneropt);
	                break;
	            case ACCT_ACTIVITY:
	            	AccountActivityListener accountactivitylistener = (AccountActivityListener) listener;
	        		for(AccountActivityListener cur : accountactivitylisteners) {
	        			if(cur == accountactivitylistener) {
	        				return;
	        			}
	        		}
	        		accountactivitylisteners.add(accountactivitylistener);
	                break;
	            default:
	                System.out.println("Unknown service: " + service);
	                // Handle unknown service
	                break;
	        }
	}

	public boolean isConnected() {
		return webSocketClient != null && webSocketClient.isOpen();
	}

	public void disconnect() {
		if (heartbeatExecutor != null && !heartbeatExecutor.isShutdown()) {
			heartbeatExecutor.shutdown();
			try {
				if (!heartbeatExecutor.awaitTermination(5, TimeUnit.SECONDS)) {
					heartbeatExecutor.shutdownNow();
				}
			} catch (InterruptedException e) {
				heartbeatExecutor.shutdownNow();
				Thread.currentThread().interrupt();
			}
		}
		
		if (webSocketClient != null && webSocketClient.isOpen()) {
			webSocketClient.close();
		}
	}
}