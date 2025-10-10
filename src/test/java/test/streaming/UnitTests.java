package test.streaming;

import java.util.concurrent.atomic.AtomicBoolean;

import org.junit.Assert;
import org.junit.Test;

import com.hm.schwab.clientinterface.SchwabAPI;
import com.hm.schwab.clientinterface.streaming.Service;
import com.hm.schwab.clientinterface.streaming.listeners.AccountActivityListener;
import com.hm.schwab.clientinterface.streaming.listeners.ChartEquityListener;
import com.hm.schwab.clientinterface.streaming.listeners.ChartFuturesListener;
import com.hm.schwab.clientinterface.streaming.listeners.LevelOneEquitiesListener;
import com.hm.schwab.clientinterface.streaming.listeners.LevelOneForexListener;
import com.hm.schwab.clientinterface.streaming.listeners.LevelOneFuturesOptionsListener;
import com.hm.schwab.clientinterface.streaming.listeners.LevelOneFuturesListener;
import com.hm.schwab.clientinterface.streaming.listeners.LevelOneOptionsListener;
import com.hm.schwab.clientinterface.streaming.listeners.LevelTwoListener;
import com.hm.schwab.clientinterface.streaming.listeners.ScreenerListener;
import com.hm.schwab.clientinterface.streaming.requests.Command;
import com.hm.schwab.clientinterface.streaming.requests.fields.ChartEquityFieldSelector;
import com.hm.schwab.clientinterface.streaming.requests.fields.ChartFuturesFieldSelector;
import com.hm.schwab.clientinterface.streaming.requests.fields.LevelOneEquitiesFieldSelector;
import com.hm.schwab.clientinterface.streaming.requests.fields.LevelOneForexFieldSelector;
import com.hm.schwab.clientinterface.streaming.requests.fields.LevelOneFuturesFieldSelector;
import com.hm.schwab.clientinterface.streaming.requests.fields.LevelOneFuturesOptionsFieldSelector;
import com.hm.schwab.clientinterface.streaming.requests.fields.LevelOneOptionsFieldSelector;
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

public class UnitTests {
	private static final boolean enableleveloneequitiesstreaming = false;
	private static final boolean enableeveloneoptionsstreaming = false;
	private static final boolean enableevelonefuturesstreaming = false;
	private static final boolean enableevelonefuturesoptionsstreaming = false;
	private static final boolean enableeveloneforexsstreaming = false;
	private static final boolean eanblechartequitystreaming = false;
	private static final boolean eanblechartfuturestreaming = false;
	private static final boolean enableequityscreenertest = false;
	private static final boolean enableoptionscreenertest = false;
	private static final boolean enableaccountactivitytest = false;
	private static final boolean enableleveltwostreaming = true;
	private SchwabAPI api;
	

	public UnitTests() {
		try {
			this.api = new SchwabAPI();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	@Test
	public void TestLevelOneEquitiesStreaming() {
		if(!enableleveloneequitiesstreaming) {
			return;
		}
	    AtomicBoolean dataReceived = new AtomicBoolean(false);
	    String symbol = "AAPL";

	    LevelOneEquitiesListener listener = new LevelOneEquitiesListener() {
	        private double bid;
	        private double ask;
	        private double last;

	        @Override
	        public void onError(Exception e) {
	            System.err.println(e.toString());
	            Assert.fail("An error occurred during streaming: " + e.toString());	       
	        }

	        @Override
	        public void onData(LevelOneEquitiesResponse response) {
	            if (!dataReceived.get()) {
	                if (response.hasBidPrice()) {
	                    this.bid = response.getBidPrice();
	                }
	                if (response.hasAskPrice()) {
	                    this.ask = response.getAskPrice();
	                }
	                if (response.hasLastPrice()) {
	                    this.last = response.getLastPrice();
	                }
	                System.out.println(response.getSymbol() + "\tBid: " + bid + "\tAsk: " + ask + "\tLast: " + last);

	                // Unsubscribe and set the flag to true
	                try {
	                    api.submitStreamingRequest(null, Service.LEVELONE_EQUITIES, Command.UNSUBS, symbol, null);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	                dataReceived.set(true);
	            }
	        }
	    };

	    try {
	        this.api.submitStreamingRequest(listener, Service.LEVELONE_EQUITIES, Command.SUBS, symbol, new LevelOneEquitiesFieldSelector().selectSymbol().selectBidPrice().selectAskPrice().selectLastPrice().getFieldsString());

	        // Wait until data is received and unsubscribed
	        while (!dataReceived.get()) {
	            Thread.sleep(100); // Check every 100 milliseconds
	        }
	    } catch (Exception e) {
            System.err.println(e.toString());
            Assert.fail("An error occurred during streaming: " + e.toString());	     
       }
	}	
	
	@Test
	public void TestLevelOneOptionsStreaming() {
		if(!enableeveloneoptionsstreaming) {
			return;
		}
	    AtomicBoolean dataReceived = new AtomicBoolean(false);
	    String symbol = "SPY   250404C00580000";

	    LevelOneOptionsListener listener = new LevelOneOptionsListener() {
	        private double bid;
	        private double ask;
	        private double last;

	        @Override
	        public void onError(Exception e) {
	            System.err.println(e.toString());
	            Assert.fail("An error occurred during streaming: " + e.toString());	       
	        }

	        @Override
	        public void onData(LevelOneOptionsResponse response) {
	            if (!dataReceived.get()) {
	                if (response.hasBidPrice()) {
	                    this.bid = response.getBidPrice();
	                }
	                if (response.hasAskPrice()) {
	                    this.ask = response.getAskPrice();
	                }
	                if (response.hasLastPrice()) {
	                    this.last = response.getLastPrice();
	                }
	                System.out.println(response.getSymbol() + "\tBid: " + bid + "\tAsk: " + ask + "\tLast: " + last);

	                // Unsubscribe and set the flag to true
	                try {
	                    api.submitStreamingRequest(null, Service.LEVELONE_OPTIONS, Command.UNSUBS, symbol, null);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	                dataReceived.set(true);
	            }
	        }
	    };

	    try {
	        this.api.submitStreamingRequest(listener, Service.LEVELONE_OPTIONS, Command.SUBS, symbol, new LevelOneOptionsFieldSelector().selectSymbol().selectBidPrice().selectAskPrice().selectLastPrice().getFieldsString());

	        // Wait until data is received and unsubscribed
	        while (!dataReceived.get()) {
	            Thread.sleep(100); // Check every 100 milliseconds
	        }
	    } catch (Exception e) {
            System.err.println(e.toString());
            Assert.fail("An error occurred during streaming: " + e.toString());	     
       }
	}	
	
	@Test
	public void TestLevelOneFuturesStreaming() {
		if(!enableevelonefuturesstreaming) {
			return;
		}
	    AtomicBoolean dataReceived = new AtomicBoolean(false);
	    String symbol = "/ESM5";

	    LevelOneFuturesListener listener = new LevelOneFuturesListener() {
	        private double bid;
	        private double ask;
	        private double last;

	        @Override
	        public void onError(Exception e) {
	            System.err.println(e.toString());
	            Assert.fail("An error occurred during streaming: " + e.toString());	       
	        }

	        @Override
	        public void onData(LevelOneFuturesResponse response) {
	            if (!dataReceived.get()) {
	                if (response.hasBidPrice()) {
	                    this.bid = response.getBidPrice();
	                }
	                if (response.hasAskPrice()) {
	                    this.ask = response.getAskPrice();
	                }
	                if (response.hasLastPrice()) {
	                    this.last = response.getLastPrice();
	                }
	                System.out.println(response.getSymbol() + "\tBid: " + bid + "\tAsk: " + ask + "\tLast: " + last);

	                // Unsubscribe and set the flag to true
	                try {
	                    api.submitStreamingRequest(null, Service.LEVELONE_FUTURES, Command.UNSUBS, symbol, null);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	                dataReceived.set(true);
	            }
	        }
	    };

	    try {
	        this.api.submitStreamingRequest(listener, Service.LEVELONE_FUTURES, Command.SUBS, symbol, new LevelOneFuturesFieldSelector().selectSymbol().selectBidPrice().selectAskPrice().selectLastPrice().getFieldsString());

	        // Wait until data is received and unsubscribed
	        while (!dataReceived.get()) {
	            Thread.sleep(100); // Check every 100 milliseconds
	        }
	    } catch (Exception e) {
            System.err.println(e.toString());
            Assert.fail("An error occurred during streaming: " + e.toString());	     
       }
	}	
	
	@Test
	public void TestLevelOneFOPsStreaming() {
		if(!enableevelonefuturesoptionsstreaming) {
			return;
		}
	    AtomicBoolean dataReceived = new AtomicBoolean(false);
	    String symbol = "/ESM6C6000";

	    LevelOneFuturesOptionsListener listener = new LevelOneFuturesOptionsListener() {
	        private double bid;
	        private double ask;
	        private double last;

	        @Override
	        public void onError(Exception e) {
	            System.err.println(e.toString());
	            Assert.fail("An error occurred during streaming: " + e.toString());	       
	        }

	        @Override
	        public void onData(LevelOneFuturesOptionsResponse response) {
	            if (!dataReceived.get()) {
	                if (response.hasBidPrice()) {
	                    this.bid = response.getBidPrice();
	                }
	                if (response.hasAskPrice()) {
	                    this.ask = response.getAskPrice();
	                }
	                if (response.hasLastPrice()) {
	                    this.last = response.getLastPrice();
	                }
	                System.out.println(response.getSymbol() + "\tBid: " + bid + "\tAsk: " + ask + "\tLast: " + last);

	                // Unsubscribe and set the flag to true
	                try {
	                    api.submitStreamingRequest(null, Service.LEVELONE_FUTURES_OPTIONS, Command.UNSUBS, symbol, null);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	                dataReceived.set(true);
	            }
	        }
	    };

	    try {
	        this.api.submitStreamingRequest(listener, Service.LEVELONE_FUTURES_OPTIONS, Command.SUBS, symbol, new LevelOneFuturesOptionsFieldSelector().selectSymbol().selectBidPrice().selectAskPrice().selectLastPrice().getFieldsString());

	        // Wait until data is received and unsubscribed
	        while (!dataReceived.get()) {
	            Thread.sleep(100); // Check every 100 milliseconds
	        }
	    } catch (Exception e) {
            System.err.println(e.toString());
            Assert.fail("An error occurred during streaming: " + e.toString());	     
       }
	}	
	
	@Test
	public void TestLevelOneForexStreaming() {
		if(!enableeveloneforexsstreaming) {
			return;
		}
	    AtomicBoolean dataReceived = new AtomicBoolean(false);
	    String symbol = "EUR/USD";

	    LevelOneForexListener listener = new LevelOneForexListener() {
	        private double bid;
	        private double ask;
	        private double last;

	        @Override
	        public void onError(Exception e) {
	            System.err.println(e.toString());
	            Assert.fail("An error occurred during streaming: " + e.toString());	       
	        }

	        @Override
	        public void onData(LevelOneForexResponse response) {
	            if (!dataReceived.get()) {
	                if (response.hasBidPrice()) {
	                    this.bid = response.getBidPrice();
	                }
	                if (response.hasAskPrice()) {
	                    this.ask = response.getAskPrice();
	                }
	                if (response.hasLastPrice()) {
	                    this.last = response.getLastPrice();
	                }
	                System.out.println(response.getSymbol() + "\tBid: " + bid + "\tAsk: " + ask + "\tLast: " + last);

	                // Unsubscribe and set the flag to true
	                try {
	                    api.submitStreamingRequest(null, Service.LEVELONE_FOREX, Command.UNSUBS, symbol, null);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	                dataReceived.set(true);
	            }
	        }
	    };

	    try {
	        this.api.submitStreamingRequest(listener, Service.LEVELONE_FOREX, Command.SUBS, symbol, new LevelOneForexFieldSelector().selectSymbol().selectBidPrice().selectAskPrice().selectLastPrice().getFieldsString());

	        // Wait until data is received and unsubscribed
	        while (!dataReceived.get()) {
	            Thread.sleep(100); // Check every 100 milliseconds
	        }
	    } catch (Exception e) {
            System.err.println(e.toString());
            Assert.fail("An error occurred during streaming: " + e.toString());	     
       }
	}	
	
	@Test
	public void TestLevelTwoStreaming() {
		if(!enableleveltwostreaming) {
			return;
		}
	    AtomicBoolean dataReceived = new AtomicBoolean(false);
	    String symbol = "AAPL";

	    LevelTwoListener listener = new LevelTwoListener() {
	        @Override
	        public void onError(Exception e) {
	            System.err.println(e.toString());
	            Assert.fail("An error occurred during streaming: " + e.toString());	       
	        }

	        @Override
	        public void onData(LevelTwoResponse response) {
	            if (!dataReceived.get()) {
	            	System.out.println(response.toString());

	                // Unsubscribe and set the flag to true
	                try {
	                    api.submitStreamingRequest(null, Service.NASDAQ_BOOK, Command.UNSUBS, symbol, null);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	                dataReceived.set(true);
	            }
	        }
	    };

	    try {
	        this.api.submitStreamingRequest(listener, Service.NASDAQ_BOOK, Command.SUBS, symbol, "0,1,2,3");

	        // Wait until data is received and unsubscribed
	        while (!dataReceived.get()) {
	            Thread.sleep(100); // Check every 100 milliseconds
	        }
	    } catch (Exception e) {
            System.err.println(e.toString());
            Assert.fail("An error occurred during streaming: " + e.toString());	     
       }
	}	
	
	@Test
	public void TestChartEquityStreaming() {
		if(!eanblechartequitystreaming) {
			return;
		}
	    AtomicBoolean dataReceived = new AtomicBoolean(false);
	    String symbol = "AAPL";

	    ChartEquityListener listener = new ChartEquityListener() {
	        private double close;

	        @Override
	        public void onError(Exception e) {
	            System.err.println(e.toString());
	            Assert.fail("An error occurred during streaming: " + e.toString());	       
	        }

	        @Override
	        public void onData(ChartEquityResponse response) {
	            if (!dataReceived.get()) {
	                if (response.hasClosePrice()) {
	                    this.close = response.getClosePrice();
	                }
	                System.out.println(response.getSymbol() + "\tClose: " + close);

	                // Unsubscribe and set the flag to true
	                try {
	                    api.submitStreamingRequest(null, Service.CHART_EQUITY, Command.UNSUBS, symbol, null);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	                dataReceived.set(true);
	            }
	        }
	    };

	    try {
	        this.api.submitStreamingRequest(listener, Service.CHART_EQUITY, Command.SUBS, symbol, new ChartEquityFieldSelector().selectSymbol().selectClosePrice().getFieldsString());

	        // Wait until data is received and unsubscribed
	        while (!dataReceived.get()) {
	            Thread.sleep(100); // Check every 100 milliseconds
	        }
	    } catch (Exception e) {
            System.err.println(e.toString());
            Assert.fail("An error occurred during streaming: " + e.toString());	     
       }
	}	
	
	@Test
	public void TestChartFutureStreaming() {
		if(!eanblechartfuturestreaming) {
			return;
		}
	    AtomicBoolean dataReceived = new AtomicBoolean(false);
	    String symbol = "/ESM5";

	    ChartFuturesListener listener = new ChartFuturesListener() {
	        private double close;

	        @Override
	        public void onError(Exception e) {
	            System.err.println(e.toString());
	            Assert.fail("An error occurred during streaming: " + e.toString());	       
	        }

	        @Override
	        public void onData(ChartFuturesResponse response) {
	            if (!dataReceived.get()) {
	                if (response.hasClosePrice()) {
	                    this.close = response.getClosePrice();
	                }
	                System.out.println(response.getSymbol() + "\tClose: " + close);

	                // Unsubscribe and set the flag to true
	                try {
	                    api.submitStreamingRequest(null, Service.CHART_FUTURES, Command.UNSUBS, symbol, null);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	                dataReceived.set(true);
	            }
	        }
	    };

	    try {
	        this.api.submitStreamingRequest(listener, Service.CHART_FUTURES, Command.SUBS, symbol, new ChartFuturesFieldSelector().selectSymbol().selectClosePrice().getFieldsString());

	        // Wait until data is received and unsubscribed
	        while (!dataReceived.get()) {
	            Thread.sleep(100); // Check every 100 milliseconds
	        }
	    } catch (Exception e) {
            System.err.println(e.toString());
            Assert.fail("An error occurred during streaming: " + e.toString());	     
       }
	}	
	
	@Test
	public void TestScreenerEquity() {
		if(!enableequityscreenertest) {
			return;
		}
	    AtomicBoolean dataReceived = new AtomicBoolean(false);
	    String symbol = "$SPX_VOLUME_1";

	    ScreenerListener listener = new ScreenerListener() {
	        private double close;

	        @Override
	        public void onError(Exception e) {
	            System.err.println(e.toString());
	            Assert.fail("An error occurred during streaming: " + e.toString());	       
	        }

	        @Override
	        public void onData(ScreenerResponse response) {
	            if (!dataReceived.get()) {
	                if (response.getItems().length == 0) {
	    	            Assert.fail("Screener Items is empty.");	      
	                }
	                System.out.println(response.toString());

	                try {
	                    api.submitStreamingRequest(null, Service.SCREENER_EQUITY, Command.UNSUBS, symbol, null);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	                dataReceived.set(true);
	            }
	        }
	    };

	    try {
	        this.api.submitStreamingRequest(listener, Service.SCREENER_EQUITY, Command.SUBS, symbol, "1,2,3,4,5,6,7");

	        // Wait until data is received and unsubscribed
	        while (!dataReceived.get()) {
	            Thread.sleep(100); // Check every 100 milliseconds
	        }
	    } catch (Exception e) {
            System.err.println(e.toString());
            Assert.fail("An error occurred during streaming: " + e.toString());	     
       }
	}	
	
	@Test
	public void TestScreenerOption() {
		if(!enableoptionscreenertest) {
			return;
		}
	    AtomicBoolean dataReceived = new AtomicBoolean(false);
	    String symbol = "$SPX_VOLUME_1";

	    ScreenerListener listener = new ScreenerListener() {
	        private double close;

	        @Override
	        public void onError(Exception e) {
	            System.err.println(e.toString());
	            Assert.fail("An error occurred during streaming: " + e.toString());	       
	        }

	        @Override
	        public void onData(ScreenerResponse response) {
	            if (!dataReceived.get()) {
	                if (response.getItems().length == 0) {
	    	            Assert.fail("Screener Items is empty.");	      
	                }
	                System.out.println(response.toString());

	                try {
	                    api.submitStreamingRequest(null, Service.SCREENER_OPTION, Command.UNSUBS, symbol, null);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	                dataReceived.set(true);
	            }
	        }
	    };

	    try {
	        this.api.submitStreamingRequest(listener, Service.SCREENER_OPTION, Command.SUBS, symbol, "1,2,3,4,5,6,7");

	        // Wait until data is received and unsubscribed
	        while (!dataReceived.get()) {
	            Thread.sleep(100); // Check every 100 milliseconds
	        }
	    } catch (Exception e) {
            System.err.println(e.toString());
            Assert.fail("An error occurred during streaming: " + e.toString());	     
       }
	}	
	
	@Test
	public void TestAccountActivity() {
		if(!enableaccountactivitytest) {
			return;
		}
	    AtomicBoolean dataReceived = new AtomicBoolean(false);

	    AccountActivityListener listener = new AccountActivityListener() {

	        @Override
	        public void onError(Exception e) {
	            System.err.println(e.toString());
	            Assert.fail("An error occurred during streaming: " + e.toString());	       
	        }

	        @Override
	        public void onData(AccountActivityResponse response) {
	            if (!dataReceived.get()) {
	                if (!response.getMessageData().isEmpty()) {
	    	            Assert.fail("Screener Items is empty.");	      
	                }
	                System.out.println(response.toString());

	                try {
	                    api.submitStreamingRequest(null, Service.ACCT_ACTIVITY, Command.UNSUBS, null, null);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	                dataReceived.set(true);
	            }
	        }
	    };

	    try {
	        this.api.submitStreamingRequest(listener, Service.ACCT_ACTIVITY, Command.SUBS, "Account Activity", "1,2,3,4");

	        // Wait until data is received and unsubscribed
	        while (!dataReceived.get()) {
	            Thread.sleep(100); // Check every 100 milliseconds
	        }
	    } catch (Exception e) {
            System.err.println(e.toString());
            Assert.fail("An error occurred during streaming: " + e.toString());	     
       }
	}	
}
