package com.hm.schwab.datastructs.schwab;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hm.schwab.datastructs.schwab.Enums.EquityAssetSubType;
import com.hm.schwab.datastructs.schwab.Enums.QuoteType;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EquityResponse extends QuoteResponseObject {
    @JsonProperty("assetSubType")
    public EquityAssetSubType assetSubType;

    @JsonProperty("ssid")
    public long ssid;

    @JsonProperty("symbol")
    public String symbol;

    @JsonProperty("realtime")
    public boolean realtime;

    @JsonProperty("quoteType")
    public QuoteType quoteType;

    @JsonProperty("extended")
    public ExtendedMarket extended;

    @JsonProperty("fundamental")
    public Fundamental fundamental;

    @JsonProperty("quote")
    public QuoteEquity quote;

    @JsonProperty("reference")
    public ReferenceEquity reference;

    @JsonProperty("regular")
    public RegularMarket regular;

    @Override
    public String toString() {
        return "EquityResponse{" +
                "assetMainType=" + assetMainType +
                ", assetSubType=" + assetSubType +
                ", ssid=" + ssid +
                ", symbol='" + symbol + '\'' +
                ", realtime=" + realtime +
                ", quoteType=" + quoteType +
                ", extended=" + extended +
                ", fundamental=" + fundamental +
                ", quote=" + quote +
                ", reference=" + reference +
                ", regular=" + regular +
                '}';
    }
}