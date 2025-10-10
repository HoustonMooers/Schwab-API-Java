package com.hm.schwab.datastructs.schwab;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = MarginAccount.class, name = "MARGIN"),
        @JsonSubTypes.Type(value = CashAccount.class, name = "CASH")
})
public abstract class SecuritiesAccount {
    @JsonProperty("type")
    public String type;
    
    public abstract String getAccountNumber();

    public abstract int getRoundTrips();

    public abstract boolean isDayTrader();

    public abstract boolean isClosingOnlyRestricted();

    public abstract boolean isPfcbFlag();

    public abstract List<Position> getPositions();

	protected abstract double getBuyingPower();

	protected abstract double getCash();
}