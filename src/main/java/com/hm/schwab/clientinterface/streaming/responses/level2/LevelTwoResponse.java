package com.hm.schwab.clientinterface.streaming.responses.level2;

import java.util.Map;

public class LevelTwoResponse {
    // Ticker symbol in upper case.
    public String symbol;

    // Milliseconds since Epoch
    // Timestamp for the data
    public long marketSnapshotTime;

    // Bid side price levels
    public PriceLevel[] bidSideLevels;

    // Ask side price levels
    public PriceLevel[] askSideLevels;

	private long timestamp;

    public LevelTwoResponse(Map<String, Object> dataMap, long timestamp) {
    	this.timestamp = timestamp;
        this.symbol = (String) dataMap.get("0");
        this.marketSnapshotTime = (Long) dataMap.get("1");

        // Assuming bidSideLevels and askSideLevels are stored as arrays of maps in the dataMap
        Object[] rawBidLevels = (Object[]) dataMap.get("2");
        if (rawBidLevels != null) {
            this.bidSideLevels = new PriceLevel[rawBidLevels.length];
            for (int i = 0; i < rawBidLevels.length; i++) {
                Map<String, Object> levelMap = (Map<String, Object>) rawBidLevels[i];
                Object[] rawMarketMakers = (Object[]) levelMap.get("3");
                MarketMaker[] marketMakers = new MarketMaker[rawMarketMakers.length];
                for (int j = 0; j < rawMarketMakers.length; j++) {
                    Map<String, Object> makerMap = (Map<String, Object>) rawMarketMakers[j];
                    marketMakers[j] = new MarketMaker(
                        (String) makerMap.get("0"),
                        (Long) makerMap.get("1"),
                        (Long) makerMap.get("2")
                    );
                }
                this.bidSideLevels[i] = new PriceLevel(
                    (Double) levelMap.get("0"),
                    (Integer) levelMap.get("1"),
                    (Integer) levelMap.get("2"),
                    marketMakers
                );
            }
        }

        Object[] rawAskLevels = (Object[]) dataMap.get("3");
        if (rawAskLevels != null) {
            this.askSideLevels = new PriceLevel[rawAskLevels.length];
            for (int i = 0; i < rawAskLevels.length; i++) {
                Map<String, Object> levelMap = (Map<String, Object>) rawAskLevels[i];
                Object[] rawMarketMakers = (Object[]) levelMap.get("3");
                MarketMaker[] marketMakers = new MarketMaker[rawMarketMakers.length];
                for (int j = 0; j < rawMarketMakers.length; j++) {
                    Map<String, Object> makerMap = (Map<String, Object>) rawMarketMakers[j];
                    marketMakers[j] = new MarketMaker(
                        (String) makerMap.get("0"),
                        (Long) makerMap.get("1"),
                        (Long) makerMap.get("2")
                    );
                }
                this.askSideLevels[i] = new PriceLevel(
                    (Double) levelMap.get("0"),
                    (Integer) levelMap.get("1"),
                    (Integer) levelMap.get("2"),
                    marketMakers
                );
            }
        }
    }

    public String getSymbol() {
        return symbol;
    }

    public long getMarketSnapshotTime() {
        return marketSnapshotTime;
    }

    public PriceLevel[] getBidSideLevels() {
        return bidSideLevels;
    }

    public PriceLevel[] getAskSideLevels() {
        return askSideLevels;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Level2Response:\n");
        sb.append("  Symbol: ").append(symbol).append("\n");
        sb.append("  Market Snapshot Time: ").append(marketSnapshotTime).append("\n");
        sb.append("  Bid Side Levels:\n");
        for (PriceLevel level : bidSideLevels) {
            sb.append("    ").append(level.toString()).append("\n");
        }
        sb.append("  Ask Side Levels:\n");
        for (PriceLevel level : askSideLevels) {
            sb.append("    ").append(level.toString()).append("\n");
        }
        return sb.toString();
    }
}