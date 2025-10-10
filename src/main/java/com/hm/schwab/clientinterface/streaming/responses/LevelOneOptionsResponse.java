package com.hm.schwab.clientinterface.streaming.responses;

import java.util.Map;

public class LevelOneOptionsResponse extends Response {
    public LevelOneOptionsResponse(Map<String, Object> dataMap, long timestamp) {
        super(dataMap, timestamp);
    }

    public String getSymbol() {
        return (String) dataMap.get("key");
    }

    // A company, index or fund name
    public boolean hasDescription() {
        return dataMap.containsKey("1");
    }

    public String getDescription() {
        return (String) dataMap.get("1");
    }

    // Current Bid Price
    public boolean hasBidPrice() {
        return dataMap.containsKey("2");
    }

    public double getBidPrice() {
        return (Double) dataMap.get("2");
    }

    // Current Ask Price
    public boolean hasAskPrice() {
        return dataMap.containsKey("3");
    }

    public double getAskPrice() {
        return (Double) dataMap.get("3");
    }

    // Price at which the last trade was matched
    public boolean hasLastPrice() {
        return dataMap.containsKey("4");
    }

    public double getLastPrice() {
        return (Double) dataMap.get("4");
    }

    // Day's high trade price
    public boolean hasHighPrice() {
        return dataMap.containsKey("5");
    }

    public double getHighPrice() {
        return (Double) dataMap.get("5");
    }

    // Day's low trade price
    public boolean hasLowPrice() {
        return dataMap.containsKey("6");
    }

    public double getLowPrice() {
        return (Double) dataMap.get("6");
    }

    // Previous day's closing price
    public boolean hasClosePrice() {
        return dataMap.containsKey("7");
    }

    public double getClosePrice() {
        return (Double) dataMap.get("7");
    }

    // Aggregated contracts traded throughout the day, including pre/post market hours.
    public boolean hasTotalVolume() {
        return dataMap.containsKey("8");
    }

    public long getTotalVolume() {
        return (Long) dataMap.get("8");
    }

    public boolean hasOpenInterest() {
        return dataMap.containsKey("9");
    }

    public int getOpenInterest() {
        return (Integer) dataMap.get("9");
    }

    // Option Risk/Volatility Measurement/Implied
    public boolean hasVolatility() {
        return dataMap.containsKey("10");
    }

    public double getVolatility() {
        return (Double) dataMap.get("10");
    }

    // The value an option would have if it were exercised today. Basically, the intrinsic value is the amount by which the strike price of an option is profitable or in-the-money as compared to the underlying stock's price in the market.
    public boolean hasMoneyIntrinsicValue() {
        return dataMap.containsKey("11");
    }

    public double getMoneyIntrinsicValue() {
        return (Double) dataMap.get("11");
    }

    public boolean hasExpirationYear() {
        return dataMap.containsKey("12");
    }

    public int getExpirationYear() {
        return (Integer) dataMap.get("12");
    }

    public boolean hasMultiplier() {
        return dataMap.containsKey("13");
    }

    public double getMultiplier() {
        return (Double) dataMap.get("13");
    }

    // Number of decimal places
    public boolean hasDigits() {
        return dataMap.containsKey("14");
    }

    public int getDigits() {
        return (Integer) dataMap.get("14");
    }

    // Day's Open Price Yes No According to industry standard, only regular session trades set the open
    // If a stock does not trade during the regular session, then the open price is 0.
    // In the pre-market session, open is blank because pre-market session trades do not set the open.
    // Open is set to ZERO at 7:28 ET.
    public boolean hasOpenPrice() {
        return dataMap.containsKey("15");
    }

    public double getOpenPrice() {
        return (Double) dataMap.get("15");
    }

    // Number of contracts for bid
    public boolean hasBidSize() {
        return dataMap.containsKey("16");
    }

    public int getBidSize() {
        return (Integer) dataMap.get("16");
    }

    // Number of contracts for ask
    public boolean hasAskSize() {
        return dataMap.containsKey("17");
    }

    public int getAskSize() {
        return (Integer) dataMap.get("17");
    }

    // Number of contracts traded with last trade
    public boolean hasLastSize() {
        return dataMap.containsKey("18");
    }

    public int getLastSize() {
        return (Integer) dataMap.get("18");
    }

    // Current Last-Prev Close
    public boolean hasNetChange() {
        return dataMap.containsKey("19");
    }

    public double getNetChange() {
        return (Double) dataMap.get("19");
    }

    // Contract strike price
    public boolean hasStrikePrice() {
        return dataMap.containsKey("20");
    }

    public double getStrikePrice() {
        return (Double) dataMap.get("20");
    }

    public boolean hasContractType() {
        return dataMap.containsKey("21");
    }

    public char getContractType() {
        return (Character) dataMap.get("21");
    }

    public boolean hasUnderlying() {
        return dataMap.containsKey("22");
    }

    public String getUnderlying() {
        return (String) dataMap.get("22");
    }

    public boolean hasExpirationMonth() {
        return dataMap.containsKey("23");
    }

    public int getExpirationMonth() {
        return (Integer) dataMap.get("23");
    }

    public boolean hasDeliverables() {
        return dataMap.containsKey("24");
    }

    public String getDeliverables() {
        return (String) dataMap.get("24");
    }

    public boolean hasTimeValue() {
        return dataMap.containsKey("25");
    }

    public double getTimeValue() {
        return (Double) dataMap.get("25");
    }

    public boolean hasExpirationDay() {
        return dataMap.containsKey("26");
    }

    public int getExpirationDay() {
        return (Integer) dataMap.get("26");
    }

    public boolean hasDaysToExpiration() {
        return dataMap.containsKey("27");
    }

    public int getDaysToExpiration() {
        return (Integer) dataMap.get("27");
    }

    public boolean hasDelta() {
        return dataMap.containsKey("28");
    }

    public double getDelta() {
        return (Double) dataMap.get("28");
    }

    public boolean hasGamma() {
        return dataMap.containsKey("29");
    }

    public double getGamma() {
        return (Double) dataMap.get("29");
    }

    public boolean hasTheta() {
        return dataMap.containsKey("30");
    }

    public double getTheta() {
        return (Double) dataMap.get("30");
    }

    public boolean hasVega() {
        return dataMap.containsKey("31");
    }

    public double getVega() {
        return (Double) dataMap.get("31");
    }

    public boolean hasRho() {
        return dataMap.containsKey("32");
    }

    public double getRho() {
        return (Double) dataMap.get("32");
    }

    public boolean hasSecurityStatus() {
        return dataMap.containsKey("33");
    }

    public String getSecurityStatus() {
        return (String) dataMap.get("33");
    }

    public boolean hasTheoreticalOptionValue() {
        return dataMap.containsKey("34");
    }

    public double getTheoreticalOptionValue() {
        return (Double) dataMap.get("34");
    }

    public boolean hasUnderlyingPrice() {
        return dataMap.containsKey("35");
    }

    public double getUnderlyingPrice() {
        return (Double) dataMap.get("35");
    }

    public boolean hasUVExpirationType() {
        return dataMap.containsKey("36");
    }

    public char getUVExpirationType() {
        return (Character) dataMap.get("36");
    }

    // Mark Price
    public boolean hasMarkPrice() {
        return dataMap.containsKey("37");
    }

    public double getMarkPrice() {
        return (Double) dataMap.get("37");
    }

    // Last quote time in milliseconds since Epoch
    public boolean hasQuoteTimeInLong() {
        return dataMap.containsKey("38");
    }

    public long getQuoteTimeInLong() {
        return (Long) dataMap.get("38");
    }

    // Last trade time in milliseconds since Epoch
    public boolean hasTradeTimeInLong() {
        return dataMap.containsKey("39");
    }

    public long getTradeTimeInLong() {
        return (Long) dataMap.get("39");
    }

    public boolean hasExchange() {
        return dataMap.containsKey("40");
    }

    public char getExchange() {
        return (Character) dataMap.get("40");
    }

    // Display name of exchange
    public boolean hasExchangeName() {
        return dataMap.containsKey("41");
    }

    public String getExchangeName() {
        return (String) dataMap.get("41");
    }

    // Last Trading Day
    public boolean hasLastTradingDay() {
        return dataMap.containsKey("42");
    }

    public long getLastTradingDay() {
        return (Long) dataMap.get("42");
    }

    public boolean hasSettlementType() {
        return dataMap.containsKey("43");
    }

    public char getSettlementType() {
        return (Character) dataMap.get("43");
    }

    // Net Percentage Change
    public boolean hasNetPercentChange() {
        return dataMap.containsKey("44");
    }

    public double getNetPercentChange() {
        return (Double) dataMap.get("44");
    }

    // Mark price net change
    public boolean hasMarkPriceNetChange() {
        return dataMap.containsKey("45");
    }

    public double getMarkPriceNetChange() {
        return (Double) dataMap.get("45");
    }

    // Mark price percentage change
    public boolean hasMarkPricePercentChange() {
        return dataMap.containsKey("46");
    }

    public double getMarkPricePercentChange() {
        return (Double) dataMap.get("46");
    }

    public boolean hasImpliedYield() {
        return dataMap.containsKey("47");
    }

    public double getImpliedYield() {
        return (Double) dataMap.get("47");
    }

    public boolean hasisPennyPilot() {
        return dataMap.containsKey("48");
    }

    public boolean getisPennyPilot() {
        return (Boolean) dataMap.get("48");
    }

    public boolean hasOptionRoot() {
        return dataMap.containsKey("49");
    }

    public String getOptionRoot() {
        return (String) dataMap.get("49");
    }

    public boolean has52WeekHigh() {
        return dataMap.containsKey("50");
    }

    public double get52WeekHigh() {
        return (Double) dataMap.get("50");
    }

    public boolean has52WeekLow() {
        return dataMap.containsKey("51");
    }

    public double get52WeekLow() {
        return (Double) dataMap.get("51");
    }

    public boolean hasIndicativeAskPrice() {
        return dataMap.containsKey("52");
    }

    public double getIndicativeAskPrice() {
        return (Double) dataMap.get("52");
    }

    public boolean hasIndicativeBidPrice() {
        return dataMap.containsKey("53");
    }

    public double getIndicativeBidPrice() {
        return (Double) dataMap.get("53");
    }

    // The latest time the indicative bid/ask prices updated in milliseconds since Epoch
    public boolean hasIndicativeQuoteTime() {
        return dataMap.containsKey("54");
    }

    public long getIndicativeQuoteTime() {
        return (Long) dataMap.get("54");
    }

    public boolean hasExerciseType() {
        return dataMap.containsKey("55");
    }

    public char getExerciseType() {
        return (Character) dataMap.get("55");
    }
}