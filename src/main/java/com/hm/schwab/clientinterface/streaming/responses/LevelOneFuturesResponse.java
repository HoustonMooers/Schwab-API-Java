package com.hm.schwab.clientinterface.streaming.responses;

import java.util.Map;

public class LevelOneFuturesResponse extends Response {   
    public LevelOneFuturesResponse(Map<String, Object> dataMap, long timestamp) {
        super(dataMap, timestamp);
    }

    public String getSymbol() {
        return (String) dataMap.get("key");
    }

    // Current Best Bid Price
    public boolean hasBidPrice() {
        return dataMap.containsKey("1");
    }

    public double getBidPrice() {
        return (Double) dataMap.get("1");
    }

    // Current Best Ask Price
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

    // Exchange with the best bid
    public boolean hasBidID() {
        return dataMap.containsKey("6");
    }

    public char getBidID() {
        return (Character) dataMap.get("6");
    }

    // Exchange with the best ask
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

    // Time of the last quote in milliseconds since epoch
    public boolean hasQuoteTime() {
        return dataMap.containsKey("10");
    }

    public long getQuoteTime() {
        return (Long) dataMap.get("10");
    }

    // Time of the last trade in milliseconds since epoch
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

    // Primary "listing" Exchange
    public boolean hasExchangeID() {
        return dataMap.containsKey("15");
    }

    public char getExchangeID() {
        return (Character) dataMap.get("15");
    }

    // Description of the product
    public boolean hasDescription() {
        return dataMap.containsKey("16");
    }

    public String getDescription() {
        return (String) dataMap.get("16");
    }

    // Exchange where last trade was executed
    public boolean hasLastID() {
        return dataMap.containsKey("17");
    }

    public char getLastID() {
        return (Character) dataMap.get("17");
    }

    // Day's Open Price
    public boolean hasOpenPrice() {
        return dataMap.containsKey("18");
    }

    public double getOpenPrice() {
        return (Double) dataMap.get("18");
    }

    // Current Last-Prev Close
    public boolean hasNetChange() {
        return dataMap.containsKey("19");
    }

    public double getNetChange() {
        return (Double) dataMap.get("19");
    }

    // Current percent change
    public boolean hasFuturePercentChange() {
        return dataMap.containsKey("20");
    }

    public double getFuturePercentChange() {
        return (Double) dataMap.get("20");
    }

    // Name of exchange
    public boolean hasExchangeName() {
        return dataMap.containsKey("21");
    }

    public String getExchangeName() {
        return (String) dataMap.get("21");
    }

    // Trading status of the symbol
    public boolean hasSecurityStatus() {
        return dataMap.containsKey("22");
    }

    public String getSecurityStatus() {
        return (String) dataMap.get("22");
    }

    // The total number of futures contracts that are not closed or delivered on a particular day
    public boolean hasOpenInterest() {
        return dataMap.containsKey("23");
    }

    public int getOpenInterest() {
        return (Integer) dataMap.get("23");
    }

    // Mark-to-Market value is calculated daily using current prices to determine profit/loss
    public boolean hasMark() {
        return dataMap.containsKey("24");
    }

    public double getMark() {
        return (Double) dataMap.get("24");
    }

    // Minimum price movement
    public boolean hasTick() {
        return dataMap.containsKey("25");
    }

    public double getTick() {
        return (Double) dataMap.get("25");
    }

    // Minimum amount that the price of the market can change
    public boolean hasTickAmount() {
        return dataMap.containsKey("26");
    }

    public double getTickAmount() {
        return (Double) dataMap.get("26");
    }

    // Futures product
    public boolean hasProduct() {
        return dataMap.containsKey("27");
    }

    public String getProduct() {
        return (String) dataMap.get("27");
    }

    // Display in fraction or decimal format. N/A N/A Set from FSP Config
    // format is < numerator decimals to display>, < implied denominator>
    // where D=decimal format, no fractional display
    // Equity futures will be "D,D" to indicate pure decimal.
    // Fixed income futures are fractional, typically "3,32".
    // Below is an example for "3,32": 
    // price=101.8203125
    // =101 + 0.8203125 (split into whole and fractional)
    // =101 + 26.25/32 (Multiply fractional by implied denomiator)
    // =101 + 26.2/32 (round to numerator decimals to display)
    // =101'262 (display in fractional format)
    public boolean hasFuturePriceFormat() {
        return dataMap.containsKey("28");
    }

    public String getFuturePriceFormat() {
        return (String) dataMap.get("28");
    }

    // Trading hours
    public boolean hasFutureTradingHours() {
        return dataMap.containsKey("29");
    }

    public String getFutureTradingHours() {
        return (String) dataMap.get("29");
    }

    // Flag to indicate if this future contract is tradable
    public boolean hasFutureIsTradable() {
        return dataMap.containsKey("30");
    }

    public boolean getFutureIsTradable() {
        return (Boolean) dataMap.get("30");
    }

    // Point value
    public boolean hasFutureMultiplier() {
        return dataMap.containsKey("31");
    }

    public double getFutureMultiplier() {
        return (Double) dataMap.get("31");
    }

    // Indicates if this contract is active
    public boolean hasFutureIsActive() {
        return dataMap.containsKey("32");
    }

    public boolean getFutureIsActive() {
        return (Boolean) dataMap.get("32");
    }

    // Closing price
    public boolean hasFutureSettlementPrice() {
        return dataMap.containsKey("33");
    }

    public double getFutureSettlementPrice() {
        return (Double) dataMap.get("33");
    }

    // Symbol of the active contract
    public boolean hasFutureActiveSymbol() {
        return dataMap.containsKey("34");
    }

    public String getFutureActiveSymbol() {
        return (String) dataMap.get("34");
    }

    // Expiration date of this contract
    public boolean hasFutureExpirationDate() {
        return dataMap.containsKey("35");
    }

    public long getFutureExpirationDate() {
        return (Long) dataMap.get("35");
    }

    public boolean hasExpirationStyle() {
        return dataMap.containsKey("36");
    }

    public String getExpirationStyle() {
        return (String) dataMap.get("36");
    }

    // Time of the last ask-side quote in milliseconds since epoch
    public boolean hasAskTime() {
        return dataMap.containsKey("37");
    }

    public long getAskTime() {
        return (Long) dataMap.get("37");
    }

    // Time of the last bid-side quote in milliseconds since epoch
    public boolean hasBidTime() {
        return dataMap.containsKey("38");
    }

    public long getBidTime() {
        return (Long) dataMap.get("38");
    }

    // Indicates if this contract has quoted during the active session
    public boolean hasQuotedInSession() {
        return dataMap.containsKey("39");
    }

    public boolean getQuotedInSession() {
        return (Boolean) dataMap.get("39");
    }

    // Expiration date of this contract
    public boolean hasSettlementDate() {
        return dataMap.containsKey("40");
    }

    public long getSettlementDate() {
        return (Long) dataMap.get("40");
    }
}