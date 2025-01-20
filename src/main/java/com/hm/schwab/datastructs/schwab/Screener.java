package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hm.schwab.datastructs.schwab.Enums.Direction;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Screener {
    @JsonProperty("change")
    public double change;

    @JsonProperty("description")
    public String description;

    @JsonProperty("direction")
    public Direction direction;

    @JsonProperty("last")
    public double last;

    @JsonProperty("symbol")
    public String symbol;

    @JsonProperty("totalVolume")
    public long totalVolume;

    @Override
    public String toString() {
        return "Screener{" +
                "change=" + change +
                ", description='" + description + '\'' +
                ", direction=" + direction +
                ", last=" + last +
                ", symbol='" + symbol + '\'' +
                ", totalVolume=" + totalVolume +
                '}';
    }
}