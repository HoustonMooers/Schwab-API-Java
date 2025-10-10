package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hm.schwab.datastructs.schwab.Enums.AssetType;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountEquity extends AccountsInstrument {
	public AccountEquity() {
		this.assetType = AssetType.EQUITY;
	}

	public AccountEquity(String symbol) {
		this.assetType = AssetType.EQUITY;
		this.symbol = symbol;
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
        return "AccountEquity{" +
                "assetType='" + assetType + '\'' +
                ", cusip='" + cusip + '\'' +
                ", symbol='" + symbol + '\'' +
                ", description='" + description + '\'' +
                ", instrumentId=" + instrumentId +
                ", netChange=" + netChange +
                '}';
    }
}
