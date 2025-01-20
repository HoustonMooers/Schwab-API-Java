package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CashInitialBalance {
    @JsonProperty("accruedInterest")
    public double accruedInterest;
    @JsonProperty("cashAvailableForTrading")
    public double cashAvailableForTrading;
    @JsonProperty("cashAvailableForWithdrawal")
    public double cashAvailableForWithdrawal;
    @JsonProperty("cashBalance")
    public double cashBalance;
    @JsonProperty("bondValue")
    public double bondValue;
    @JsonProperty("cashReceipts")
    public double cashReceipts;
    @JsonProperty("liquidationValue")
    public double liquidationValue;
    @JsonProperty("longOptionMarketValue")
    public double longOptionMarketValue;
    @JsonProperty("longStockValue")
    public double longStockValue;
    @JsonProperty("moneyMarketFund")
    public double moneyMarketFund;
    @JsonProperty("mutualFundValue")
    public double mutualFundValue;
    @JsonProperty("shortOptionMarketValue")
    public double shortOptionMarketValue;
    @JsonProperty("shortStockValue")
    public double shortStockValue;
    @JsonProperty("isInCall")
    public boolean isInCall;
    @JsonProperty("unsettledCash")
    public double unsettledCash;
    @JsonProperty("cashDebitCallValue")
    public double cashDebitCallValue;
    @JsonProperty("pendingDeposits")
    public double pendingDeposits;
    @JsonProperty("accountValue")
    public double accountValue;

    @Override
    public String toString() {
        return "CashInitialBalance{" +
                "accruedInterest=" + accruedInterest +
                ", cashAvailableForTrading=" + cashAvailableForTrading +
                ", cashAvailableForWithdrawal=" + cashAvailableForWithdrawal +
                ", cashBalance=" + cashBalance +
                ", bondValue=" + bondValue +
                ", cashReceipts=" + cashReceipts +
                ", liquidationValue=" + liquidationValue +
                ", longOptionMarketValue=" + longOptionMarketValue +
                ", longStockValue=" + longStockValue +
                ", moneyMarketFund=" + moneyMarketFund +
                ", mutualFundValue=" + mutualFundValue +
                ", shortOptionMarketValue=" + shortOptionMarketValue +
                ", shortStockValue=" + shortStockValue +
                ", isInCall=" + isInCall +
                ", unsettledCash=" + unsettledCash +
                ", cashDebitCallValue=" + cashDebitCallValue +
                ", pendingDeposits=" + pendingDeposits +
                ", accountValue=" + accountValue +
                '}';
    }
}
