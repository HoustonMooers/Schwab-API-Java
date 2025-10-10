package com.hm.schwab.clientinterface.streaming.requests.fields;

public class LevelOneForexFieldSelector extends FieldSelectBase {

    // Ticker symbol in upper case.
    public LevelOneForexFieldSelector selectSymbol() {
        selectedfields.add("0");
        return this;
    }

    // Current Bid Price
    public LevelOneForexFieldSelector selectBidPrice() {
        selectedfields.add("1");
        return this;
    }

    // Current Ask Price
    public LevelOneForexFieldSelector selectAskPrice() {
        selectedfields.add("2");
        return this;
    }

    // Price at which the last trade was matched
    public LevelOneForexFieldSelector selectLastPrice() {
        selectedfields.add("3");
        return this;
    }

    // Number of currency pairs for bid
    public LevelOneForexFieldSelector selectBidSize() {
        selectedfields.add("4");
        return this;
    }

    // Number of currency pairs for ask
    public LevelOneForexFieldSelector selectAskSize() {
        selectedfields.add("5");
        return this;
    }

    // Aggregated currency pairs traded throughout the day, including pre/post market hours.
    public LevelOneForexFieldSelector selectTotalVolume() {
        selectedfields.add("6");
        return this;
    }

    // Number of currency pairs traded with last trade
    public LevelOneForexFieldSelector selectLastSize() {
        selectedfields.add("7");
        return this;
    }

    // Trade time of the last quote in milliseconds since epoch
    public LevelOneForexFieldSelector selectQuoteTime() {
        selectedfields.add("8");
        return this;
    }

    // Trade time of the last trade in milliseconds since epoch
    public LevelOneForexFieldSelector selectTradeTime() {
        selectedfields.add("9");
        return this;
    }

    // Day's high trade price
    public LevelOneForexFieldSelector selectHighPrice() {
        selectedfields.add("10");
        return this;
    }

    // Day's low trade price
    public LevelOneForexFieldSelector selectLowPrice() {
        selectedfields.add("11");
        return this;
    }

    // Previous day's closing price
    public LevelOneForexFieldSelector selectClosePrice() {
        selectedfields.add("12");
        return this;
    }

    public LevelOneForexFieldSelector selectExchange() {
        selectedfields.add("13");
        return this;
    }

    // Description of the product
    public LevelOneForexFieldSelector selectDescription() {
        selectedfields.add("14");
        return this;
    }

    // Day's Open Price
    public LevelOneForexFieldSelector selectOpenPrice() {
        selectedfields.add("15");
        return this;
    }

    // Current Last-Prev Close
    public LevelOneForexFieldSelector selectNetChange() {
        selectedfields.add("16");
        return this;
    }

    // Current percent change
    public LevelOneForexFieldSelector selectPercentChange() {
        selectedfields.add("17");
        return this;
    }

    // Name of exchange
    public LevelOneForexFieldSelector selectExchangeName() {
        selectedfields.add("18");
        return this;
    }

    // Valid decimal points
    public LevelOneForexFieldSelector selectDigits() {
        selectedfields.add("19");
        return this;
    }

    // Trading status of the symbol
    public LevelOneForexFieldSelector selectSecurityStatus() {
        selectedfields.add("20");
        return this;
    }

    // Minimum price movement
    public LevelOneForexFieldSelector selectTick() {
        selectedfields.add("21");
        return this;
    }

    // Minimum amount that the price of the market can change
    public LevelOneForexFieldSelector selectTickAmount() {
        selectedfields.add("22");
        return this;
    }

    // Product name
    public LevelOneForexFieldSelector selectProduct() {
        selectedfields.add("23");
        return this;
    }

    // Trading hours
    public LevelOneForexFieldSelector selectTradingHours() {
        selectedfields.add("24");
        return this;
    }

    // Flag to indicate if this forex is tradable
    public LevelOneForexFieldSelector selectIsTradable() {
        selectedfields.add("25");
        return this;
    }

    public LevelOneForexFieldSelector selectMarketMaker() {
        selectedfields.add("26");
        return this;
    }

    // Highest price traded in the past 12 months, or 52 weeks
    public LevelOneForexFieldSelector select52WeekHigh() {
        selectedfields.add("27");
        return this;
    }

    // Lowest price traded in the past 12 months, or 52 weeks
    public LevelOneForexFieldSelector select52WeekLow() {
        selectedfields.add("28");
        return this;
    }

    // Mark-to-Market value is calculated daily using current prices to determine profit/loss
    public LevelOneForexFieldSelector selectMark() {
        selectedfields.add("29");
        return this;
    }
}