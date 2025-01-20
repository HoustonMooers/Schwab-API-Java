package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class ExtendedMarket {
    @JsonProperty("askPrice")
    public double askPrice;

    @JsonProperty("askSize")
    public int askSize;

    @JsonProperty("bidPrice")
    public double bidPrice;

    @JsonProperty("bidSize")
    public int bidSize;

    @JsonProperty("lastPrice")
    public double lastPrice;

    @JsonProperty("lastSize")
    public int lastSize;

    @JsonProperty("mark")
    public double mark;

    @JsonProperty("quoteTime")
    public long quoteTime;

    @JsonProperty("totalVolume")
    public long totalVolume;

    @JsonProperty("tradeTime")
    public long tradeTime;

    @Override
    public String toString() {
        return "ExtendedMarket{" +
                "askPrice=" + askPrice +
                ", askSize=" + askSize +
                ", bidPrice=" + bidPrice +
                ", bidSize=" + bidSize +
                ", lastPrice=" + lastPrice +
                ", lastSize=" + lastSize +
                ", mark=" + mark +
                ", quoteTime=" + quoteTime +
                ", totalVolume=" + totalVolume +
                ", tradeTime=" + tradeTime +
                '}';
    }
}