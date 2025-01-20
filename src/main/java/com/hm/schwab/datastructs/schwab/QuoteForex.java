package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuoteForex {
    @JsonProperty("52WeekHigh")
    public double week52High;

    @JsonProperty("52WeekLow")
    public double week52Low;

    @JsonProperty("askPrice")
    public double askPrice;

    @JsonProperty("askSize")
    public int askSize;

    @JsonProperty("bidPrice")
    public double bidPrice;

    @JsonProperty("bidSize")
    public int bidSize;

    @JsonProperty("closePrice")
    public double closePrice;

    @JsonProperty("highPrice")
    public double highPrice;

    @JsonProperty("lastPrice")
    public double lastPrice;

    @JsonProperty("lastSize")
    public int lastSize;

    @JsonProperty("lowPrice")
    public double lowPrice;

    @JsonProperty("mark")
    public double mark;

    @JsonProperty("netChange")
    public double netChange;

    @JsonProperty("netPercentChange")
    public double netPercentChange;

    @JsonProperty("openPrice")
    public double openPrice;

    @JsonProperty("quoteTime")
    public long quoteTime;

    @JsonProperty("securityStatus")
    public String securityStatus;

    @JsonProperty("tick")
    public double tick;

    @JsonProperty("tickAmount")
    public double tickAmount;

    @JsonProperty("totalVolume")
    public long totalVolume;

    @JsonProperty("tradeTime")
    public long tradeTime;

    @Override
    public String toString() {
        return "QuoteForex{" +
                "week52High=" + week52High +
                ", week52Low=" + week52Low +
                ", askPrice=" + askPrice +
                ", askSize=" + askSize +
                ", bidPrice=" + bidPrice +
                ", bidSize=" + bidSize +
                ", closePrice=" + closePrice +
                ", highPrice=" + highPrice +
                ", lastPrice=" + lastPrice +
                ", lastSize=" + lastSize +
                ", lowPrice=" + lowPrice +
                ", mark=" + mark +
                ", netChange=" + netChange +
                ", netPercentChange=" + netPercentChange +
                ", openPrice=" + openPrice +
                ", quoteTime=" + quoteTime +
                ", securityStatus='" + securityStatus + '\'' +
                ", tick=" + tick +
                ", tickAmount=" + tickAmount +
                ", totalVolume=" + totalVolume +
                ", tradeTime=" + tradeTime +
                '}';
    }
}