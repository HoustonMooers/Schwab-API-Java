package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Underlying {
    @JsonProperty("ask")
    public double ask;

    @JsonProperty("askSize")
    public int askSize;

    @JsonProperty("bid")
    public double bid;

    @JsonProperty("bidSize")
    public int bidSize;

    @JsonProperty("change")
    public double change;

    @JsonProperty("close")
    public double close;

    @JsonProperty("delayed")
    public boolean delayed;

    @JsonProperty("description")
    public String description;

    @JsonProperty("exchangeName")
    public String exchangeName;

    @JsonProperty("fiftyTwoWeekHigh")
    public double fiftyTwoWeekHigh;

    @JsonProperty("fiftyTwoWeekLow")
    public double fiftyTwoWeekLow;

    @JsonProperty("highPrice")
    public double highPrice;

    @JsonProperty("last")
    public double last;

    @JsonProperty("lowPrice")
    public double lowPrice;

    @JsonProperty("mark")
    public double mark;

    @JsonProperty("markChange")
    public double markChange;

    @JsonProperty("markPercentChange")
    public double markPercentChange;

    @JsonProperty("openPrice")
    public double openPrice;

    @JsonProperty("percentChange")
    public double percentChange;

    @JsonProperty("quoteTime")
    public long quoteTime;

    @JsonProperty("symbol")
    public String symbol;

    @JsonProperty("totalVolume")
    public long totalVolume;

    @JsonProperty("tradeTime")
    public long tradeTime;

    @Override
    public String toString() {
        return "Underlying{" +
                "ask=" + ask +
                ", askSize=" + askSize +
                ", bid=" + bid +
                ", bidSize=" + bidSize +
                ", change=" + change +
                ", close=" + close +
                ", delayed=" + delayed +
                ", description='" + description + '\'' +
                ", exchangeName='" + exchangeName + '\'' +
                ", fiftyTwoWeekHigh=" + fiftyTwoWeekHigh +
                ", fiftyTwoWeekLow=" + fiftyTwoWeekLow +
                ", highPrice=" + highPrice +
                ", last=" + last +
                ", lowPrice=" + lowPrice +
                ", mark=" + mark +
                ", markChange=" + markChange +
                ", markPercentChange=" + markPercentChange +
                ", openPrice=" + openPrice +
                ", percentChange=" + percentChange +
                ", quoteTime=" + quoteTime +
                ", symbol='" + symbol + '\'' +
                ", totalVolume=" + totalVolume +
                ", tradeTime=" + tradeTime +
                '}';
    }
}