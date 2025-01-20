package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReferenceForex {
    @JsonProperty("description")
    public String description;

    @JsonProperty("exchange")
    public String exchange;

    @JsonProperty("exchangeName")
    public String exchangeName;

    @JsonProperty("isTradable")
    public boolean isTradable;

    @JsonProperty("marketMaker")
    public String marketMaker;

    @JsonProperty("product")
    public String product;

    @JsonProperty("tradingHours")
    public String tradingHours;

    @Override
    public String toString() {
        return "ReferenceForex{" +
                "description='" + description + '\'' +
                ", exchange='" + exchange + '\'' +
                ", exchangeName='" + exchangeName + '\'' +
                ", isTradable=" + isTradable +
                ", marketMaker='" + marketMaker + '\'' +
                ", product='" + product + '\'' +
                ", tradingHours='" + tradingHours + '\'' +
                '}';
    }
}