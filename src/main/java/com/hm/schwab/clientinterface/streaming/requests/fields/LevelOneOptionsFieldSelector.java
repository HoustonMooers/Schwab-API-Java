package com.hm.schwab.clientinterface.streaming.requests.fields;

public class LevelOneOptionsFieldSelector extends FieldSelectBase {

    // Ticker symbol in upper case.
    public LevelOneOptionsFieldSelector selectSymbol() {
        selectedfields.add("0");
        return this;
    }

    // A company, index or fund name
    public LevelOneOptionsFieldSelector selectDescription() {
        selectedfields.add("1");
        return this;
    }

    // Current Bid Price
    public LevelOneOptionsFieldSelector selectBidPrice() {
        selectedfields.add("2");
        return this;
    }

    // Current Ask Price
    public LevelOneOptionsFieldSelector selectAskPrice() {
        selectedfields.add("3");
        return this;
    }

    // Price at which the last trade was matched
    public LevelOneOptionsFieldSelector selectLastPrice() {
        selectedfields.add("4");
        return this;
    }

    // Day's high trade price
    public LevelOneOptionsFieldSelector selectHighPrice() {
        selectedfields.add("5");
        return this;
    }

    // Day's low trade price
    public LevelOneOptionsFieldSelector selectLowPrice() {
        selectedfields.add("6");
        return this;
    }

    // Previous day's closing price
    public LevelOneOptionsFieldSelector selectClosePrice() {
        selectedfields.add("7");
        return this;
    }

    // Aggregated contracts traded throughout the day, including pre/post market hours.
    public LevelOneOptionsFieldSelector selectTotalVolume() {
        selectedfields.add("8");
        return this;
    }

    public LevelOneOptionsFieldSelector selectOpenInterest() {
        selectedfields.add("9");
        return this;
    }

    // Option Risk/Volatility Measurement/Implied
    public LevelOneOptionsFieldSelector selectVolatility() {
        selectedfields.add("10");
        return this;
    }

    // The value an option would have if it were exercised today.
    public LevelOneOptionsFieldSelector selectMoneyIntrinsicValue() {
        selectedfields.add("11");
        return this;
    }

    public LevelOneOptionsFieldSelector selectExpirationYear() {
        selectedfields.add("12");
        return this;
    }

    public LevelOneOptionsFieldSelector selectMultiplier() {
        selectedfields.add("13");
        return this;
    }

    // Number of decimal places
    public LevelOneOptionsFieldSelector selectDigits() {
        selectedfields.add("14");
        return this;
    }

    // Day's Open Price
    public LevelOneOptionsFieldSelector selectOpenPrice() {
        selectedfields.add("15");
        return this;
    }

    // Number of contracts for bid
    public LevelOneOptionsFieldSelector selectBidSize() {
        selectedfields.add("16");
        return this;
    }

    // Number of contracts for ask
    public LevelOneOptionsFieldSelector selectAskSize() {
        selectedfields.add("17");
        return this;
    }

    // Number of contracts traded with last trade
    public LevelOneOptionsFieldSelector selectLastSize() {
        selectedfields.add("18");
        return this;
    }

    // Current Last-Prev Close
    public LevelOneOptionsFieldSelector selectNetChange() {
        selectedfields.add("19");
        return this;
    }

    // Contract strike price
    public LevelOneOptionsFieldSelector selectStrikePrice() {
        selectedfields.add("20");
        return this;
    }

    public LevelOneOptionsFieldSelector selectContractType() {
        selectedfields.add("21");
        return this;
    }

    public LevelOneOptionsFieldSelector selectUnderlying() {
        selectedfields.add("22");
        return this;
    }

    public LevelOneOptionsFieldSelector selectExpirationMonth() {
        selectedfields.add("23");
        return this;
    }

    public LevelOneOptionsFieldSelector selectDeliverables() {
        selectedfields.add("24");
        return this;
    }

    public LevelOneOptionsFieldSelector selectTimeValue() {
        selectedfields.add("25");
        return this;
    }

    public LevelOneOptionsFieldSelector selectExpirationDay() {
        selectedfields.add("26");
        return this;
    }

    public LevelOneOptionsFieldSelector selectDaysToExpiration() {
        selectedfields.add("27");
        return this;
    }

    public LevelOneOptionsFieldSelector selectDelta() {
        selectedfields.add("28");
        return this;
    }

    public LevelOneOptionsFieldSelector selectGamma() {
        selectedfields.add("29");
        return this;
    }

    public LevelOneOptionsFieldSelector selectTheta() {
        selectedfields.add("30");
        return this;
    }

    public LevelOneOptionsFieldSelector selectVega() {
        selectedfields.add("31");
        return this;
    }

    public LevelOneOptionsFieldSelector selectRho() {
        selectedfields.add("32");
        return this;
    }

    public LevelOneOptionsFieldSelector selectSecurityStatus() {
        selectedfields.add("33");
        return this;
    }

    public LevelOneOptionsFieldSelector selectTheoreticalOptionValue() {
        selectedfields.add("34");
        return this;
    }

    public LevelOneOptionsFieldSelector selectUnderlyingPrice() {
        selectedfields.add("35");
        return this;
    }

    public LevelOneOptionsFieldSelector selectUVExpirationType() {
        selectedfields.add("36");
        return this;
    }

    // Mark Price
    public LevelOneOptionsFieldSelector selectMarkPrice() {
        selectedfields.add("37");
        return this;
    }

    // Last quote time in milliseconds since Epoch
    public LevelOneOptionsFieldSelector selectQuoteTimeInLong() {
        selectedfields.add("38");
        return this;
    }

    // Last trade time in milliseconds since Epoch
    public LevelOneOptionsFieldSelector selectTradeTimeInLong() {
        selectedfields.add("39");
        return this;
    }

    public LevelOneOptionsFieldSelector selectExchange() {
        selectedfields.add("40");
        return this;
    }

    // Display name of exchange
    public LevelOneOptionsFieldSelector selectExchangeName() {
        selectedfields.add("41");
        return this;
    }

    // Last Trading Day
    public LevelOneOptionsFieldSelector selectLastTradingDay() {
        selectedfields.add("42");
        return this;
    }

    public LevelOneOptionsFieldSelector selectSettlementType() {
        selectedfields.add("43");
        return this;
    }

    // Net Percentage Change
    public LevelOneOptionsFieldSelector selectNetPercentChange() {
        selectedfields.add("44");
        return this;
    }

    // Mark price net change
    public LevelOneOptionsFieldSelector selectMarkPriceNetChange() {
        selectedfields.add("45");
        return this;
    }

    // Mark price percentage change
    public LevelOneOptionsFieldSelector selectMarkPricePercentChange() {
        selectedfields.add("46");
        return this;
    }

    public LevelOneOptionsFieldSelector selectImpliedYield() {
        selectedfields.add("47");
        return this;
    }

    public LevelOneOptionsFieldSelector selectIsPennyPilot() {
        selectedfields.add("48");
        return this;
    }

    public LevelOneOptionsFieldSelector selectOptionRoot() {
        selectedfields.add("49");
        return this;
    }

    public LevelOneOptionsFieldSelector select52WeekHigh() {
        selectedfields.add("50");
        return this;
    }

    public LevelOneOptionsFieldSelector select52WeekLow() {
        selectedfields.add("51");
        return this;
    }

    public LevelOneOptionsFieldSelector selectIndicativeAskPrice() {
        selectedfields.add("52");
        return this;
    }

    public LevelOneOptionsFieldSelector selectIndicativeBidPrice() {
        selectedfields.add("53");
        return this;
    }

    // The latest time the indicative bid/ask prices updated in milliseconds since Epoch
    public LevelOneOptionsFieldSelector selectIndicativeQuoteTime() {
        selectedfields.add("54");
        return this;
    }

    public LevelOneOptionsFieldSelector selectExerciseType() {
        selectedfields.add("55");
        return this;
    }
}