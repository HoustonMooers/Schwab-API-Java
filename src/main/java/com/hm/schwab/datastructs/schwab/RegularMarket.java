package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegularMarket {
    @JsonProperty("regularMarketLastPrice")
    public double regularMarketLastPrice;

    @JsonProperty("regularMarketLastSize")
    public int regularMarketLastSize;

    @JsonProperty("regularMarketNetChange")
    public double regularMarketNetChange;

    @JsonProperty("regularMarketPercentChange")
    public double regularMarketPercentChange;

    @JsonProperty("regularMarketTradeTime")
    public long regularMarketTradeTime;

    @Override
    public String toString() {
        return "RegularMarket{" +
                "regularMarketLastPrice=" + regularMarketLastPrice +
                ", regularMarketLastSize=" + regularMarketLastSize +
                ", regularMarketNetChange=" + regularMarketNetChange +
                ", regularMarketPercentChange=" + regularMarketPercentChange +
                ", regularMarketTradeTime=" + regularMarketTradeTime +
                '}';
    }
}