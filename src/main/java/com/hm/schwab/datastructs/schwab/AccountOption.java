package com.hm.schwab.datastructs.schwab;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hm.schwab.datastructs.schwab.Enums.AssetType;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountOption extends AccountsInstrument {
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
    @JsonProperty("optionDeliverables")
    public List<AccountAPIOptionDeliverable> optionDeliverables;
    @JsonProperty("putCall")
    public String putCall;
    @JsonProperty("optionMultiplier")
    public int optionMultiplier;
    @JsonProperty("type")
    public String type;
    @JsonProperty("underlyingSymbol")
    public String underlyingSymbol;
    
	public AccountOption() {
		this.assetType = AssetType.OPTION;
	}

	public AccountOption(String symbol) {
		this();
		this.symbol = symbol;
	}
    
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
        return "AccountOption{" +
                "assetType='" + assetType + '\'' +
                ", cusip='" + cusip + '\'' +
                ", symbol='" + symbol + '\'' +
                ", description='" + description + '\'' +
                ", instrumentId=" + instrumentId +
                ", netChange=" + netChange +
                ", optionDeliverables=" + optionDeliverables +
                ", putCall='" + putCall + '\'' +
                ", optionMultiplier=" + optionMultiplier +
                ", type='" + type + '\'' +
                ", underlyingSymbol='" + underlyingSymbol + '\'' +
                '}';
    }
}