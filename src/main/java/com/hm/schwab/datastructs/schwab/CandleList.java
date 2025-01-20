package com.hm.schwab.datastructs.schwab;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CandleList {
    @JsonProperty("candles")
    public List<Candle> candles;

    @JsonProperty("empty")
    public boolean empty;

    @JsonProperty("previousClose")
    public double previousClose;

    @JsonProperty("previousCloseDate")
    public long previousCloseDate;

    @JsonProperty("previousCloseDateISO8601")
    public String previousCloseDateISO8601;

    @JsonProperty("symbol")
    public String symbol;

    @Override
    public String toString() {
        return "CandleList{" +
                "candles=" + candles +
                ", empty=" + empty +
                ", previousClose=" + previousClose +
                ", previousCloseDate=" + previousCloseDate +
                ", previousCloseDateISO8601='" + previousCloseDateISO8601 + '\'' +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}