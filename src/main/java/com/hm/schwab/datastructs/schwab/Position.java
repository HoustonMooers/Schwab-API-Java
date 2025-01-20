package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Position {
    @JsonProperty("shortQuantity")
    public double shortQuantity;
    @JsonProperty("averagePrice")
    public double averagePrice;
    @JsonProperty("currentDayProfitLoss")
    public double currentDayProfitLoss;
    @JsonProperty("currentDayProfitLossPercentage")
    public double currentDayProfitLossPercentage;
    @JsonProperty("longQuantity")
    public double longQuantity;
    @JsonProperty("settledLongQuantity")
    public double settledLongQuantity;
    @JsonProperty("settledShortQuantity")
    public double settledShortQuantity;
    @JsonProperty("agedQuantity")
    public double agedQuantity;
    @JsonProperty("instrument")
    public AccountsInstrument instrument;
    @JsonProperty("marketValue")
    public double marketValue;
    @JsonProperty("maintenanceRequirement")
    public double maintenanceRequirement;
    @JsonProperty("averageLongPrice")
    public double averageLongPrice;
    @JsonProperty("averageShortPrice")
    public double averageShortPrice;
    @JsonProperty("taxLotAverageLongPrice")
    public double taxLotAverageLongPrice;
    @JsonProperty("taxLotAverageShortPrice")
    public double taxLotAverageShortPrice;
    @JsonProperty("longOpenProfitLoss")
    public double longOpenProfitLoss;
    @JsonProperty("shortOpenProfitLoss")
    public double shortOpenProfitLoss;
    @JsonProperty("previousSessionLongQuantity")
    public double previousSessionLongQuantity;
    @JsonProperty("previousSessionShortQuantity")
    public double previousSessionShortQuantity;
    @JsonProperty("currentDayCost")
    public double currentDayCost;

    @Override
    public String toString() {
        return "Position{" +
                "shortQuantity=" + shortQuantity +
                ", averagePrice=" + averagePrice +
                ", currentDayProfitLoss=" + currentDayProfitLoss +
                ", currentDayProfitLossPercentage=" + currentDayProfitLossPercentage +
                ", longQuantity=" + longQuantity +
                ", settledLongQuantity=" + settledLongQuantity +
                ", settledShortQuantity=" + settledShortQuantity +
                ", agedQuantity=" + agedQuantity +
                ", instrument=" + instrument +
                ", marketValue=" + marketValue +
                ", maintenanceRequirement=" + maintenanceRequirement +
                ", averageLongPrice=" + averageLongPrice +
                ", averageShortPrice=" + averageShortPrice +
                ", taxLotAverageLongPrice=" + taxLotAverageLongPrice +
                ", taxLotAverageShortPrice=" + taxLotAverageShortPrice +
                ", longOpenProfitLoss=" + longOpenProfitLoss +
                ", shortOpenProfitLoss=" + shortOpenProfitLoss +
                ", previousSessionLongQuantity=" + previousSessionLongQuantity +
                ", previousSessionShortQuantity=" + previousSessionShortQuantity +
                ", currentDayCost=" + currentDayCost +
                '}';
    }
}