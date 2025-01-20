package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuoteFuture {
    @JsonProperty("askMICId")
    public String askMICId;

    @JsonProperty("askPrice")
    public double askPrice;

    @JsonProperty("askSize")
    public int askSize;

    @JsonProperty("askTime")
    public long askTime;

    @JsonProperty("bidMICId")
    public String bidMICId;

    @JsonProperty("bidPrice")
    public double bidPrice;

    @JsonProperty("bidSize")
    public int bidSize;

    @JsonProperty("bidTime")
    public long bidTime;

    @JsonProperty("closePrice")
    public double closePrice;

    @JsonProperty("futurePercentChange")
    public double futurePercentChange;

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

    @JsonProperty("netChange")
    public double netChange;

    @JsonProperty("openInterest")
    public int openInterest;

    @JsonProperty("openPrice")
    public double openPrice;

    @JsonProperty("quoteTime")
    public long quoteTime;

    @JsonProperty("quotedInSession")
    public boolean quotedInSession;

    @JsonProperty("securityStatus")
    public String securityStatus;

    @JsonProperty("settleTime")
    public long settleTime;

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
        return "QuoteFuture{" +
                "askMICId='" + askMICId + '\'' +
                ", askPrice=" + askPrice +
                ", askSize=" + askSize +
                ", askTime=" + askTime +
                ", bidMICId='" + bidMICId + '\'' +
                ", bidPrice=" + bidPrice +
                ", bidSize=" + bidSize +
                ", bidTime=" + bidTime +
                ", closePrice=" + closePrice +
                ", futurePercentChange=" + futurePercentChange +
                ", highPrice=" + highPrice +
                ", lastMICId='" + lastMICId + '\'' +
                ", lastPrice=" + lastPrice +
                ", lastSize=" + lastSize +
                ", lowPrice=" + lowPrice +
                ", mark=" + mark +
                ", netChange=" + netChange +
                ", openInterest=" + openInterest +
                ", openPrice=" + openPrice +
                ", quoteTime=" + quoteTime +
                ", quotedInSession=" + quotedInSession +
                ", securityStatus='" + securityStatus + '\'' +
                ", settleTime=" + settleTime +
                ", tick=" + tick +
                ", tickAmount=" + tickAmount +
                ", totalVolume=" + totalVolume +
                ", tradeTime=" + tradeTime +
                '}';
    }
}
