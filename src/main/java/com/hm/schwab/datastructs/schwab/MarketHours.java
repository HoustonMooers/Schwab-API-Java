package com.hm.schwab.datastructs.schwab;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MarketHours {
    @JsonProperty("equity")
    public Map<String, Hours> equity;

    @JsonProperty("option")
    public Map<String, Hours> option;

    @JsonProperty("bond")
    public Map<String, Hours> bond;

    @JsonProperty("future")
    public Map<String, Hours> future;

    @JsonProperty("forex")
    public Map<String, Hours> forex;

    @Override
    public String toString() {
        return "MarketHours{" +
                "equity=" + equity +
                ", option=" + option +
                ", bond=" + bond +
                ", future=" + future +
                ", forex=" + forex +
                '}';
    }
}