package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarginInitialBalance {
    @JsonProperty("accruedInterest")
    public double accruedInterest;
    @JsonProperty("availableFundsNonMarginableTrade")
    public double availableFundsNonMarginableTrade;
    @JsonProperty("bondValue")
    public double bondValue;
    @JsonProperty("buyingPower")
    public double buyingPower;
    @JsonProperty("cashBalance")
    public double cashBalance;
    @JsonProperty("cashAvailableForTrading")
    public double cashAvailableForTrading;
    @JsonProperty("cashReceipts")
    public double cashReceipts;
    @JsonProperty("dayTradingBuyingPower")
    public double dayTradingBuyingPower;
    @JsonProperty("dayTradingBuyingPowerCall")
    public double dayTradingBuyingPowerCall;
    @JsonProperty("dayTradingEquityCall")
    public double dayTradingEquityCall;
    @JsonProperty("equity")
    public double equity;
    @JsonProperty("equityPercentage")
    public double equityPercentage;
    @JsonProperty("liquidationValue")
    public double liquidationValue;
    @JsonProperty("longMarginValue")
    public double longMarginValue;
    @JsonProperty("longOptionMarketValue")
    public double longOptionMarketValue;
    @JsonProperty("longStockValue")
    public double longStockValue;
    @JsonProperty("maintenanceCall")
    public double maintenanceCall;
    @JsonProperty("maintenanceRequirement")
    public double maintenanceRequirement;
    @JsonProperty("margin")
    public double margin;
    @JsonProperty("marginEquity")
    public double marginEquity;
    @JsonProperty("moneyMarketFund")
    public double moneyMarketFund;
    @JsonProperty("mutualFundValue")
    public double mutualFundValue;
    @JsonProperty("regTCall")
    public double regTCall;
    @JsonProperty("shortMarginValue")
    public double shortMarginValue;
    @JsonProperty("shortOptionMarketValue")
    public double shortOptionMarketValue;
    @JsonProperty("shortStockValue")
    public double shortStockValue;
    @JsonProperty("totalCash")
    public double totalCash;
    @JsonProperty("isInCall")
    public boolean isInCall;
    @JsonProperty("unsettledCash")
    public double unsettledCash;
    @JsonProperty("pendingDeposits")
    public double pendingDeposits;
    @JsonProperty("marginBalance")
    public double marginBalance;
    @JsonProperty("shortBalance")
    public double shortBalance;
    @JsonProperty("accountValue")
    public double accountValue;

    @Override
    public String toString() {
        return "MarginInitialBalance{" +
                "accruedInterest=" + accruedInterest +
                ", availableFundsNonMarginableTrade=" + availableFundsNonMarginableTrade +
                ", bondValue=" + bondValue +
                ", buyingPower=" + buyingPower +
                ", cashBalance=" + cashBalance +
                ", cashAvailableForTrading=" + cashAvailableForTrading +
                ", cashReceipts=" + cashReceipts +
                ", dayTradingBuyingPower=" + dayTradingBuyingPower +
                ", dayTradingBuyingPowerCall=" + dayTradingBuyingPowerCall +
                ", dayTradingEquityCall=" + dayTradingEquityCall +
                ", equity=" + equity +
                ", equityPercentage=" + equityPercentage +
                ", liquidationValue=" + liquidationValue +
                ", longMarginValue=" + longMarginValue +
                ", longOptionMarketValue=" + longOptionMarketValue +
                ", longStockValue=" + longStockValue +
                ", maintenanceCall=" + maintenanceCall +
                ", maintenanceRequirement=" + maintenanceRequirement +
                ", margin=" + margin +
                ", marginEquity=" + marginEquity +
                ", moneyMarketFund=" + moneyMarketFund +
                ", mutualFundValue=" + mutualFundValue +
                ", regTCall=" + regTCall +
                ", shortMarginValue=" + shortMarginValue +
                ", shortOptionMarketValue=" + shortOptionMarketValue +
                ", shortStockValue=" + shortStockValue +
                ", totalCash=" + totalCash +
                ", isInCall=" + isInCall +
                ", unsettledCash=" + unsettledCash +
                ", pendingDeposits=" + pendingDeposits +
                ", marginBalance=" + marginBalance +
                ", shortBalance=" + shortBalance +
                ", accountValue=" + accountValue +
                '}';
    }
}
