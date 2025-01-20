package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuoteMutualFund {
    @JsonProperty("52WeekHigh")
    public double week52High;

    @JsonProperty("52WeekLow")
    public double week52Low;

    @JsonProperty("closePrice")
    public double closePrice;

    @JsonProperty("nAV")
    public double nAV;

    @JsonProperty("netChange")
    public double netChange;

    @JsonProperty("netPercentChange")
    public double netPercentChange;

    @JsonProperty("securityStatus")
    public String securityStatus;

    @JsonProperty("totalVolume")
    public long totalVolume;

    @JsonProperty("tradeTime")
    public long tradeTime;

    @Override
    public String toString() {
        return "QuoteMutualFund{" +
                "week52High=" + week52High +
                ", week52Low=" + week52Low +
                ", closePrice=" + closePrice +
                ", nAV=" + nAV +
                ", netChange=" + netChange +
                ", netPercentChange=" + netPercentChange +
                ", securityStatus='" + securityStatus + '\'' +
                ", totalVolume=" + totalVolume +
                ", tradeTime=" + tradeTime +
                '}';
    }
}