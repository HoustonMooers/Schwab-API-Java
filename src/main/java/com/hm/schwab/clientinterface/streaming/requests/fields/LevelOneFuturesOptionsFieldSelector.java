package com.hm.schwab.clientinterface.streaming.requests.fields;

public class LevelOneFuturesOptionsFieldSelector extends FieldSelectBase {

    // Ticker symbol in upper case.
    public LevelOneFuturesOptionsFieldSelector selectSymbol() {
        selectedfields.add("0");
        return this;
    }

    // Current Bid Price
    public LevelOneFuturesOptionsFieldSelector selectBidPrice() {
        selectedfields.add("1");
        return this;
    }

    // Current Ask Price
    public LevelOneFuturesOptionsFieldSelector selectAskPrice() {
        selectedfields.add("2");
        return this;
    }

    // Price at which the last trade was matched
    public LevelOneFuturesOptionsFieldSelector selectLastPrice() {
        selectedfields.add("3");
        return this;
    }

    // Number of contracts for bid
    public LevelOneFuturesOptionsFieldSelector selectBidSize() {
        selectedfields.add("4");
        return this;
    }

    // Number of contracts for ask
    public LevelOneFuturesOptionsFieldSelector selectAskSize() {
        selectedfields.add("5");
        return this;
    }

    // Exchange with the bid
    public LevelOneFuturesOptionsFieldSelector selectBidID() {
        selectedfields.add("6");
        return this;
    }

    // Exchange with the ask
    public LevelOneFuturesOptionsFieldSelector selectAskID() {
        selectedfields.add("7");
        return this;
    }

    // Aggregated contracts traded throughout the day, including pre/post market hours.
    public LevelOneFuturesOptionsFieldSelector selectTotalVolume() {
        selectedfields.add("8");
        return this;
    }

    // Number of contracts traded with last trade
    public LevelOneFuturesOptionsFieldSelector selectLastSize() {
        selectedfields.add("9");
        return this;
    }

    // Trade time of the last quote in milliseconds since epoch
    public LevelOneFuturesOptionsFieldSelector selectQuoteTime() {
        selectedfields.add("10");
        return this;
    }

    // Trade time of the last trade in milliseconds since epoch
    public LevelOneFuturesOptionsFieldSelector selectTradeTime() {
        selectedfields.add("11");
        return this;
    }

    // Day's high trade price
    public LevelOneFuturesOptionsFieldSelector selectHighPrice() {
        selectedfields.add("12");
        return this;
    }

    // Day's low trade price
    public LevelOneFuturesOptionsFieldSelector selectLowPrice() {
        selectedfields.add("13");
        return this;
    }

    // Previous day's closing price
    public LevelOneFuturesOptionsFieldSelector selectClosePrice() {
        selectedfields.add("14");
        return this;
    }

    // Exchange where last trade was executed
    public LevelOneFuturesOptionsFieldSelector selectLastID() {
        selectedfields.add("15");
        return this;
    }

    // Description of the product
    public LevelOneFuturesOptionsFieldSelector selectDescription() {
        selectedfields.add("16");
        return this;
    }

    // Day's Open Price
    public LevelOneFuturesOptionsFieldSelector selectOpenPrice() {
        selectedfields.add("17");
        return this;
    }

    public LevelOneFuturesOptionsFieldSelector selectOpenInterest() {
        selectedfields.add("18");
        return this;
    }

    // Mark-to-Market value is calculated daily using current prices to determine profit/loss
    public LevelOneFuturesOptionsFieldSelector selectMark() {
        selectedfields.add("19");
        return this;
    }

    // Minimum price movement
    public LevelOneFuturesOptionsFieldSelector selectTick() {
        selectedfields.add("20");
        return this;
    }

    // Minimum amount that the price of the market can change
    public LevelOneFuturesOptionsFieldSelector selectTickAmount() {
        selectedfields.add("21");
        return this;
    }

    // Point value
    public LevelOneFuturesOptionsFieldSelector selectFutureMultiplier() {
        selectedfields.add("22");
        return this;
    }

    // Closing price
    public LevelOneFuturesOptionsFieldSelector selectFutureSettlementPrice() {
        selectedfields.add("23");
        return this;
    }

    // Underlying symbol
    public LevelOneFuturesOptionsFieldSelector selectUnderlyingSymbol() {
        selectedfields.add("24");
        return this;
    }

    // Strike Price
    public LevelOneFuturesOptionsFieldSelector selectStrikePrice() {
        selectedfields.add("25");
        return this;
    }

    // Expiration date of this contract
    public LevelOneFuturesOptionsFieldSelector selectFutureExpirationDate() {
        selectedfields.add("26");
        return this;
    }

    public LevelOneFuturesOptionsFieldSelector selectExpirationStyle() {
        selectedfields.add("27");
        return this;
    }

    public LevelOneFuturesOptionsFieldSelector selectContractType() {
        selectedfields.add("28");
        return this;
    }

    public LevelOneFuturesOptionsFieldSelector selectSecurityStatus() {
        selectedfields.add("29");
        return this;
    }

    public LevelOneFuturesOptionsFieldSelector selectExchange() {
        selectedfields.add("30");
        return this;
    }

    // Display name of exchange
    public LevelOneFuturesOptionsFieldSelector selectExchangeName() {
        selectedfields.add("31");
        return this;
    }
}