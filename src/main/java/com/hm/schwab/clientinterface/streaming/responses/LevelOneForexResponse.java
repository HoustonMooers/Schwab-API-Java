package com.hm.schwab.clientinterface.streaming.responses;

import java.util.Map;

public class LevelOneForexResponse extends Response {
    public LevelOneForexResponse(Map<String, Object> dataMap, long timestamp) {
        super(dataMap, timestamp);
    }

    public String getSymbol() {
        return (String) dataMap.get("key");
    }

    // Current Bid Price
    public boolean hasBidPrice() {
        return dataMap.containsKey("1");
    }

    public double getBidPrice() {
        return (Double) dataMap.get("1");
    }

    // Current Ask Price
    public boolean hasAskPrice() {
        return dataMap.containsKey("2");
    }

    public double getAskPrice() {
        return (Double) dataMap.get("2");
    }

    // Price at which the last trade was matched
    public boolean hasLastPrice() {
        return dataMap.containsKey("3");
    }

    public double getLastPrice() {
        return (Double) dataMap.get("3");
    }

    // Number of currency pairs for bid
    public boolean hasBidSize() {
        return dataMap.containsKey("4");
    }

    public long getBidSize() {
        return (Long) dataMap.get("4");
    }

    // Number of currency pairs for ask
    public boolean hasAskSize() {
        return dataMap.containsKey("5");
    }

    public long getAskSize() {
        return (Long) dataMap.get("5");
    }

    // Aggregated currency pairs traded throughout the day, including pre/post market hours.
    public boolean hasTotalVolume() {
        return dataMap.containsKey("6");
    }

    public long getTotalVolume() {
        return (Long) dataMap.get("6");
    }

    // Number of currency pairs traded with last trade
    public boolean hasLastSize() {
        return dataMap.containsKey("7");
    }

    public long getLastSize() {
        return (Long) dataMap.get("7");
    }

    // Trade time of the last quote in milliseconds since epoch
    public boolean hasQuoteTime() {
        return dataMap.containsKey("8");
    }

    public long getQuoteTime() {
        return (Long) dataMap.get("8");
    }

    // Trade time of the last trade in milliseconds since epoch
    public boolean hasTradeTime() {
        return dataMap.containsKey("9");
    }

    public long getTradeTime() {
        return (Long) dataMap.get("9");
    }

    // Day's high trade price
    public boolean hasHighPrice() {
        return dataMap.containsKey("10");
    }

    public double getHighPrice() {
        return (Double) dataMap.get("10");
    }

    // Day's low trade price
    public boolean hasLowPrice() {
        return dataMap.containsKey("11");
    }

    public double getLowPrice() {
        return (Double) dataMap.get("11");
    }

    // Previous day's closing price
    public boolean hasClosePrice() {
        return dataMap.containsKey("12");
    }

    public double getClosePrice() {
        return (Double) dataMap.get("12");
    }

    public boolean hasExchange() {
        return dataMap.containsKey("13");
    }

    public char getExchange() {
        return (Character) dataMap.get("13");
    }

    // Description of the product
    public boolean hasDescription() {
        return dataMap.containsKey("14");
    }

    public String getDescription() {
        return (String) dataMap.get("14");
    }

    // Day's Open Price
    public boolean hasOpenPrice() {
        return dataMap.containsKey("15");
    }

    public double getOpenPrice() {
        return (Double) dataMap.get("15");
    }

    // Current Last-Prev Close
    public boolean hasNetChange() {
        return dataMap.containsKey("16");
    }

    public double getNetChange() {
        return (Double) dataMap.get("16");
    }

    // Current percent change
    public boolean hasPercentChange() {
        return dataMap.containsKey("17");
    }

    public double getPercentChange() {
        return (Double) dataMap.get("17");
    }

    // Name of exchange
    public boolean hasExchangeName() {
        return dataMap.containsKey("18");
    }

    public String getExchangeName() {
        return (String) dataMap.get("18");
    }

    // Valid decimal points
    public boolean hasDigits() {
        return dataMap.containsKey("19");
    }

    public int getDigits() {
        return (Integer) dataMap.get("19");
    }

    // Trading status of the symbol
    public boolean hasSecurityStatus() {
        return dataMap.containsKey("20");
    }

    public String getSecurityStatus() {
        return (String) dataMap.get("20");
    }

    // Minimum price movement
    public boolean hasTick() {
        return dataMap.containsKey("21");
    }

    public double getTick() {
        return (Double) dataMap.get("21");
    }

    // Minimum amount that the price of the market can change
    public boolean hasTickAmount() {
        return dataMap.containsKey("22");
    }

    public double getTickAmount() {
        return (Double) dataMap.get("22");
    }

    // Product name
    public boolean hasProduct() {
        return dataMap.containsKey("23");
    }

    public String getProduct() {
        return (String) dataMap.get("23");
    }

    // Trading hours
    public boolean hasTradingHours() {
        return dataMap.containsKey("24");
    }

    public String getTradingHours() {
        return (String) dataMap.get("24");
    }

    // Flag to indicate if this forex is tradable
    public boolean hasIsTradable() {
        return dataMap.containsKey("25");
    }

    public boolean getIsTradable() {
        return (Boolean) dataMap.get("25");
    }

    public boolean hasMarketMaker() {
        return dataMap.containsKey("26");
    }

    public String getMarketMaker() {
        return (String) dataMap.get("26");
    }

    // Highest price traded in the past 12 months, or 52 weeks
    public boolean has52WeekHigh() {
        return dataMap.containsKey("27");
    }

    public double get52WeekHigh() {
        return (Double) dataMap.get("27");
    }

    // Lowest price traded in the past 12 months, or 52 weeks
    public boolean has52WeekLow() {
        return dataMap.containsKey("28");
    }

    public double get52WeekLow() {
        return (Double) dataMap.get("28");
    }

    // Mark-to-Market value is calculated daily using current prices to determine profit/loss
    public boolean hasMark() {
        return dataMap.containsKey("29");
    }

    public double getMark() {
        return (Double) dataMap.get("29");
    }
}