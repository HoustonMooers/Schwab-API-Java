package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuoteIndex {
    @JsonProperty("52WeekHigh")
    public double week52High;

    @JsonProperty("52WeekLow")
    public double week52Low;

    @JsonProperty("closePrice")
    public double closePrice;

    @JsonProperty("highPrice")
    public double highPrice;

    @JsonProperty("lastPrice")
    public double lastPrice;

    @JsonProperty("lowPrice")
    public double lowPrice;

    @JsonProperty("netChange")
    public double netChange;

    @JsonProperty("netPercentChange")
    public double netPercentChange;

    @JsonProperty("openPrice")
    public double openPrice;

    @JsonProperty("securityStatus")
    public String securityStatus;

    @JsonProperty("totalVolume")
    public long totalVolume;

    @JsonProperty("tradeTime")
    public long tradeTime;

    @Override
    public String toString() {
        return "QuoteIndex{" +
                "week52High=" + week52High +
                ", week52Low=" + week52Low +
                ", closePrice=" + closePrice +
                ", highPrice=" + highPrice +
                ", lastPrice=" + lastPrice +
                ", lowPrice=" + lowPrice +
                ", netChange=" + netChange +
                ", netPercentChange=" + netPercentChange +
                ", openPrice=" + openPrice +
                ", securityStatus='" + securityStatus + '\'' +
                ", totalVolume=" + totalVolume +
                ", tradeTime=" + tradeTime +
                '}';
    }
}