package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AggregatedBalance {
    @JsonProperty("currentLiquidationValue")
    public double currentLiquidationValue;
    @JsonProperty("liquidationValue")
    public double liquidationValue;

    @Override
    public String toString() {
        return "AggregatedBalance{" +
                "currentLiquidationValue=" + currentLiquidationValue +
                ", liquidationValue=" + liquidationValue +
                '}';
    }
}
