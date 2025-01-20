package com.hm.schwab.datastructs.schwab;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExpirationChain {
    @JsonProperty("status")
    public String status;

    @JsonProperty("expirationList")
    public List<Expiration> expirationList;

    @Override
    public String toString() {
        return "ExpirationChain{" +
                "status='" + status + '\'' +
                ", expirationList=" + expirationList +
                '}';
    }
}