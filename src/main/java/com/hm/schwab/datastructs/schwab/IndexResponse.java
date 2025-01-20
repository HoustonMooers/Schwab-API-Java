package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class IndexResponse extends QuoteResponseObject  {
    @JsonProperty("ssid")
    public long ssid;

    @JsonProperty("symbol")
    public String symbol;

    @JsonProperty("realtime")
    public boolean realtime;

    @JsonProperty("quote")
    public QuoteIndex quote;

    @JsonProperty("reference")
    public ReferenceIndex reference;

    @Override
    public String toString() {
        return "IndexResponse{" +
                "assetMainType=" + assetMainType +
                ", ssid=" + ssid +
                ", symbol='" + symbol + '\'' +
                ", realtime=" + realtime +
                ", quote=" + quote +
                ", reference=" + reference +
                '}';
    }
}
