package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarginBalance {
    @JsonProperty("availableFunds")
    public double availableFunds;
    @JsonProperty("availableFundsNonMarginableTrade")
    public double availableFundsNonMarginableTrade;
    @JsonProperty("buyingPower")
    public double buyingPower;
    @JsonProperty("buyingPowerNonMarginableTrade")
    public double buyingPowerNonMarginableTrade;
    @JsonProperty("dayTradingBuyingPower")
    public double dayTradingBuyingPower;
    @JsonProperty("dayTradingBuyingPowerCall")
    public double dayTradingBuyingPowerCall;
    @JsonProperty("equity")
    public double equity;
    @JsonProperty("equityPercentage")
    public double equityPercentage;
    @JsonProperty("longMarginValue")
    public double longMarginValue;
    @JsonProperty("maintenanceCall")
    public double maintenanceCall;
    @JsonProperty("maintenanceRequirement")
    public double maintenanceRequirement;
    @JsonProperty("marginBalance")
    public double marginBalance;
    @JsonProperty("regTCall")
    public double regTCall;
    @JsonProperty("shortBalance")
    public double shortBalance;
    @JsonProperty("shortMarginValue")
    public double shortMarginValue;
    @JsonProperty("sma")
    public double sma;
    @JsonProperty("isInCall")
    public boolean isInCall;
    @JsonProperty("stockBuyingPower")
    public double stockBuyingPower;
    @JsonProperty("optionBuyingPower")
    public double optionBuyingPower;

    @Override
    public String toString() {
        return "MarginBalance{" +
                "availableFunds=" + availableFunds +
                ", availableFundsNonMarginableTrade=" + availableFundsNonMarginableTrade +
                ", buyingPower=" + buyingPower +
                ", buyingPowerNonMarginableTrade=" + buyingPowerNonMarginableTrade +
                ", dayTradingBuyingPower=" + dayTradingBuyingPower +
                ", dayTradingBuyingPowerCall=" + dayTradingBuyingPowerCall +
                ", equity=" + equity +
                ", equityPercentage=" + equityPercentage +
                ", longMarginValue=" + longMarginValue +
                ", maintenanceCall=" + maintenanceCall +
                ", maintenanceRequirement=" + maintenanceRequirement +
                ", marginBalance=" + marginBalance +
                ", regTCall=" + regTCall +
                ", shortBalance=" + shortBalance +
                ", shortMarginValue=" + shortMarginValue +
                ", sma=" + sma +
                ", isInCall=" + isInCall +
                ", stockBuyingPower=" + stockBuyingPower +
                ", optionBuyingPower=" + optionBuyingPower +
                '}';
    }
}
