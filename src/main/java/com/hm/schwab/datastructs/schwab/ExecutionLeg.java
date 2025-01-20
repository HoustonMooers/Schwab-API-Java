package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExecutionLeg {
    @JsonProperty("legId")
    public Integer legId;

    @JsonProperty("quantity")
    public Double quantity;

    @JsonProperty("mismarkedQuantity")
    public Double mismarkedQuantity;

    @JsonProperty("price")
    public Double price;

    @JsonProperty("time")
    public String time;

    @Override
    public String toString() {
        return "ExecutionLeg{" +
                "legId=" + legId +
                ", quantity=" + quantity +
                ", mismarkedQuantity=" + mismarkedQuantity +
                ", price=" + price +
                ", time='" + time + '\'' +
                '}';
    }
}