package com.hm.schwab.clientinterface.streaming.responses.level2;

public class MarketMaker {
    // Market Maker ID
    public String marketMakerID;

    // Size of the Market Maker for this price level
    public long size;

    // Quote time in milliseconds for this Market Maker's quote
    public long quoteTime;

    public MarketMaker(String marketMakerID, long size, long quoteTime) {
        this.marketMakerID = marketMakerID;
        this.size = size;
        this.quoteTime = quoteTime;
    }

    public String getMarketMakerID() {
        return marketMakerID;
    }

    public long getSize() {
        return size;
    }

    public long getQuoteTime() {
        return quoteTime;
    }

    @Override
    public String toString() {
        return "MarketMaker{" +
                "marketMakerID='" + marketMakerID + '\'' +
                ", size=" + size +
                ", quoteTime=" + quoteTime +
                '}';
    }
}