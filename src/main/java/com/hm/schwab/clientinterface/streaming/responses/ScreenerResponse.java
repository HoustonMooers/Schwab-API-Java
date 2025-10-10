package com.hm.schwab.clientinterface.streaming.responses;

import java.util.List;
import java.util.Map;

public class ScreenerResponse extends Response {
    // Public fields
    public String symbol;
    public long timestamp;
    public String sortField;
    public Integer frequency;
    public ScreenerItem[] items;

    public ScreenerResponse(Map<String, Object> dataMap, long timestamp) {
        super(dataMap, timestamp);
        this.symbol = (String) dataMap.get("0");
        this.timestamp = (Long) dataMap.get("1");
        this.sortField = (String) dataMap.get("2");
        this.frequency = (Integer) dataMap.get("3");

        // Assuming the items are stored as an array of maps in the dataMap
        List<Map<String, Object>> rawItems = (List<Map<String, Object>>) dataMap.get("4");
        if (rawItems != null) {
            this.items = new ScreenerItem[rawItems.size()];
            for (int i = 0; i < rawItems.size(); i++) {
                Map<String, Object> itemMap = (Map<String, Object>) rawItems.get(i);
                this.items[i] = new ScreenerItem(
                    (String) itemMap.get("description"),
                    (Double) itemMap.get("lastPrice"),
                    (Double) itemMap.get("marketShare"),
                    (Double) itemMap.get("netChange"),
                    (Double) itemMap.get("netPercentChange"),
                    (String) itemMap.get("symbol"),
                    (Long) itemMap.get("totalVolume"),
                    (Integer) itemMap.get("trades"),
                    (Integer) itemMap.get("volume")
                );
            }
        }
    }

    public String getSymbol() {
        return symbol;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getSortField() {
        return sortField;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public ScreenerItem[] getItems() {
        return items;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ScreenerResponse:\n");
        sb.append("Symbol: ").append(symbol).append("\n");
        sb.append("Timestamp: ").append(timestamp).append("\n");
        sb.append("Sort Field: ").append(sortField).append("\n");
        sb.append("Frequency: ").append(frequency).append("\n");
        sb.append("Items:\n");

        if (items != null) {
            for (ScreenerItem item : items) {
                sb.append("  ScreenerItem:\n");
                sb.append("    Description: ").append(item.description).append("\n");
                sb.append("    Last Price: ").append(item.lastPrice).append("\n");
                sb.append("    Market Share: ").append(item.marketShare).append("\n");
                sb.append("    Net Change: ").append(item.netChange).append("\n");
                sb.append("    Net Percent Change: ").append(item.netPercentChange).append("\n");
                sb.append("    Symbol: ").append(item.symbol).append("\n");
                sb.append("    Total Volume: ").append(item.totalVolume).append("\n");
                sb.append("    Trades: ").append(item.trades).append("\n");
                sb.append("    Volume: ").append(item.volume).append("\n");
            }
        } else {
            sb.append("  No items available.\n");
        }

        return sb.toString();
    }
}