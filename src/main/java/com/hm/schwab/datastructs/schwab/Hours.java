package com.hm.schwab.datastructs.schwab;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Hours {
    @JsonProperty("date")
    public String date;

    @JsonProperty("marketType")
    public String marketType;

    @JsonProperty("exchange")
    public String exchange;

    @JsonProperty("category")
    public String category;

    @JsonProperty("product")
    public String product;

    @JsonProperty("productName")
    public String productName;

    @JsonProperty("isOpen")
    public boolean isOpen;

    @JsonProperty("sessionHours")
    public Map<String, Interval[]> sessionHours;

    @Override
    public String toString() {
        return "Hours{" +
                "date='" + date + '\'' +
                ", marketType='" + marketType + '\'' +
                ", exchange='" + exchange + '\'' +
                ", category='" + category + '\'' +
                ", product='" + product + '\'' +
                ", productName='" + productName + '\'' +
                ", isOpen=" + isOpen +
                ", sessionHours=" + sessionHours +
                '}';
    }
}