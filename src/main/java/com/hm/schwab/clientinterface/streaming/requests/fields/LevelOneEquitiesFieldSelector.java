package com.hm.schwab.clientinterface.streaming.requests.fields;

public class LevelOneEquitiesFieldSelector extends FieldSelectBase {

    // Ticker symbol in upper case.
    public LevelOneEquitiesFieldSelector selectSymbol() {
        selectedfields.add("0");
        return this;
    }

    // Current Bid Price
    public LevelOneEquitiesFieldSelector selectBidPrice() {
        selectedfields.add("1");
        return this;
    }

    // Current Ask Price
    public LevelOneEquitiesFieldSelector selectAskPrice() {
        selectedfields.add("2");
        return this;
    }

    // Price at which the last trade was matched
    public LevelOneEquitiesFieldSelector selectLastPrice() {
        selectedfields.add("3");
        return this;
    }

    // Number of shares for bid
    public LevelOneEquitiesFieldSelector selectBidSize() {
        selectedfields.add("4");
        return this;
    }

    // Number of shares for ask
    public LevelOneEquitiesFieldSelector selectAskSize() {
        selectedfields.add("5");
        return this;
    }

    // Exchange with the ask
    public LevelOneEquitiesFieldSelector selectAskID() {
        selectedfields.add("6");
        return this;
    }

    // Exchange with the bid
    public LevelOneEquitiesFieldSelector selectBidID() {
        selectedfields.add("7");
        return this;
    }

    // Aggregated shares traded throughout the day, including pre/post market hours.
    public LevelOneEquitiesFieldSelector selectTotalVolume() {
        selectedfields.add("8");
        return this;
    }

    // Number of shares traded with last trade
    public LevelOneEquitiesFieldSelector selectLastSize() {
        selectedfields.add("9");
        return this;
    }

    // Day's high trade price
    public LevelOneEquitiesFieldSelector selectHighPrice() {
        selectedfields.add("10");
        return this;
    }

    // Day's low trade price
    public LevelOneEquitiesFieldSelector selectLowPrice() {
        selectedfields.add("11");
        return this;
    }

    // Previous day's closing price
    public LevelOneEquitiesFieldSelector selectClosePrice() {
        selectedfields.add("12");
        return this;
    }

    // Primary "listing" Exchange
    public LevelOneEquitiesFieldSelector selectExchangeID() {
        selectedfields.add("13");
        return this;
    }

    // Stock approved by the Federal Reserve and an investor's broker as being eligible for providing collateral for margin debt.
    public LevelOneEquitiesFieldSelector selectMarginable() {
        selectedfields.add("14");
        return this;
    }

    // A company, index or fund name
    public LevelOneEquitiesFieldSelector selectDescription() {
        selectedfields.add("15");
        return this;
    }

    // Exchange where last trade was executed
    public LevelOneEquitiesFieldSelector selectLastID() {
        selectedfields.add("16");
        return this;
    }

    // Day's Open Price
    public LevelOneEquitiesFieldSelector selectOpenPrice() {
        selectedfields.add("17");
        return this;
    }

    // LastPrice - ClosePrice
    public LevelOneEquitiesFieldSelector selectNetChange() {
        selectedfields.add("18");
        return this;
    }

    // Highest price traded in the past 12 months, or 52 weeks
    public LevelOneEquitiesFieldSelector select52WeekHigh() {
        selectedfields.add("19");
        return this;
    }

    // Lowest price traded in the past 12 months, or 52 weeks
    public LevelOneEquitiesFieldSelector select52WeekLow() {
        selectedfields.add("20");
        return this;
    }

    // Price-to-earnings ratio.
    public LevelOneEquitiesFieldSelector selectPERatio() {
        selectedfields.add("21");
        return this;
    }

    // Annual Dividend Amount
    public LevelOneEquitiesFieldSelector selectAnnualDividendAmount() {
        selectedfields.add("22");
        return this;
    }

    // Dividend Yield
    public LevelOneEquitiesFieldSelector selectDividendYield() {
        selectedfields.add("23");
        return this;
    }

    // Mutual Fund Net Asset Value
    public LevelOneEquitiesFieldSelector selectNAV() {
        selectedfields.add("24");
        return this;
    }

    // Display name of exchange
    public LevelOneEquitiesFieldSelector selectExchangeName() {
        selectedfields.add("25");
        return this;
    }

    public LevelOneEquitiesFieldSelector selectDividendDate() {
        selectedfields.add("26");
        return this;
    }

    // Is last quote a regular quote
    public LevelOneEquitiesFieldSelector selectRegularMarketQuote() {
        selectedfields.add("27");
        return this;
    }

    // Is last trade a regular trade
    public LevelOneEquitiesFieldSelector selectRegularMarketTrade() {
        selectedfields.add("28");
        return this;
    }

    // Only records regular trade
    public LevelOneEquitiesFieldSelector selectRegularMarketLastPrice() {
        selectedfields.add("29");
        return this;
    }

    // Currently realize/100, only records regular trade
    public LevelOneEquitiesFieldSelector selectRegularMarketLastSize() {
        selectedfields.add("30");
        return this;
    }

    // RegularMarketLastPrice - ClosePrice
    public LevelOneEquitiesFieldSelector selectRegularMarketNetChange() {
        selectedfields.add("31");
        return this;
    }

    // Indicates a symbols current trading status, Normal, Halted, Closed
    public LevelOneEquitiesFieldSelector selectSecurityStatus() {
        selectedfields.add("32");
        return this;
    }

    // Mark Price
    public LevelOneEquitiesFieldSelector selectMarkPrice() {
        selectedfields.add("33");
        return this;
    }

    // Last time a bid or ask updated in milliseconds since Epoch
    public LevelOneEquitiesFieldSelector selectQuoteTimeInLong() {
        selectedfields.add("34");
        return this;
    }

    // Last trade time in milliseconds since Epoch
    public LevelOneEquitiesFieldSelector selectTradeTimeInLong() {
        selectedfields.add("35");
        return this;
    }

    // Regular market trade time in milliseconds since Epoch
    public LevelOneEquitiesFieldSelector selectRegularMarketTradeTimeInLong() {
        selectedfields.add("36");
        return this;
    }

    // Last bid time in milliseconds since Epoch
    public LevelOneEquitiesFieldSelector selectBidTime() {
        selectedfields.add("37");
        return this;
    }

    // Last ask time in milliseconds since Epoch
    public LevelOneEquitiesFieldSelector selectAskTime() {
        selectedfields.add("38");
        return this;
    }

    // 4-chars Market Identifier Code
    public LevelOneEquitiesFieldSelector selectAskMICID() {
        selectedfields.add("39");
        return this;
    }

    // 4-chars Market Identifier Code
    public LevelOneEquitiesFieldSelector selectBidMICID() {
        selectedfields.add("40");
        return this;
    }

    // 4-chars Market Identifier Code
    public LevelOneEquitiesFieldSelector selectLastMICID() {
        selectedfields.add("41");
        return this;
    }

    // Net Percentage Change
    public LevelOneEquitiesFieldSelector selectNetPercentChange() {
        selectedfields.add("42");
        return this;
    }

    // Regular market hours percentage change
    public LevelOneEquitiesFieldSelector selectRegularMarketPercentChange() {
        selectedfields.add("43");
        return this;
    }

    // Mark price net change
    public LevelOneEquitiesFieldSelector selectMarkPriceNetChange() {
        selectedfields.add("44");
        return this;
    }

    // Mark price percentage change
    public LevelOneEquitiesFieldSelector selectMarkPricePercentChange() {
        selectedfields.add("45");
        return this;
    }

    // -1 = NULL
    // >= 0 is valid quantity
    public LevelOneEquitiesFieldSelector selectHardToBorrowQuantity() {
        selectedfields.add("46");
        return this;
    }

    // null = NULL
    // valid range = -99,999.999 to +99,999.999
    public LevelOneEquitiesFieldSelector selectHardToBorrowRate() {
        selectedfields.add("47");
        return this;
    }

    // -1 = NULL
    // 1 = true
    // 0 = false
    public LevelOneEquitiesFieldSelector selectHardToBorrow() {
        selectedfields.add("48");
        return this;
    }

    // -1 = NULL
    // 1 = true
    // 0 = false
    public LevelOneEquitiesFieldSelector selectShortable() {
        selectedfields.add("49");
        return this;
    }

    // Change in price since the end of the regular session (typically 4:00pm)
    public LevelOneEquitiesFieldSelector selectPostMarketNetChange() {
        selectedfields.add("50");
        return this;
    }

    // Percent Change in price since the end of the regular session (typically 4:00pm)
    public LevelOneEquitiesFieldSelector selectPostMarketPercentChange() {
        selectedfields.add("51");
        return this;
    }
}