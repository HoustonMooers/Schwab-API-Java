package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hm.schwab.datastructs.schwab.Enums.AssetType;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountFixedIncome extends AccountsInstrument {
    public AccountFixedIncome() {
    	this.assetType = AssetType.FIXED_INCOME;
    }

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
    @JsonProperty("maturityDate")
    public String maturityDate;
    @JsonProperty("factor")
    public double factor;
    @JsonProperty("variableRate")
    public double variableRate;

    @Override
    public String toString() {
        return "AccountFixedIncome{" +
                "assetType='" + assetType + '\'' +
                ", cusip='" + cusip + '\'' +
                ", symbol='" + symbol + '\'' +
                ", description='" + description + '\'' +
                ", instrumentId=" + instrumentId +
                ", netChange=" + netChange +
                ", maturityDate='" + maturityDate + '\'' +
                ", factor=" + factor +
                ", variableRate=" + variableRate +
                '}';
    }
}
