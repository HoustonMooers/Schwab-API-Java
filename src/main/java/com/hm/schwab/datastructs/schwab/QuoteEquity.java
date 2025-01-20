package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuoteEquity {
    @JsonProperty("52WeekHigh")
    public double week52High;

    @JsonProperty("52WeekLow")
    public double week52Low;

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

    @JsonProperty("markPercentChange")
    public double markPercentChange;

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

    @JsonProperty("totalVolume")
    public long totalVolume;

    @JsonProperty("tradeTime")
    public long tradeTime;

    @JsonProperty("volatility")
    public double volatility;

    @Override
    public String toString() {
        return "QuoteEquity{" +
                "week52High=" + week52High +
                ", week52Low=" + week52Low +
                ", askMICId='" + askMICId + '\'' +
                ", askPrice=" + askPrice +
                ", askSize=" + askSize +
                ", askTime=" + askTime +
                ", bidMICId='" + bidMICId + '\'' +
                ", bidPrice=" + bidPrice +
                ", bidSize=" + bidSize +
                ", bidTime=" + bidTime +
                ", closePrice=" + closePrice +
                ", highPrice=" + highPrice +
                ", lastMICId='" + lastMICId + '\'' +
                ", lastPrice=" + lastPrice +
                ", lastSize=" + lastSize +
                ", lowPrice=" + lowPrice +
                ", mark=" + mark +
                ", markChange=" + markChange +
                ", markPercentChange=" + markPercentChange +
                ", netChange=" + netChange +
                ", netPercentChange=" + netPercentChange +
                ", openPrice=" + openPrice +
                ", quoteTime=" + quoteTime +
                ", securityStatus='" + securityStatus + '\'' +
                ", totalVolume=" + totalVolume +
                ", tradeTime=" + tradeTime +
                ", volatility=" + volatility +
                '}';
    }
}