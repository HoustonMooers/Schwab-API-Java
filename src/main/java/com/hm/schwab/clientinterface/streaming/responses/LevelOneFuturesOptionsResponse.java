package com.hm.schwab.clientinterface.streaming.responses;

import java.util.Map;

public class LevelOneFuturesOptionsResponse extends Response {
    public LevelOneFuturesOptionsResponse(Map<String, Object> dataMap, long timestamp) {
        super(dataMap, timestamp);
    }

    // Ticker symbol in upper case.
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

    // Number of contracts for bid
    public boolean hasBidSize() {
        return dataMap.containsKey("4");
    }

    public long getBidSize() {
        return (Long) dataMap.get("4");
    }

    // Number of contracts for ask
    public boolean hasAskSize() {
        return dataMap.containsKey("5");
    }

    public long getAskSize() {
        return (Long) dataMap.get("5");
    }

    // Exchange with the bid
    public boolean hasBidID() {
        return dataMap.containsKey("6");
    }

    public char getBidID() {
        return (Character) dataMap.get("6");
    }

    // Exchange with the ask
    public boolean hasAskID() {
        return dataMap.containsKey("7");
    }

    public char getAskID() {
        return (Character) dataMap.get("7");
    }

    // Aggregated contracts traded throughout the day, including pre/post market hours.
    public boolean hasTotalVolume() {
        return dataMap.containsKey("8");
    }

    public long getTotalVolume() {
        return (Long) dataMap.get("8");
    }

    // Number of contracts traded with last trade
    public boolean hasLastSize() {
        return dataMap.containsKey("9");
    }

    public long getLastSize() {
        return (Long) dataMap.get("9");
    }

    // Trade time of the last quote in milliseconds since epoch
    public boolean hasQuoteTime() {
        return dataMap.containsKey("10");
    }

    public long getQuoteTime() {
        return (Long) dataMap.get("10");
    }

    // Trade time of the last trade in milliseconds since epoch
    public boolean hasTradeTime() {
        return dataMap.containsKey("11");
    }

    public long getTradeTime() {
        return (Long) dataMap.get("11");
    }

    // Day's high trade price
    public boolean hasHighPrice() {
        return dataMap.containsKey("12");
    }

    public double getHighPrice() {
        return (Double) dataMap.get("12");
    }

    // Day's low trade price
    public boolean hasLowPrice() {
        return dataMap.containsKey("13");
    }

    public double getLowPrice() {
        return (Double) dataMap.get("13");
    }

    // Previous day's closing price
    public boolean hasClosePrice() {
        return dataMap.containsKey("14");
    }

    public double getClosePrice() {
        return (Double) dataMap.get("14");
    }

    // Exchange where last trade was executed
    public boolean hasLastID() {
        return dataMap.containsKey("15");
    }

    public char getLastID() {
        return (Character) dataMap.get("15");
    }

    // Description of the product
    public boolean hasDescription() {
        return dataMap.containsKey("16");
    }

    public String getDescription() {
        return (String) dataMap.get("16");
    }

    // Day's Open Price
    public boolean hasOpenPrice() {
        return dataMap.containsKey("17");
    }

    public double getOpenPrice() {
        return (Double) dataMap.get("17");
    }

    public boolean hasOpenInterest() {
        return dataMap.containsKey("18");
    }

    public double getOpenInterest() {
        return (Double) dataMap.get("18");
    }

    // Mark-to-Market value is calculated daily using current prices to determine profit/loss
    public boolean hasMark() {
        return dataMap.containsKey("19");
    }

    public double getMark() {
        return (Double) dataMap.get("19");
    }

    // Minimum price movement
    public boolean hasTick() {
        return dataMap.containsKey("20");
    }

    public double getTick() {
        return (Double) dataMap.get("20");
    }

    // Minimum amount that the price of the market can change
    public boolean hasTickAmount() {
        return dataMap.containsKey("21");
    }

    public double getTickAmount() {
        return (Double) dataMap.get("21");
    }

    // Point value
    public boolean hasFutureMultiplier() {
        return dataMap.containsKey("22");
    }

    public double getFutureMultiplier() {
        return (Double) dataMap.get("22");
    }

    // Closing price
    public boolean hasFutureSettlementPrice() {
        return dataMap.containsKey("23");
    }

    public double getFutureSettlementPrice() {
        return (Double) dataMap.get("23");
    }

    // Underlying symbol
    public boolean hasUnderlyingSymbol() {
        return dataMap.containsKey("24");
    }

    public String getUnderlyingSymbol() {
        return (String) dataMap.get("24");
    }

    // Strike Price
    public boolean hasStrikePrice() {
        return dataMap.containsKey("25");
    }

    public double getStrikePrice() {
        return (Double) dataMap.get("25");
    }

    // Expiration date of this contract
    public boolean hasFutureExpirationDate() {
        return dataMap.containsKey("26");
    }

    public long getFutureExpirationDate() {
        return (Long) dataMap.get("26");
    }

    public boolean hasExpirationStyle() {
        return dataMap.containsKey("27");
    }

    public String getExpirationStyle() {
        return (String) dataMap.get("27");
    }

    public boolean hasContractType() {
        return dataMap.containsKey("28");
    }

    public char getContractType() {
        return (Character) dataMap.get("28");
    }

    public boolean hasSecurityStatus() {
        return dataMap.containsKey("29");
    }

    public String getSecurityStatus() {
        return (String) dataMap.get("29");
    }

    public boolean hasExchange() {
        return dataMap.containsKey("30");
    }

    public char getExchange() {
        return (Character) dataMap.get("30");
    }

    // Display name of exchange
    public boolean hasExchangeName() {
        return dataMap.containsKey("31");
    }

    public String getExchangeName() {
        return (String) dataMap.get("31");
    }
}