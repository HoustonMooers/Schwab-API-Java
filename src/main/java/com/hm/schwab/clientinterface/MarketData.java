package com.hm.schwab.clientinterface;

import java.io.IOException;
import java.net.http.HttpResponse;

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

    public static QuoteResponse getQuotes(QuoteQuery quotequery, String token) throws IOException, InterruptedException {
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
