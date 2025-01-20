package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CashBalance {
    @JsonProperty("cashAvailableForTrading")
    public double cashAvailableForTrading;
    @JsonProperty("cashAvailableForWithdrawal")
    public double cashAvailableForWithdrawal;
    @JsonProperty("cashCall")
    public double cashCall;
    @JsonProperty("longNonMarginableMarketValue")
    public double longNonMarginableMarketValue;
    @JsonProperty("totalCash")
    public double totalCash;
    @JsonProperty("cashDebitCallValue")
    public double cashDebitCallValue;
    @JsonProperty("unsettledCash")
    public double unsettledCash;

    @Override
    public String toString() {
        return "CashBalance{" +
                "cashAvailableForTrading=" + cashAvailableForTrading +
                ", cashAvailableForWithdrawal=" + cashAvailableForWithdrawal +
                ", cashCall=" + cashCall +
                ", longNonMarginableMarketValue=" + longNonMarginableMarketValue +
                ", totalCash=" + totalCash +
                ", cashDebitCallValue=" + cashDebitCallValue +
                ", unsettledCash=" + unsettledCash +
                '}';
    }
}
