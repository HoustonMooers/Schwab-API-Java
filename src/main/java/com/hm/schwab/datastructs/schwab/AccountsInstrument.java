package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.hm.schwab.datastructs.schwab.Enums.AssetType;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "assetType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = AccountCashEquivalent.class, name = "CASH_EQUIVALENT"),
        @JsonSubTypes.Type(value = AccountEquity.class, name = "EQUITY"),
        @JsonSubTypes.Type(value = AccountEquity.class, name = "COLLECTIVE_INVESTMENT"),
        @JsonSubTypes.Type(value = AccountFixedIncome.class, name = "FIXED_INCOME"),
        @JsonSubTypes.Type(value = AccountMutualFund.class, name = "MUTUAL_FUND"),
        @JsonSubTypes.Type(value = AccountOption.class, name = "OPTION")
})
public abstract class AccountsInstrument {
    public transient AssetType assetType;
    public abstract String getSymbol();
    public abstract String getDescription();
}