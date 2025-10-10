package com.hm.schwab.clientinterface.streaming.responses;

public class ScreenerItem {
    // Description of instrument
    public String description;

    // Last trade price (up to 2 decimal places)
    public double lastPrice;

    // Market share percentage of instrument (up to 2 decimal places)
    public double marketShare;

    // Net change value (up to 2 decimal places)
    public double netChange;

    // Net percent change value (up to 4 decimal places)
    public double netPercentChange;

    // Stock or Option symbol
    public String symbol;

    // Total volume for the day
    public long totalVolume;

    // Number of trades for the frequency requested
    public long trades;

    // Volume for the frequency requested
    public long volume;
    
    public ScreenerItem(String description, double lastPrice, double marketShare, double netChange, double netPercentChange, String symbol, long totalVolume, long trades, long volume) {
        this.description = description;
        this.lastPrice = lastPrice;
        this.marketShare = marketShare;
        this.netChange = netChange;
        this.netPercentChange = netPercentChange;
        this.symbol = symbol;
        this.totalVolume = totalVolume;
        this.trades = trades;
        this.volume = volume;
    }
}
