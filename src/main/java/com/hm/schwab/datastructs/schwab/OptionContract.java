package com.hm.schwab.datastructs.schwab;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OptionContract {
    @JsonProperty("putCall")
    public String putCall;

    @JsonProperty("symbol")
    public String symbol;

    @JsonProperty("description")
    public String description;

    @JsonProperty("exchangeName")
    public String exchangeName;

    @JsonProperty("bid")
    public double bidPrice;

    @JsonProperty("ask")
    public double askPrice;

    @JsonProperty("last")
    public double lastPrice;

    @JsonProperty("mark")
    public double markPrice;

    @JsonProperty("bidSize")
    public int bidSize;

    @JsonProperty("askSize")
    public int askSize;

    @JsonProperty("lastSize")
    public int lastSize;

    @JsonProperty("highPrice")
    public double highPrice;

    @JsonProperty("lowPrice")
    public double lowPrice;

    @JsonProperty("openPrice")
    public double openPrice;

    @JsonProperty("closePrice")
    public double closePrice;

    @JsonProperty("totalVolume")
    public int totalVolume;

    @JsonProperty("tradeDate")
    public long tradeDate;

    @JsonProperty("quoteTimeInLong")
    public long quoteTimeInLong;

    @JsonProperty("tradeTimeInLong")
    public long tradeTimeInLong;

    @JsonProperty("netChange")
    public double netChange;

    @JsonProperty("volatility")
    public double volatility;

    @JsonProperty("delta")
    public double delta;

    @JsonProperty("gamma")
    public double gamma;

    @JsonProperty("theta")
    public double theta;

    @JsonProperty("vega")
    public double vega;

    @JsonProperty("rho")
    public double rho;

    @JsonProperty("timeValue")
    public double timeValue;

    @JsonProperty("openInterest")
    public int openInterest;

    @JsonProperty("isInTheMoney")
    public boolean isInTheMoney;

    @JsonProperty("theoreticalOptionValue")
    public double theoreticalOptionValue;

    @JsonProperty("theoreticalVolatility")
    public double theoreticalVolatility;

    @JsonProperty("isMini")
    public boolean isMini;

    @JsonProperty("isNonStandard")
    public boolean isNonStandard;

    @JsonProperty("optionDeliverablesList")
    public List<OptionDeliverables> optionDeliverablesList;

    @JsonProperty("strikePrice")
    public double strikePrice;

    @JsonProperty("expirationDate")
    public String expirationDate;

    @JsonProperty("daysToExpiration")
    public int daysToExpiration;

    @JsonProperty("expirationType")
    public String expirationType;

    @JsonProperty("lastTradingDay")
    public long lastTradingDay;

    @JsonProperty("multiplier")
    public double multiplier;

    @JsonProperty("settlementType")
    public String settlementType;

    @JsonProperty("deliverableNote")
    public String deliverableNote;

    @JsonProperty("isIndexOption")
    public boolean isIndexOption;

    @JsonProperty("percentChange")
    public double percentChange;

    @JsonProperty("markChange")
    public double markChange;

    @JsonProperty("markPercentChange")
    public double markPercentChange;

    @JsonProperty("isPennyPilot")
    public boolean isPennyPilot;

    @JsonProperty("intrinsicValue")
    public double intrinsicValue;

    @JsonProperty("optionRoot")
    public String optionRoot;

    @Override
    public String toString() {
        return "OptionContract{" +
                "putCall='" + putCall + '\'' +
                ", symbol='" + symbol + '\'' +
                ", description='" + description + '\'' +
                ", exchangeName='" + exchangeName + '\'' +
                ", bidPrice=" + bidPrice +
                ", askPrice=" + askPrice +
                ", lastPrice=" + lastPrice +
                ", markPrice=" + markPrice +
                ", bidSize=" + bidSize +
                ", askSize=" + askSize +
                ", lastSize=" + lastSize +
                ", highPrice=" + highPrice +
                ", lowPrice=" + lowPrice +
                ", openPrice=" + openPrice +
                ", closePrice=" + closePrice +
                ", totalVolume=" + totalVolume +
                ", tradeDate=" + tradeDate +
                ", quoteTimeInLong=" + quoteTimeInLong +
                ", tradeTimeInLong=" + tradeTimeInLong +
                ", netChange=" + netChange +
                ", volatility=" + volatility +
                ", delta=" + delta +
                ", gamma=" + gamma +
                ", theta=" + theta +
                ", vega=" + vega +
                ", rho=" + rho +
                ", timeValue=" + timeValue +
                ", openInterest=" + openInterest +
                ", isInTheMoney=" + isInTheMoney +
                ", theoreticalOptionValue=" + theoreticalOptionValue +
                ", theoreticalVolatility=" + theoreticalVolatility +
                ", isMini=" + isMini +
                ", isNonStandard=" + isNonStandard +
                ", optionDeliverablesList=" + optionDeliverablesList +
                ", strikePrice=" + strikePrice +
                ", expirationDate='" + expirationDate + '\'' +
                ", daysToExpiration=" + daysToExpiration +
                ", expirationType='" + expirationType + '\'' +
                ", lastTradingDay=" + lastTradingDay +
                ", multiplier=" + multiplier +
                ", settlementType='" + settlementType + '\'' +
                ", deliverableNote='" + deliverableNote + '\'' +
                ", isIndexOption=" + isIndexOption +
                ", percentChange=" + percentChange +
                ", markChange=" + markChange +
                ", markPercentChange=" + markPercentChange +
                ", isPennyPilot=" + isPennyPilot +
                ", intrinsicValue=" + intrinsicValue +
                ", optionRoot='" + optionRoot + '\'' +
                '}';
    }
}