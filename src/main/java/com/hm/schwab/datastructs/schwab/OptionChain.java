package com.hm.schwab.datastructs.schwab;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OptionChain {
    @JsonProperty("symbol")
    public String symbol;

    @JsonProperty("status")
    public String status;

    @JsonProperty("underlying")
    public Underlying underlying;

    @JsonProperty("strategy")
    public String strategy;

    @JsonProperty("interval")
    public double interval;

    @JsonProperty("isDelayed")
    public boolean isDelayed;

    @JsonProperty("isIndex")
    public boolean isIndex;

    @JsonProperty("daysToExpiration")
    public double daysToExpiration;

    @JsonProperty("interestRate")
    public double interestRate;

    @JsonProperty("underlyingPrice")
    public double underlyingPrice;

    @JsonProperty("volatility")
    public double volatility;

    @JsonProperty("callExpDateMap")
    public Map<String, Map<String, List<OptionContract>>> callExpDateMap;

    @JsonProperty("putExpDateMap")
    public Map<String, Map<String, List<OptionContract>>> putExpDateMap;

    @Override
    public String toString() {
        return "OptionChain{" +
                "symbol='" + symbol + '\'' +
                ", status='" + status + '\'' +
                ", underlying=" + underlying +
                ", strategy='" + strategy + '\'' +
                ", interval=" + interval +
                ", isDelayed=" + isDelayed +
                ", isIndex=" + isIndex +
                ", daysToExpiration=" + daysToExpiration +
                ", interestRate=" + interestRate +
                ", underlyingPrice=" + underlyingPrice +
                ", volatility=" + volatility +
                ", callExpDateMap=" + callExpDateMap +
                ", putExpDateMap=" + putExpDateMap +
                '}';
    }
}