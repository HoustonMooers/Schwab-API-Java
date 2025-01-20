package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReferenceFuture {
    @JsonProperty("description")
    public String description;

    @JsonProperty("exchange")
    public String exchange;

    @JsonProperty("exchangeName")
    public String exchangeName;

    @JsonProperty("futureActiveSymbol")
    public String futureActiveSymbol;

    @JsonProperty("futureExpirationDate")
    public long futureExpirationDate;

    @JsonProperty("futureIsActive")
    public boolean futureIsActive;

    @JsonProperty("futureMultiplier")
    public double futureMultiplier;

    @JsonProperty("futurePriceFormat")
    public String futurePriceFormat;

    @JsonProperty("futureSettlementPrice")
    public double futureSettlementPrice;

    @JsonProperty("futureTradingHours")
    public String futureTradingHours;

    @JsonProperty("product")
    public String product;

    @Override
    public String toString() {
        return "ReferenceFuture{" +
                "description='" + description + '\'' +
                ", exchange='" + exchange + '\'' +
                ", exchangeName='" + exchangeName + '\'' +
                ", futureActiveSymbol='" + futureActiveSymbol + '\'' +
                ", futureExpirationDate=" + futureExpirationDate +
                ", futureIsActive=" + futureIsActive +
                ", futureMultiplier=" + futureMultiplier +
                ", futurePriceFormat='" + futurePriceFormat + '\'' +
                ", futureSettlementPrice=" + futureSettlementPrice +
                ", futureTradingHours='" + futureTradingHours + '\'' +
                ", product='" + product + '\'' +
                '}';
    }
}