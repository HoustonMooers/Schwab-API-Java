package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hm.schwab.datastructs.schwab.Enums.AssetType;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountCashEquivalent extends AccountsInstrument {
    public AccountCashEquivalent() {
    	this.assetType = AssetType.CASH_EQUIVALENT;
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
    @JsonProperty("type")
    public String type;
    
	@Override
	public String getSymbol() {
		return symbol;
	}
	
	@Override
	public String getDescription() {
		return description;
	}

    @Override
    public String toString() {
        return "AccountCashEquivalent{" +
                "assetType='" + assetType + '\'' +
                ", cusip='" + cusip + '\'' +
                ", symbol='" + symbol + '\'' +
                ", description='" + description + '\'' +
                ", instrumentId=" + instrumentId +
                ", netChange=" + netChange +
                ", type='" + type + '\'' +
                '}';
    }
}
