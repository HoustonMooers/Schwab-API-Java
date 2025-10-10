package com.hm.schwab.clientinterface;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hm.schwab.datastructs.query.marketdata.HistoricalDataQuery;
import com.hm.schwab.datastructs.query.marketdata.InstrumentSearchQuery;
import com.hm.schwab.datastructs.query.marketdata.MarketHoursQuery;
import com.hm.schwab.datastructs.query.marketdata.MarketMoversQuery;
import com.hm.schwab.datastructs.query.marketdata.OptionsChainQuery;
import com.hm.schwab.datastructs.query.marketdata.QuoteQuery;
import com.hm.schwab.datastructs.query.marketdata.SingleQuoteQuery;
import com.hm.schwab.datastructs.schwab.CandleList;
import com.hm.schwab.datastructs.schwab.ExpirationChain;
import com.hm.schwab.datastructs.schwab.InstrumentResponse;
import com.hm.schwab.datastructs.schwab.MarketHours;
import com.hm.schwab.datastructs.schwab.OptionChain;
import com.hm.schwab.datastructs.schwab.QuoteResponse;
import com.hm.schwab.datastructs.schwab.Screeners;

public class MarketData {
    public static String baseuri = "https://api.schwabapi.com/marketdata/v1/";
    private static Connection connection = Connection.getConnection();
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final ExecutorService threadPool = Executors.newFixedThreadPool(7);

//    public static QuoteResponse getQuotes(QuoteQuery quotequery, String token) throws IOException, InterruptedException {
//        if(quotequery.getNumSymbolsInRequest() > 200) {
//        	QuoteQuery[] quotequerybatches = quotequery.split(200);
//        	QuoteResponse qr = getQuotesSingleBatch(quotequerybatches[0], token);
//        	for(int i = 1; i < quotequerybatches.length; i++) {
//        		QuoteResponse nextbatch = getQuotesSingleBatch(quotequerybatches[i], token);
//        		qr.merge(nextbatch);
//        	}
//        	return qr;
//        }
//        return getQuotesSingleBatch(quotequery, token);
//    }
    
    public static QuoteResponse getQuotes(QuoteQuery quotequery, String token) throws IOException, InterruptedException {
        // If 200 or fewer symbols, process directly without threading
        if (quotequery.getNumSymbolsInRequest() <= 200) {
            return getQuotesSingleBatch(quotequery, token);
        }

        // Split the query into batches of 200 symbols
        QuoteQuery[] quotequerybatches = quotequery.split(200);

        // Submit all batches to the thread pool
        List<Future<QuoteResponse>> futures = new ArrayList<>();
        for (QuoteQuery batch : quotequerybatches) {
            futures.add(threadPool.submit(() -> getQuotesSingleBatch(batch, token)));
        }

        // Collect results from all futures
        List<QuoteResponse> responses = new ArrayList<>();
        for (Future<QuoteResponse> future : futures) {
            try {
                responses.add(future.get());
            } catch (ExecutionException e) {
                throw new IOException("Error fetching quotes", e);
            }
        }

        // Merge all responses into a single QuoteResponse
        if (responses.isEmpty()) {
        	QuoteResponse qr = new QuoteResponse();
        	qr.quotes = new HashMap<>();
            return qr;
        }
        QuoteResponse qr = responses.get(0);
        for (int i = 1; i < responses.size(); i++) {
            qr.merge(responses.get(i));
        }
        return qr;
    }
    
    private static QuoteResponse getQuotesSingleBatch(QuoteQuery quotequery, String token) throws IOException, InterruptedException {
        HttpResponse<String> response = connection.getRequest(quotequery.getURI(baseuri), Connection.getHeaders(token));
        connection.checkResponseCode(response);
        try {
            return objectMapper.readValue(response.body(), QuoteResponse.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse Quotes response", e);
        }
    }
    
    public static QuoteResponse getQuote(SingleQuoteQuery quotequery, String token) throws IOException, InterruptedException {
        HttpResponse<String> response = connection.getRequest(quotequery.getURI(baseuri), Connection.getHeaders(token));
        connection.checkResponseCode(response);
        try {
            return objectMapper.readValue(response.body(), QuoteResponse.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse Quote response", e);
        }
    }

    public static ExpirationChain getOptionExpirations(String symbol, String token) throws IOException, InterruptedException {
        HttpResponse<String> response = connection.getRequest(baseuri + "expirationchain?symbol=" + symbol, Connection.getHeaders(token));
        connection.checkResponseCode(response);
        try {
            return objectMapper.readValue(response.body(), ExpirationChain.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse OptionExpirations response", e);
        }
    }

    public static OptionChain getOptionsChains(OptionsChainQuery query, String token) throws IOException, InterruptedException {
        HttpResponse<String> response = connection.getRequest(query.getURI(baseuri), Connection.getHeaders(token));
        connection.checkResponseCode(response);
        try {
            return objectMapper.readValue(response.body(), OptionChain.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse OptionsChain response", e);
        }
    }

    public static CandleList getHistoricalData(HistoricalDataQuery query, String token) throws IOException, InterruptedException {
        HttpResponse<String> response = connection.getRequest(query.getURI(baseuri), Connection.getHeaders(token));
        connection.checkResponseCode(response);
        try {
            return objectMapper.readValue(response.body(), CandleList.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse HistoricalData response", e);
        }
    }

    public static Screeners getMarketMovers(MarketMoversQuery query, String token) throws IOException, InterruptedException {
        HttpResponse<String> response = connection.getRequest(query.getURI(baseuri), Connection.getHeaders(token));
        connection.checkResponseCode(response);
        try {
            return objectMapper.readValue(response.body(), Screeners.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse MarketMovers response", e);
        }
    }

    public static MarketHours getMarketHours(MarketHoursQuery query, String token) throws IOException, InterruptedException {
        HttpResponse<String> response = connection.getRequest(query.getURI(baseuri), Connection.getHeaders(token));
        connection.checkResponseCode(response);
        try {
            return objectMapper.readValue(response.body(), MarketHours.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse MarketHours response", e);
        }
    }

    public static InstrumentResponse getInstruments(InstrumentSearchQuery query, String token) throws IOException, InterruptedException {
        HttpResponse<String> response = connection.getRequest(query.getURI(baseuri), Connection.getHeaders(token));
        connection.checkResponseCode(response);
        try {
            return objectMapper.readValue(response.body(), InstrumentResponse.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse Instruments response", e);
        }
    }

    public static InstrumentResponse getInstrumentByCUSIP(String cusip, String token) throws IOException, InterruptedException {
        HttpResponse<String> response = connection.getRequest(baseuri + "/instruments/" + cusip, Connection.getHeaders(token));
        connection.checkResponseCode(response);
        try {
            return objectMapper.readValue(response.body(), InstrumentResponse.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse Instrument response", e);
        }
    }
}
