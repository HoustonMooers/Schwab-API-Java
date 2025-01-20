package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuoteOption {
    @JsonProperty("52WeekHigh")
    public double week52High;

    @JsonProperty("52WeekLow")
    public double week52Low;

    @JsonProperty("askPrice")
    public double askPrice;

    @JsonProperty("askSize")
    public int askSize;

    @JsonProperty("bidPrice")
    public double bidPrice;

    @JsonProperty("bidSize")
    public int bidSize;

    @JsonProperty("closePrice")
    public double closePrice;

    @JsonProperty("delta")
    public double delta;

    @JsonProperty("gamma")
    public double gamma;

    @JsonProperty("highPrice")
    public double highPrice;

    @JsonProperty("indAskPrice")
    public double indAskPrice;

    @JsonProperty("indBidPrice")
    public double indBidPrice;

    @JsonProperty("indQuoteTime")
    public long indQuoteTime;

    @JsonProperty("impliedYield")
    public double impliedYield;

    @JsonProperty("lastPrice")
    public double lastPrice;

    @JsonProperty("lastSize")
    public int lastSize;

    @JsonProperty("lowPrice")
    public double lowPrice;

    @JsonProperty("mark")
    public double mark;

    @JsonProperty("markChange")
    public double markChange;

    @JsonProperty("markPercentChange")
    public double markPercentChange;

    @JsonProperty("moneyIntrinsicValue")
    public double moneyIntrinsicValue;

    @JsonProperty("netChange")
    public double netChange;

    @JsonProperty("netPercentChange")
    public double netPercentChange;

    @JsonProperty("openInterest")
    public double openInterest;

    @JsonProperty("openPrice")
    public double openPrice;

    @JsonProperty("quoteTime")
    public long quoteTime;

    @JsonProperty("rho")
    public double rho;

    @JsonProperty("securityStatus")
    public String securityStatus;

    @JsonProperty("theoreticalOptionValue")
    public double theoreticalOptionValue;

    @JsonProperty("theta")
    public double theta;

    @JsonProperty("timeValue")
    public double timeValue;

    @JsonProperty("totalVolume")
    public long totalVolume;

    @JsonProperty("tradeTime")
    public long tradeTime;

    @JsonProperty("underlyingPrice")
    public double underlyingPrice;

    @JsonProperty("vega")
    public double vega;

    @JsonProperty("volatility")
    public double volatility;

    @Override
    public String toString() {
        return "QuoteOption{" +
                "week52High=" + week52High +
                ", week52Low=" + week52Low +
                ", askPrice=" + askPrice +
                ", askSize=" + askSize +
                ", bidPrice=" + bidPrice +
                ", bidSize=" + bidSize +
                ", closePrice=" + closePrice +
                ", delta=" + delta +
                ", gamma=" + gamma +
                ", highPrice=" + highPrice +
                ", indAskPrice=" + indAskPrice +
                ", indBidPrice=" + indBidPrice +
                ", indQuoteTime=" + indQuoteTime +
                ", impliedYield=" + impliedYield +
                ", lastPrice=" + lastPrice +
                ", lastSize=" + lastSize +
                ", lowPrice=" + lowPrice +
                ", mark=" + mark +
                ", markChange=" + markChange +
                ", markPercentChange=" + markPercentChange +
                ", moneyIntrinsicValue=" + moneyIntrinsicValue +
                ", netChange=" + netChange +
                ", netPercentChange=" + netPercentChange +
                ", openInterest=" + openInterest +
                ", openPrice=" + openPrice +
                ", quoteTime=" + quoteTime +
                ", rho=" + rho +
                ", securityStatus='" + securityStatus + '\'' +
                ", theoreticalOptionValue=" + theoreticalOptionValue +
                ", theta=" + theta +
                ", timeValue=" + timeValue +
                ", totalVolume=" + totalVolume +
                ", tradeTime=" + tradeTime +
                ", underlyingPrice=" + underlyingPrice +
                ", vega=" + vega +
                ", volatility=" + volatility +
                '}';
    }
}
