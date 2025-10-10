package com.hm.schwab.clientinterface;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.hm.schwab.clientinterface.streaming.Service;
import com.hm.schwab.clientinterface.streaming.StreamingManager;
import com.hm.schwab.clientinterface.streaming.listeners.StreamListener;
import com.hm.schwab.clientinterface.streaming.requests.Command;
import com.hm.schwab.datastructs.query.account.OrderByID;
import com.hm.schwab.datastructs.query.account.OrderQuery;
import com.hm.schwab.datastructs.query.account.TransactionByID;
import com.hm.schwab.datastructs.query.account.TransactionQuery;
import com.hm.schwab.datastructs.query.marketdata.HistoricalDataQuery;
import com.hm.schwab.datastructs.query.marketdata.InstrumentSearchQuery;
import com.hm.schwab.datastructs.query.marketdata.MarketHoursQuery;
import com.hm.schwab.datastructs.query.marketdata.MarketMoversQuery;
import com.hm.schwab.datastructs.query.marketdata.OptionsChainQuery;
import com.hm.schwab.datastructs.query.marketdata.QuoteQuery;
import com.hm.schwab.datastructs.query.marketdata.SingleQuoteQuery;
import com.hm.schwab.datastructs.schwab.AccountNumberHash;
import com.hm.schwab.datastructs.schwab.CandleList;
import com.hm.schwab.datastructs.schwab.ExpirationChain;
import com.hm.schwab.datastructs.schwab.Instrument;
import com.hm.schwab.datastructs.schwab.InstrumentResponse;
import com.hm.schwab.datastructs.schwab.MarketHours;
import com.hm.schwab.datastructs.schwab.OptionChain;
import com.hm.schwab.datastructs.schwab.Order;
import com.hm.schwab.datastructs.schwab.OrderRequest;
import com.hm.schwab.datastructs.schwab.QuoteResponse;
import com.hm.schwab.datastructs.schwab.Screeners;
import com.hm.schwab.datastructs.schwab.Transaction;
import com.hm.schwab.datastructs.schwab.UserPreference;
import com.hm.schwab.oauth.Authenticator;
import com.hm.schwab.theme.LAF;

public class SchwabAPI {
    private Authenticator authenticator = Authenticator.getAuthenticator();
    private Map<String, String> accounts;
    private static Map<String, String> displaynames;
    private StreamingManager streamingManager;
    
    public SchwabAPI() throws IOException, InterruptedException {
        LAF.applyTheme();
        this.accounts = new HashMap<>();
        List<AccountNumberHash> accounts = getAccountNumbers();
        for (AccountNumberHash account : accounts) {
            this.accounts.put(account.getAccountNumber(), account.getHashValue());
        }
    }
       
    //Streaming methods
	public void submitStreamingRequest(StreamListener listener, Service service, Command command, String keys, String fields) throws Exception {
		if(streamingManager == null) {
			setupStreamingManager();
		}
	    streamingManager.submitStreamingRequest(listener, service, command, keys, fields);
	}
    
    private void setupStreamingManager() throws Exception {
		UserPreference userPreference = getUserPreferences();
        this.streamingManager = new StreamingManager(authenticator, userPreference);
	}


    // Account related
    public static Collection<String> getDisplayAcountNumbers() {
    	return displaynames.keySet();
    }
    
    public String getHashAccountNumber(String displayname) {
    	return accounts.get(displaynames.get(displayname));
    }
    
    public List<AccountNumberHash> getAccountNumbers() throws IOException, InterruptedException {
        return Account.getAccountNumbers(authenticator.getActiveToken());
    }

    public List<com.hm.schwab.datastructs.schwab.Account> getAccountPositions() throws IOException, InterruptedException {
        return Account.getAccountPositions(authenticator.getActiveToken());
    }

    // Order related
    public List<Order> getOrders(OrderQuery query) throws IOException, InterruptedException {
        return Account.getOrders(query, authenticator.getActiveToken());
    }

    public Order getOrder(OrderByID orderid, String accountnumber) throws IOException, InterruptedException {
        return Account.getOrder(orderid, getEncryptedAccountNumber(accountnumber), authenticator.getActiveToken());
    }

    public void cancelOrder(OrderByID orderid, String accountnumber) throws IOException, InterruptedException {
        Account.cancelOrder(orderid, getEncryptedAccountNumber(accountnumber), authenticator.getActiveToken());
    }

    public void submitOrder(Order order, String accountnumber) throws IOException, InterruptedException {
        Account.submitOrder(order, getEncryptedAccountNumber(accountnumber), authenticator.getActiveToken());
    }

	public void replaceOrder(OrderRequest orderrequest, String accountnumber) throws IOException, InterruptedException {
        Account.replaceOrder(orderrequest, getEncryptedAccountNumber(accountnumber), authenticator.getActiveToken());
	}

    // Transaction related
    public List<Transaction> getTransactions(TransactionQuery query, String accountnumber) throws IOException, InterruptedException {
        return Account.getTransactions(query, getEncryptedAccountNumber(accountnumber), authenticator.getActiveToken());
    }

    public Transaction getTransaction(TransactionByID orderid, String accountnumber) throws IOException, InterruptedException {
        return Account.getTransaction(orderid, getEncryptedAccountNumber(accountnumber), authenticator.getActiveToken());
    }

    // User preferences
    public UserPreference getUserPreferences() throws IOException, InterruptedException {
        return Account.getUserPreferences(authenticator.getActiveToken());
    }

    // Market data related
    public QuoteResponse getQuotes(QuoteQuery quotequery) throws IOException, InterruptedException {
        return MarketData.getQuotes(quotequery, authenticator.getActiveToken());
    }

    public QuoteResponse getQuote(SingleQuoteQuery quotequery) throws IOException, InterruptedException {
    	//the single quote query does not support symbols with non-alphabetical characters. example BKR/B
    	//convert to the more general QuoteQuery for that case
    	if(containsNonAlphanumeric(quotequery.getSymbols())) {
    		return getQuotes(new QuoteQuery(quotequery));
    	}
        return MarketData.getQuote(quotequery, authenticator.getActiveToken());
    }
    
    public ExpirationChain getOptionExpirations(String symbol) throws IOException, InterruptedException {
        return MarketData.getOptionExpirations(symbol, authenticator.getActiveToken());
    }

    public OptionChain getOptionsChains(OptionsChainQuery query) throws IOException, InterruptedException {
        return MarketData.getOptionsChains(query, authenticator.getActiveToken());
    }

    public CandleList getHistoricalData(HistoricalDataQuery query) throws IOException, InterruptedException {
        return MarketData.getHistoricalData(query, authenticator.getActiveToken());
    }

    public Screeners getMarketMovers(MarketMoversQuery query) throws IOException, InterruptedException {
        return MarketData.getMarketMovers(query, authenticator.getActiveToken());
    }

    public MarketHours getMarketHours(MarketHoursQuery query) throws IOException, InterruptedException {
        return MarketData.getMarketHours(query, authenticator.getActiveToken());
    }

    public InstrumentResponse getInstruments(InstrumentSearchQuery query) throws IOException, InterruptedException {
        return MarketData.getInstruments(query, authenticator.getActiveToken());
    }

    public Instrument getInstrumentByCUSIP(String cusip) throws IOException, InterruptedException {
        return MarketData.getInstrumentByCUSIP(cusip, authenticator.getActiveToken()).instruments.get(0);
    }

    // Used for testing
    public Entry<String, String> getRandomAccount() {
        return accounts.entrySet().iterator().next();
    }

	public String getDisplayNameForAccountNumber(String accountnumber) {
		return displaynames.get(accountnumber);
	}

	public void setDisplayNamesForAccountNumbers(Map<String, String> displaynames) {
		SchwabAPI.displaynames = displaynames;
	}
	
	public String getEncryptedAccountNumber(String accountnumber) {
		return accounts.get(accountnumber);
	}
	
    /**
     * Checks if a given string contains any character that is not an alphabet (a-z, A-Z) or a number (0-9).
     *
     * @param str The input string to be checked.
     * @return true if the string contains any character other than an alphabet or a number,
     * false otherwise (if the string contains only alphabets and numbers, or is empty/null).
     */
    public static boolean containsNonAlphanumeric(String str) {
        // Handle null or empty string cases
        if (str == null || str.isEmpty()) {
            return false; // An empty or null string does not contain 'any' non-alphanumeric character.
        }

        // Iterate through each character of the string
        for (char c : str.toCharArray()) {
            // Check if the character is NOT a letter or a digit
            if (!Character.isLetterOrDigit(c)) {
                return true; // Found a character that is neither a letter nor a digit
            }
        }

        // If the loop completes, it means all characters are letters or digits
        return false;
    }
}
