package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuoteFutureOption {
    @JsonProperty("askMICId")
    public String askMICId;

    @JsonProperty("askPrice")
    public double askPrice;

    @JsonProperty("askSize")
    public int askSize;

    @JsonProperty("bidMICId")
    public String bidMICId;

    @JsonProperty("bidPrice")
    public double bidPrice;

    @JsonProperty("bidSize")
    public int bidSize;

    @JsonProperty("closePrice")
    public double closePrice;

    @JsonProperty("highPrice")
    public double highPrice;

    @JsonProperty("lastMICId")
    public String lastMICId;

    @JsonProperty("lastPrice")
    public double lastPrice;

    @JsonProperty("lastSize")
    public int lastSize;

    @JsonProperty("lowPrice")
    public double lowPrice;

    @JsonProperty("mark")
    public double mark;

    @JsonProperty("markChange")
    public double markChange;

    @JsonProperty("netChange")
    public double netChange;

    @JsonProperty("netPercentChange")
    public double netPercentChange;

    @JsonProperty("openInterest")
    public int openInterest;

    @JsonProperty("openPrice")
    public double openPrice;

    @JsonProperty("quoteTime")
    public long quoteTime;

    @JsonProperty("securityStatus")
    public String securityStatus;

    @JsonProperty("settlemetPrice")
    public double settlemetPrice;

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
        return "QuoteFutureOption{" +
                "askMICId='" + askMICId + '\'' +
                ", askPrice=" + askPrice +
                ", askSize=" + askSize +
                ", bidMICId='" + bidMICId + '\'' +
                ", bidPrice=" + bidPrice +
                ", bidSize=" + bidSize +
                ", closePrice=" + closePrice +
                ", highPrice=" + highPrice +
                ", lastMICId='" + lastMICId + '\'' +
                ", lastPrice=" + lastPrice +
                ", lastSize=" + lastSize +
                ", lowPrice=" + lowPrice +
                ", mark=" + mark +
                ", markChange=" + markChange +
                ", netChange=" + netChange +
                ", netPercentChange=" + netPercentChange +
                ", openInterest=" + openInterest +
                ", openPrice=" + openPrice +
                ", quoteTime=" + quoteTime +
                ", securityStatus='" + securityStatus + '\'' +
                ", settlemetPrice=" + settlemetPrice +
                ", tick=" + tick +
                ", tickAmount=" + tickAmount +
                ", totalVolume=" + totalVolume +
                ", tradeTime=" + tradeTime +
                '}';
    }
}