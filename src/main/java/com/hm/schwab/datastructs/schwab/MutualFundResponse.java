package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hm.schwab.datastructs.schwab.Enums.MutualFundAssetSubType;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MutualFundResponse extends QuoteResponseObject  {
    @JsonProperty("assetSubType")
    public MutualFundAssetSubType assetSubType;

    @JsonProperty("ssid")
    public long ssid;

    @JsonProperty("symbol")
    public String symbol;

    @JsonProperty("realtime")
    public boolean realtime;

    @JsonProperty("fundamental")
    public Fundamental fundamental;

    @JsonProperty("quote")
    public QuoteMutualFund quote;

    @JsonProperty("reference")
    public ReferenceMutualFund reference;

    @Override
    public String toString() {
        return "MutualFundResponse{" +
                "assetMainType=" + assetMainType +
                ", assetSubType=" + assetSubType +
                ", ssid=" + ssid +
                ", symbol='" + symbol + '\'' +
                ", realtime=" + realtime +
                ", fundamental=" + fundamental +
                ", quote=" + quote +
                ", reference=" + reference +
                '}';
    }

	@Override
	public double getBid() {
		return quote.closePrice;
	}

	@Override
	public double getAsk() {
		return quote.closePrice;
	}
	
	@Override
	public double getLast() {
		return quote.closePrice;
	}
	
	@Override
	public double getLow() {
		return getClose();
	}

	@Override
	public double getHigh() {
		return getClose();
	}

	@Override
	public double getOpen() {
		return getClose();
	}

	@Override
	public double getClose() {
		return quote.closePrice;
	}
	
	@Override
	public double getChange() {
		return quote.netChange;
	}
	
	@Override
	public long getVolume() {
		return quote.totalVolume;
	}
}