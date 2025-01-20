package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OptionDeliverables {
    @JsonProperty("symbol")
    public String symbol;

    @JsonProperty("assetType")
    public String assetType;

    @JsonProperty("deliverableUnits")
    public String deliverableUnits;

    @JsonProperty("currencyType")
    public String currencyType;

    @Override
    public String toString() {
        return "OptionDeliverables{" +
                "symbol='" + symbol + '\'' +
                ", assetType='" + assetType + '\'' +
                ", deliverableUnits='" + deliverableUnits + '\'' +
                ", currencyType='" + currencyType + '\'' +
                '}';
    }
}