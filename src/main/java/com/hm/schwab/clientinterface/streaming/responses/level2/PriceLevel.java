package com.hm.schwab.clientinterface.streaming.responses.level2;

public class PriceLevel {
    // Price for this level
    public double price;

    // Aggregate size for this price level
    public int aggregateSize;

    // Number of Market Makers in this price level
    public int marketMakerCount;

    // Array of market maker sizes for this price level
    public MarketMaker[] marketMakers;

    public PriceLevel(double price, int aggregateSize, int marketMakerCount, MarketMaker[] marketMakers) {
        this.price = price;
        this.aggregateSize = aggregateSize;
        this.marketMakerCount = marketMakerCount;
        this.marketMakers = marketMakers;
    }

    public double getPrice() {
        return price;
    }

    public int getAggregateSize() {
        return aggregateSize;
    }

    public int getMarketMakerCount() {
        return marketMakerCount;
    }

    public MarketMaker[] getMarketMakers() {
        return marketMakers;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PriceLevel{")
          .append("price=").append(price)
          .append(", aggregateSize=").append(aggregateSize)
          .append(", marketMakerCount=").append(marketMakerCount)
          .append(", marketMakers=[");
        for (MarketMaker maker : marketMakers) {
            sb.append(maker.toString()).append(", ");
        }
        if (marketMakers.length > 0) {
            sb.setLength(sb.length() - 2); // Remove trailing comma and space
        }
        sb.append("]}");
        return sb.toString();
    }
}