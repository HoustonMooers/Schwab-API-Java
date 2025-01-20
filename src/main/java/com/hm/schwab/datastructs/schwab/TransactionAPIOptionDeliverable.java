package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionAPIOptionDeliverable {
    @JsonProperty("rootSymbol")
    public String rootSymbol;

    @JsonProperty("strikePercent")
    public int strikePercent;

    @JsonProperty("deliverableNumber")
    public int deliverableNumber;

    @JsonProperty("deliverableUnits")
    public double deliverableUnits;

    @JsonProperty("deliverable")
    public Object deliverable;

    @JsonProperty("assetType")
    public String assetType;
}