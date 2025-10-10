package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ForexResponse extends QuoteResponseObject {
    @JsonProperty("ssid")
    public long ssid;

    @JsonProperty("symbol")
    public String symbol;

    @JsonProperty("realtime")
    public boolean realtime;

    @JsonProperty("quote")
    public QuoteForex quote;

    @JsonProperty("reference")
    public ReferenceForex reference;

    @Override
    public String toString() {
        return "ForexResponse{" +
                "assetMainType=" + assetMainType +
                ", ssid=" + ssid +
                ", symbol='" + symbol + '\'' +
                ", realtime=" + realtime +
                ", quote=" + quote +
                ", reference=" + reference +
                '}';
    }

	@Override
	public double getBid() {
		return quote.bidPrice;
	}

	@Override
	public double getAsk() {
		return quote.askPrice;
	}
	
	@Override
	public double getLast() {
		return quote.lastPrice;
	}
	
	@Override
	public double getLow() {
		return quote.lowPrice;
	}

	@Override
	public double getHigh() {
		return quote.highPrice;
	}

	@Override
	public double getOpen() {
		return quote.openPrice;
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