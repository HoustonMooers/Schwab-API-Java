package com.hm.schwab.datastructs.schwab;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hm.schwab.datastructs.schwab.Enums.ActivityType;
import com.hm.schwab.datastructs.schwab.Enums.ExecutionType;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderActivity {
    @JsonProperty("activityType")
    public ActivityType activityType;

    @JsonProperty("executionType")
    public ExecutionType executionType;

    @JsonProperty("quantity")
    public Double quantity;

    @JsonProperty("orderRemainingQuantity")
    public Double orderRemainingQuantity;

    @JsonProperty("executionLegs")
    public List<ExecutionLeg> executionLegs;

    @Override
    public String toString() {
        return "OrderActivity{" +
                "activityType=" + activityType +
                ", executionType=" + executionType +
                ", quantity=" + quantity +
                ", orderRemainingQuantity=" + orderRemainingQuantity +
                ", executionLegs=" + executionLegs +
                '}';
    }
}