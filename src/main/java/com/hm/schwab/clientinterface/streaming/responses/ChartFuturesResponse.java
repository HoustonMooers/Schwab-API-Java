package com.hm.schwab.clientinterface.streaming.responses;

import java.util.Map;

public class ChartFuturesResponse extends Response {
    public ChartFuturesResponse(Map<String, Object> dataMap, long timestamp) {
        super(dataMap, timestamp);
    }

    // Ticker symbol in upper case.
    public String getSymbol() {
        return (String) dataMap.get("0");
    }

    // Milliseconds since Epoch
    public boolean hasChartTime() {
        return dataMap.containsKey("1");
    }

    public long getChartTime() {
        return (Long) dataMap.get("1");
    }

    // Opening price for the minute
    public boolean hasOpenPrice() {
        return dataMap.containsKey("2");
    }

    public double getOpenPrice() {
        return (Double) dataMap.get("2");
    }

    // Highest price for the minute
    public boolean hasHighPrice() {
        return dataMap.containsKey("3");
    }

    public double getHighPrice() {
        return (Double) dataMap.get("3");
    }

    // Chart's lowest price for the minute
    public boolean hasLowPrice() {
        return dataMap.containsKey("4");
    }

    public double getLowPrice() {
        return (Double) dataMap.get("4");
    }

    // Closing price for the minute
    public boolean hasClosePrice() {
        return dataMap.containsKey("5");
    }

    public double getClosePrice() {
        return (Double) dataMap.get("5");
    }

    // Total volume for the minute
    public boolean hasVolume() {
        return dataMap.containsKey("6");
    }

    public double getVolume() {
        return (Double) dataMap.get("6");
    }
}