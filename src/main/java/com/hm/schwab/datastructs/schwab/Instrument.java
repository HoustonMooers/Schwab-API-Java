package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hm.schwab.datastructs.schwab.Enums.AssetType;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Instrument {
    @JsonProperty("cusip")
    public String cusip;

    @JsonProperty("symbol")
    public String symbol;

    @JsonProperty("description")
    public String description;

    @JsonProperty("exchange")
    public String exchange;

    @JsonProperty("assetType")
    public AssetType assetType;

    @JsonProperty("bondFactor")
    public String bondFactor;

    @JsonProperty("bondMultiplier")
    public String bondMultiplier;

    @JsonProperty("bondPrice")
    public double bondPrice;

    @JsonProperty("fundamental")
    public FundamentalInst fundamental;

    @JsonProperty("instrumentInfo")
    public Instrument instrumentInfo;

    @JsonProperty("bondInstrumentInfo")
    public Bond bondInstrumentInfo;

    @Override
    public String toString() {
        return "Instrument{" +
                "cusip='" + cusip + '\'' +
                ", symbol='" + symbol + '\'' +
                ", description='" + description + '\'' +
                ", exchange='" + exchange + '\'' +
                ", assetType=" + assetType +
                ", bondFactor='" + bondFactor + '\'' +
                ", bondMultiplier='" + bondMultiplier + '\'' +
                ", bondPrice=" + bondPrice +
                ", fundamental=" + fundamental +
                ", instrumentInfo=" + instrumentInfo +
                ", bondInstrumentInfo=" + bondInstrumentInfo +
                '}';
    }
}