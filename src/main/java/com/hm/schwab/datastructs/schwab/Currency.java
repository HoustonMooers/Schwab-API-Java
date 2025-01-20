package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Currency {
    @JsonProperty("assetType")
    public String assetType;

    @JsonProperty("cusip")
    public String cusip;

    @JsonProperty("symbol")
    public String symbol;

    @JsonProperty("description")
    public String description;

    @JsonProperty("instrumentId")
    public long instrumentId;

    @JsonProperty("netChange")
    public double netChange;
}