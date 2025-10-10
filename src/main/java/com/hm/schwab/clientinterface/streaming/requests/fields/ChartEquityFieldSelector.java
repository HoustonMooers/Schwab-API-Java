package com.hm.schwab.clientinterface.streaming.requests.fields;

public class ChartEquityFieldSelector extends FieldSelectBase {

    // Ticker symbol in upper case.
    public ChartEquityFieldSelector selectSymbol() {
        selectedfields.add("0");
        return this;
    }

    // Opening price for the minute
    public ChartEquityFieldSelector selectOpenPrice() {
        selectedfields.add("1");
        return this;
    }

    // Highest price for the minute
    public ChartEquityFieldSelector selectHighPrice() {
        selectedfields.add("2");
        return this;
    }

    // Chart's lowest price for the minute
    public ChartEquityFieldSelector selectLowPrice() {
        selectedfields.add("3");
        return this;
    }

    // Closing price for the minute
    public ChartEquityFieldSelector selectClosePrice() {
        selectedfields.add("4");
        return this;
    }

    // Total volume for the minute
    public ChartEquityFieldSelector selectVolume() {
        selectedfields.add("5");
        return this;
    }

    // Identifies the candle minute
    public ChartEquityFieldSelector selectSequence() {
        selectedfields.add("6");
        return this;
    }

    // Milliseconds since Epoch
    public ChartEquityFieldSelector selectChartTime() {
        selectedfields.add("7");
        return this;
    }

    public ChartEquityFieldSelector selectChartDay() {
        selectedfields.add("8");
        return this;
    }
}
