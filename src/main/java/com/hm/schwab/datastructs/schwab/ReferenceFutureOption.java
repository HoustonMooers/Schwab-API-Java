package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hm.schwab.datastructs.schwab.Enums.ContractType;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReferenceFutureOption {
    @JsonProperty("contractType")
    public ContractType contractType;

    @JsonProperty("description")
    public String description;

    @JsonProperty("exchange")
    public String exchange;

    @JsonProperty("exchangeName")
    public String exchangeName;

    @JsonProperty("multiplier")
    public double multiplier;

    @JsonProperty("expirationDate")
    public long expirationDate;

    @JsonProperty("expirationStyle")
    public String expirationStyle;

    @JsonProperty("strikePrice")
    public double strikePrice;

    @JsonProperty("underlying")
    public String underlying;

    @Override
    public String toString() {
        return "ReferenceFutureOption{" +
                "contractType=" + contractType +
                ", description='" + description + '\'' +
                ", exchange='" + exchange + '\'' +
                ", exchangeName='" + exchangeName + '\'' +
                ", multiplier=" + multiplier +
                ", expirationDate=" + expirationDate +
                ", expirationStyle='" + expirationStyle + '\'' +
                ", strikePrice=" + strikePrice +
                ", underlying='" + underlying + '\'' +
                '}';
    }
}
