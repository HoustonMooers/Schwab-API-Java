package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReferenceEquity {
    @JsonProperty("cusip")
    public String cusip;

    @JsonProperty("description")
    public String description;

    @JsonProperty("exchange")
    public String exchange;

    @JsonProperty("exchangeName")
    public String exchangeName;

    @JsonProperty("fsiDesc")
    public String fsiDesc;

    @JsonProperty("htbQuantity")
    public int htbQuantity;

    @JsonProperty("htbRate")
    public double htbRate;

    @JsonProperty("isHardToBorrow")
    public boolean isHardToBorrow;

    @JsonProperty("isShortable")
    public boolean isShortable;

    @JsonProperty("otcMarketTier")
    public String otcMarketTier;

    @Override
    public String toString() {
        return "ReferenceEquity{" +
                "cusip='" + cusip + '\'' +
                ", description='" + description + '\'' +
                ", exchange='" + exchange + '\'' +
                ", exchangeName='" + exchangeName + '\'' +
                ", fsiDesc='" + fsiDesc + '\'' +
                ", htbQuantity=" + htbQuantity +
                ", htbRate=" + htbRate +
                ", isHardToBorrow=" + isHardToBorrow +
                ", isShortable=" + isShortable +
                ", otcMarketTier='" + otcMarketTier + '\'' +
                '}';
    }
}