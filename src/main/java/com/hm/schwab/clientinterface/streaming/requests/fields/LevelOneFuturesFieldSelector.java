package com.hm.schwab.clientinterface.streaming.requests.fields;

public class LevelOneFuturesFieldSelector extends FieldSelectBase {

    public LevelOneFuturesFieldSelector selectSymbol() {
        selectedfields.add("0");
        return this;
    }

    // Current Best Bid Price
    public LevelOneFuturesFieldSelector selectBidPrice() {
        selectedfields.add("1");
        return this;
    }

    // Current Best Ask Price
    public LevelOneFuturesFieldSelector selectAskPrice() {
        selectedfields.add("2");
        return this;
    }

    // Price at which the last trade was matched
    public LevelOneFuturesFieldSelector selectLastPrice() {
        selectedfields.add("3");
        return this;
    }

    // Number of contracts for bid
    public LevelOneFuturesFieldSelector selectBidSize() {
        selectedfields.add("4");
        return this;
    }

    // Number of contracts for ask
    public LevelOneFuturesFieldSelector selectAskSize() {
        selectedfields.add("5");
        return this;
    }

    // Exchange with the best bid
    public LevelOneFuturesFieldSelector selectBidID() {
        selectedfields.add("6");
        return this;
    }

    // Exchange with the best ask
    public LevelOneFuturesFieldSelector selectAskID() {
        selectedfields.add("7");
        return this;
    }

    // Aggregated contracts traded throughout the day, including pre/post market hours.
    public LevelOneFuturesFieldSelector selectTotalVolume() {
        selectedfields.add("8");
        return this;
    }

    // Number of contracts traded with last trade
    public LevelOneFuturesFieldSelector selectLastSize() {
        selectedfields.add("9");
        return this;
    }

    // Time of the last quote in milliseconds since epoch
    public LevelOneFuturesFieldSelector selectQuoteTime() {
        selectedfields.add("10");
        return this;
    }

    // Time of the last trade in milliseconds since epoch
    public LevelOneFuturesFieldSelector selectTradeTime() {
        selectedfields.add("11");
        return this;
    }

    // Day's high trade price
    public LevelOneFuturesFieldSelector selectHighPrice() {
        selectedfields.add("12");
        return this;
    }

    // Day's low trade price
    public LevelOneFuturesFieldSelector selectLowPrice() {
        selectedfields.add("13");
        return this;
    }

    // Previous day's closing price
    public LevelOneFuturesFieldSelector selectClosePrice() {
        selectedfields.add("14");
        return this;
    }

    // Primary "listing" Exchange
    public LevelOneFuturesFieldSelector selectExchangeID() {
        selectedfields.add("15");
        return this;
    }

    // Description of the product
    public LevelOneFuturesFieldSelector selectDescription() {
        selectedfields.add("16");
        return this;
    }

    // Exchange where last trade was executed
    public LevelOneFuturesFieldSelector selectLastID() {
        selectedfields.add("17");
        return this;
    }

    // Day's Open Price
    public LevelOneFuturesFieldSelector selectOpenPrice() {
        selectedfields.add("18");
        return this;
    }

    // Current Last-Prev Close
    public LevelOneFuturesFieldSelector selectNetChange() {
        selectedfields.add("19");
        return this;
    }

    // Current percent change
    public LevelOneFuturesFieldSelector selectFuturePercentChange() {
        selectedfields.add("20");
        return this;
    }

    // Name of exchange
    public LevelOneFuturesFieldSelector selectExchangeName() {
        selectedfields.add("21");
        return this;
    }

    // Trading status of the symbol
    public LevelOneFuturesFieldSelector selectSecurityStatus() {
        selectedfields.add("22");
        return this;
    }

    // The total number of futures contracts that are not closed or delivered on a particular day
    public LevelOneFuturesFieldSelector selectOpenInterest() {
        selectedfields.add("23");
        return this;
    }

    // Mark-to-Market value is calculated daily using current prices to determine profit/loss
    public LevelOneFuturesFieldSelector selectMark() {
        selectedfields.add("24");
        return this;
    }

    // Minimum price movement
    public LevelOneFuturesFieldSelector selectTick() {
        selectedfields.add("25");
        return this;
    }

    // Minimum amount that the price of the market can change
    public LevelOneFuturesFieldSelector selectTickAmount() {
        selectedfields.add("26");
        return this;
    }

    // Futures product
    public LevelOneFuturesFieldSelector selectProduct() {
        selectedfields.add("27");
        return this;
    }

    // Display in fraction or decimal format.
    public LevelOneFuturesFieldSelector selectFuturePriceFormat() {
        selectedfields.add("28");
        return this;
    }

    // Trading hours
    public LevelOneFuturesFieldSelector selectFutureTradingHours() {
        selectedfields.add("29");
        return this;
    }

    // Flag to indicate if this future contract is tradable
    public LevelOneFuturesFieldSelector selectFutureIsTradable() {
        selectedfields.add("30");
        return this;
    }

    // Point value
    public LevelOneFuturesFieldSelector selectFutureMultiplier() {
        selectedfields.add("31");
        return this;
    }

    // Indicates if this contract is active
    public LevelOneFuturesFieldSelector selectFutureIsActive() {
        selectedfields.add("32");
        return this;
    }

    // Closing price
    public LevelOneFuturesFieldSelector selectFutureSettlementPrice() {
        selectedfields.add("33");
        return this;
    }

    // Symbol of the active contract
    public LevelOneFuturesFieldSelector selectFutureActiveSymbol() {
        selectedfields.add("34");
        return this;
    }

    // Expiration date of this contract
    public LevelOneFuturesFieldSelector selectFutureExpirationDate() {
        selectedfields.add("35");
        return this;
    }

    public LevelOneFuturesFieldSelector selectExpirationStyle() {
        selectedfields.add("36");
        return this;
    }

    // Time of the last ask-side quote in milliseconds since epoch
    public LevelOneFuturesFieldSelector selectAskTime() {
        selectedfields.add("37");
        return this;
    }

    // Time of the last bid-side quote in milliseconds since epoch
    public LevelOneFuturesFieldSelector selectBidTime() {
        selectedfields.add("38");
        return this;
    }

    // Indicates if this contract has quoted during the active session
    public LevelOneFuturesFieldSelector selectQuotedInSession() {
        selectedfields.add("39");
        return this;
    }

    // Expiration date of this contract
    public LevelOneFuturesFieldSelector selectSettlementDate() {
        selectedfields.add("40");
        return this;
    }
}