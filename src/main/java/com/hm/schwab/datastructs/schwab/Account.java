package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Account {
    @JsonProperty("securitiesAccount")
    public SecuritiesAccount securitiesAccount;
    @JsonProperty("aggregatedBalance")
    public AggregatedBalance aggregatedBalance;

    @Override
    public String toString() {
        return "Account{" +
                "securitiesAccount=" + securitiesAccount +
                ", aggregatedBalance=" + aggregatedBalance +
                '}';
    }
}