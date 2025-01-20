package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReferenceMutualFund {
    @JsonProperty("cusip")
    public String cusip;

    @JsonProperty("description")
    public String description;

    @JsonProperty("exchange")
    public String exchange;

    @JsonProperty("exchangeName")
    public String exchangeName;

    @Override
    public String toString() {
        return "ReferenceMutualFund{" +
                "cusip='" + cusip + '\'' +
                ", description='" + description + '\'' +
                ", exchange='" + exchange + '\'' +
                ", exchangeName='" + exchangeName + '\'' +
                '}';
    }
}