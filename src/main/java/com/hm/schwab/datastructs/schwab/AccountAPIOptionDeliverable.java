package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountAPIOptionDeliverable {
    @JsonProperty("symbol")
    public String symbol;
    @JsonProperty("deliverableUnits")
    public double deliverableUnits;
    @JsonProperty("apiCurrencyType")
    public String apiCurrencyType;
    @JsonProperty("assetType")
    public String assetType;

    @Override
    public String toString() {
        return "AccountAPIOptionDeliverable{" +
                "symbol='" + symbol + '\'' +
                ", deliverableUnits=" + deliverableUnits +
                ", apiCurrencyType='" + apiCurrencyType + '\'' +
                ", assetType='" + assetType + '\'' +
                '}';
    }
}