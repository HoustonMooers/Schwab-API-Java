package com.hm.schwab.clientinterface.streaming.responses;

import java.util.Map;

public class ChartEquityResponse extends Response {
    public ChartEquityResponse(Map<String, Object> dataMap, long timestamp) {
        super(dataMap, timestamp);
    }

    public String getSymbol() {
        return (String) dataMap.get("key");
    }

    // Opening price for the minute
    public boolean hasOpenPrice() {
        return dataMap.containsKey("1");
    }

    public double getOpenPrice() {
        return (Double) dataMap.get("1");
    }

    // Highest price for the minute
    public boolean hasHighPrice() {
        return dataMap.containsKey("2");
    }

    public double getHighPrice() {
        return (Double) dataMap.get("2");
    }

    // Chart's lowest price for the minute
    public boolean hasLowPrice() {
        return dataMap.containsKey("3");
    }

    public double getLowPrice() {
        return (Double) dataMap.get("3");
    }

    // Closing price for the minute
    public boolean hasClosePrice() {
        return dataMap.containsKey("4");
    }

    public double getClosePrice() {
        return (Double) dataMap.get("4");
    }

    // Total volume for the minute
    public boolean hasVolume() {
        return dataMap.containsKey("5");
    }

    public double getVolume() {
        return (Double) dataMap.get("5");
    }

    // Identifies the candle minute
    public boolean hasSequence() {
        return dataMap.containsKey("6");
    }

    public long getSequence() {
        return (Long) dataMap.get("6");
    }

    // Milliseconds since Epoch
    public boolean hasChartTime() {
        return dataMap.containsKey("7");
    }

    public long getChartTime() {
        return (Long) dataMap.get("7");
    }

    public boolean hasChartDay() {
        return dataMap.containsKey("8");
    }

    public int getChartDay() {
        return (Integer) dataMap.get("8");
    }
}