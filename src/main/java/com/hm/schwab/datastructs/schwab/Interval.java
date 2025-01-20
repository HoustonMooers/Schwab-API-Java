package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Interval {
    @JsonProperty("start")
    public String start;

    @JsonProperty("end")
    public String end;

    @Override
    public String toString() {
        return "Interval{" +
                "start='" + start + '\'' +
                ", end='" + end + '\'' +
                '}';
    }
}