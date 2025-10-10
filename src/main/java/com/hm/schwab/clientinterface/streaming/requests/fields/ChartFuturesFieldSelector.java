package com.hm.schwab.clientinterface.streaming.requests.fields;

public class ChartFuturesFieldSelector extends FieldSelectBase {

    // Ticker symbol in upper case.
    public ChartFuturesFieldSelector selectSymbol() {
        selectedfields.add("0");
        return this;
    }

    // Milliseconds since Epoch
    public ChartFuturesFieldSelector selectChartTime() {
        selectedfields.add("1");
        return this;
    }

    // Opening price for the minute
    public ChartFuturesFieldSelector selectOpenPrice() {
        selectedfields.add("2");
        return this;
    }

    // Highest price for the minute
    public ChartFuturesFieldSelector selectHighPrice() {
        selectedfields.add("3");
        return this;
    }

    // Chart's lowest price for the minute
    public ChartFuturesFieldSelector selectLowPrice() {
        selectedfields.add("4");
        return this;
    }

    // Closing price for the minute
    public ChartFuturesFieldSelector selectClosePrice() {
        selectedfields.add("5");
        return this;
    }

    // Total volume for the minute
    public ChartFuturesFieldSelector selectVolume() {
        selectedfields.add("6");
        return this;
    }
}
