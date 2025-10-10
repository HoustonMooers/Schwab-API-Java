package com.hm.schwab.clientinterface.streaming.responses;

import java.util.Map;

public class LevelOneEquitiesResponse extends Response {
    public LevelOneEquitiesResponse(Map<String, Object> dataMap, long timestamp) {
        super(dataMap, timestamp);
    }

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

    // Number of shares for bid
    // Units are "lots" (typically 100 shares per lot)
    // Note for NFL data this field can be 0 with a non-zero bid price which representing a bid size of less than 100 shares.
    public boolean hasBidSize() {
        return dataMap.containsKey("4");
    }

    public int getBidSize() {
        return (Integer) dataMap.get("4");
    }

    // Number of shares for ask
    // See bid size notes.
    public boolean hasAskSize() {
        return dataMap.containsKey("5");
    }

    public int getAskSize() {
        return (Integer) dataMap.get("5");
    }

    // Exchange with the ask
    public boolean hasAskID() {
        return dataMap.containsKey("6");
    }

    public char getAskID() {
        return (Character) dataMap.get("6");
    }

    // Exchange with the bid
    public boolean hasBidID() {
        return dataMap.containsKey("7");
    }

    public char getBidID() {
        return (Character) dataMap.get("7");
    }

    // Aggregated shares traded throughout the day, including pre/post market hours.
    // Volume is set to zero at 7:28am ET.
    public boolean hasTotalVolume() {
        return dataMap.containsKey("8");
    }

    public long getTotalVolume() {
        return (Long) dataMap.get("8");
    }

    // Number of shares traded with last trade
    // Units are shares
    public boolean hasLastSize() {
        return dataMap.containsKey("9");
    }

    public long getLastSize() {
        return (Long) dataMap.get("9");
    }

    // Day's high trade price
    // According to industry standard, only regular session trades set the High and Low
    // If a stock does not trade in the regular session, high and low will be zero.
    // High/low reset to ZERO at 3:30am ET
    public boolean hasHighPrice() {
        return dataMap.containsKey("10");
    }

    public double getHighPrice() {
        return (Double) dataMap.get("10");
    }

    // Day's low trade price
    // See High Price notes
    public boolean hasLowPrice() {
        return dataMap.containsKey("11");
    }

    public double getLowPrice() {
        return (Double) dataMap.get("11");
    }

    // Previous day's closing price
    // Closing prices are updated from the DB at 3:30 AM ET.
    public boolean hasClosePrice() {
        return dataMap.containsKey("12");
    }

    public double getClosePrice() {
        return (Double) dataMap.get("12");
    }

    // Primary "listing" Exchange
    // As long as the symbol is valid, this data is always present
    // This field is updated every time the closing prices are loaded from DB
    public boolean hasExchangeID() {
        return dataMap.containsKey("13");
    }

    public char getExchangeID() {
        return (Character) dataMap.get("13");
    }

    // Stock approved by the Federal Reserve and an investor's broker as being eligible for providing collateral for margin debt.
    public boolean hasMarginable() {
        return dataMap.containsKey("14");
    }

    public boolean getMarginable() {
        return (Boolean) dataMap.get("14");
    }

    // A company, index or fund name
    // Once per day descriptions are loaded from the database at 7:29:50 AM ET.
    public boolean hasDescription() {
        return dataMap.containsKey("15");
    }

    public String getDescription() {
        return (String) dataMap.get("15");
    }

    // Exchange where last trade was executed
    public boolean hasLastID() {
        return dataMap.containsKey("16");
    }

    public char getLastID() {
        return (Character) dataMap.get("16");
    }

    // Day's Open Price According to industry standard, only regular session trades set the open.
    // If a stock does not trade during the regular session, then the open price is 0.
    // In the pre-market session, open is blank because pre-market session trades do not set the open.
    // Open is set to ZERO at 3:30am ET.
    public boolean hasOpenPrice() {
        return dataMap.containsKey("17");
    }

    public double getOpenPrice() {
        return (Double) dataMap.get("17");
    }

    // LastPrice - ClosePrice
    // If close is zero, change will be zero
    public boolean hasNetChange() {
        return dataMap.containsKey("18");
    }

    public double getNetChange() {
        return (Double) dataMap.get("18");
    }

    // Highest price traded in the past 12 months, or 52 weeks
    // Calculated by merging intraday high (from fh) and 52-week high (from db)
    public boolean has52WeekHigh() {
        return dataMap.containsKey("19");
    }

    public double get52WeekHigh() {
        return (Double) dataMap.get("19");
    }

    // Lowest price traded in the past 12 months, or 52 weeks
    // Calculated by merging intraday low (from fh) and 52-week low (from db)
    public boolean has52WeekLow() {
        return dataMap.containsKey("20");
    }

    public double get52WeekLow() {
        return (Double) dataMap.get("20");
    }

    // Price-to-earnings ratio.
    // Note that the "price of a share of stock" in the definition does update during the day so this field has the potential to stream. However, the current implementation uses the closing price and therefore does not stream throughout the day.
    // The P/E equals the price of a share of stock, divided by the company's earnings-per-share.
    public boolean hasPERatio() {
        return dataMap.containsKey("21");
    }

    public double getPERatio() {
        return (Double) dataMap.get("21");
    }

    // Annual Dividend Amount
    public boolean hasAnnualDividendAmount() {
        return dataMap.containsKey("22");
    }

    public double getAnnualDividendAmount() {
        return (Double) dataMap.get("22");
    }

    // Dividend Yield
    public boolean hasDividendYield() {
        return dataMap.containsKey("23");
    }

    public double getDividendYield() {
        return (Double) dataMap.get("23");
    }

    // Mutual Fund Net Asset Value
    // Load various times after market close
    public boolean hasNAV() {
        return dataMap.containsKey("24");
    }

    public double getNAV() {
        return (Double) dataMap.get("24");
    }

    // Display name of exchange
    public boolean hasExchangeName() {
        return dataMap.containsKey("25");
    }

    public String getExchangeName() {
        return (String) dataMap.get("25");
    }

    public boolean hasDividendDate() {
        return dataMap.containsKey("26");
    }

    public String getDividendDate() {
        return (String) dataMap.get("26");
    }

    // Is last quote a regular quote
    public boolean hasRegularMarketQuote() {
        return dataMap.containsKey("27");
    }

    public boolean getRegularMarketQuote() {
        return (Boolean) dataMap.get("27");
    }

    // Is last trade a regular trade
    public boolean hasRegularMarketTrade() {
        return dataMap.containsKey("28");
    }

    public boolean getRegularMarketTrade() {
        return (Boolean) dataMap.get("28");
    }

    // Only records regular trade
    public boolean hasRegularMarketLastPrice() {
        return dataMap.containsKey("29");
    }

    public double getRegularMarketLastPrice() {
        return (Double) dataMap.get("29");
    }

    // Currently realize/100, only records regular trade
    public boolean hasRegularMarketLastSize() {
        return dataMap.containsKey("30");
    }

    public int getRegularMarketLastSize() {
        return (Integer) dataMap.get("30");
    }

    // RegularMarketLastPrice - ClosePrice
    public boolean hasRegularMarketNetChange() {
        return dataMap.containsKey("31");
    }

    public double getRegularMarketNetChange() {
        return (Double) dataMap.get("31");
    }

    // Indicates a symbols current trading status, Normal, Halted, Closed
    public boolean hasSecurityStatus() {
        return dataMap.containsKey("32");
    }

    public String getSecurityStatus() {
        return (String) dataMap.get("32");
    }

    // Mark Price
    public boolean hasMarkPrice() {
        return dataMap.containsKey("33");
    }

    public double getMarkPrice() {
        return (Double) dataMap.get("33");
    }

    // Last time a bid or ask updated in milliseconds since Epoch
    // The difference, measured in milliseconds, between the time an event occurs and midnight, January 1, 1970 UTC.
    public boolean hasQuoteTimeInLong() {
        return dataMap.containsKey("34");
    }

    public long getQuoteTimeInLong() {
        return (Long) dataMap.get("34");
    }

    // Last trade time in milliseconds since Epoch
    // The difference, measured in milliseconds, between the time an event occurs and midnight, January 1, 1970 UTC.
    public boolean hasTradeTimeInLong() {
        return dataMap.containsKey("35");
    }

    public long getTradeTimeInLong() {
        return (Long) dataMap.get("35");
    }

    // Regular market trade time in milliseconds since Epoch
    // The difference, measured in milliseconds, between the time an event occurs and midnight, January 1, 1970 UTC.
    public boolean hasRegularMarketTradeTimeInLong() {
        return dataMap.containsKey("36");
    }

    public long getRegularMarketTradeTimeInLong() {
        return (Long) dataMap.get("36");
    }

    // Last bid time in milliseconds since Epoch
    // The difference, measured in milliseconds, between the time an event occurs and midnight, January 1, 1970 UTC.
    public boolean hasBidTime() {
        return dataMap.containsKey("37");
    }

    public long getBidTime() {
        return (Long) dataMap.get("37");
    }

    // Last ask time in milliseconds since Epoch
    // The difference, measured in milliseconds, between the time an event occurs and midnight, January 1, 1970 UTC.
    public boolean hasAskTime() {
        return dataMap.containsKey("38");
    }

    public long getAskTime() {
        return (Long) dataMap.get("38");
    }

    // 4-chars Market Identifier Code
    public boolean hasAskMICID() {
        return dataMap.containsKey("39");
    }

    public String getAskMICID() {
        return (String) dataMap.get("39");
    }

    // 4-chars Market Identifier Code
    public boolean hasBidMICID() {
        return dataMap.containsKey("40");
    }

    public String getBidMICID() {
        return (String) dataMap.get("40");
    }

    // 4-chars Market Identifier Code
    public boolean hasLastMICID() {
        return dataMap.containsKey("41");
    }

    public String getLastMICID() {
        return (String) dataMap.get("41");
    }

    // Net Percentage Change
    // NetChange / ClosePrice * 100
    public boolean hasNetPercentChange() {
        return dataMap.containsKey("42");
    }

    public double getNetPercentChange() {
        return (Double) dataMap.get("42");
    }

    // Regular market hours percentage change
    // RegularMarketNetChange / ClosePrice * 100
    public boolean hasRegularMarketPercentChange() {
        return dataMap.containsKey("43");
    }

    public double getRegularMarketPercentChange() {
        return (Double) dataMap.get("43");
    }

    // Mark price net change
    public boolean hasMarkPriceNetChange() {
        return dataMap.containsKey("44");
    }

    public double getMarkPriceNetChange() {
        return (Double) dataMap.get("44");
    }

    // Mark price percentage change
    public boolean hasMarkPricePercentChange() {
        return dataMap.containsKey("45");
    }

    public double getMarkPricePercentChange() {
        return (Double) dataMap.get("45");
    }

    // -1 = NULL
    // >= 0 is valid quantity
    public boolean hasHardToBorrowQuantity() {
        return dataMap.containsKey("46");
    }

    public int getHardToBorrowQuantity() {
        return (Integer) dataMap.get("46");
    }

    // null = NULL
    // valid range = -99,999.999 to +99,999.999
    public boolean hasHardToBorrowRate() {
        return dataMap.containsKey("47");
    }

    public double getHardToBorrowRate() {
        return (Double) dataMap.get("47");
    }

    // -1 = NULL
    // 1 = true
    // 0 = false
    public boolean hasHardToBorrow() {
        return dataMap.containsKey("48");
    }

    public int getHardToBorrow() {
        return (Integer) dataMap.get("48");
    }

    // -1 = NULL
    // 1 = true
    // 0 = false
    public boolean hasshortable() {
        return dataMap.containsKey("49");
    }

    public int getshortable() {
        return (Integer) dataMap.get("49");
    }

    // Change in price since the end of the regular session (typically 4:00pm)
    // PostMarketLastPrice - RegularMarketLastPrice
    public boolean hasPostMarketNetChange() {
        return dataMap.containsKey("50");
    }

    public double getPostMarketNetChange() {
        return (Double) dataMap.get("50");
    }

    // Percent Change in price since the end of the regular session (typically 4:00pm)
    // PostMarketNetChange / RegularMarketLastPrice * 100
    public boolean hasPostMarketPercentChange() {
        return dataMap.containsKey("51");
    }

    public double getPostMarketPercentChange() {
        return (Double) dataMap.get("51");
    }
}