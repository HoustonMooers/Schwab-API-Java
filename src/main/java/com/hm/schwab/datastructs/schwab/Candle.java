package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Candle {
    @JsonProperty("close")
    public double close;

    @JsonProperty("datetime")
    public long datetime;

    @JsonProperty("datetimeISO8601")
    public String datetimeISO8601;

    @JsonProperty("high")
    public double high;

    @JsonProperty("low")
    public double low;

    @JsonProperty("open")
    public double open;

    @JsonProperty("volume")
    public long volume;

    @Override
    public String toString() {
        return "Candle{" +
                "close=" + close +
                ", datetime=" + datetime +
                ", datetimeISO8601='" + datetimeISO8601 + '\'' +
                ", high=" + high +
                ", low=" + low +
                ", open=" + open +
                ", volume=" + volume +
                '}';
    }
}
