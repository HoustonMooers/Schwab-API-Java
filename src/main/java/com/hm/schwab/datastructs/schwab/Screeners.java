package com.hm.schwab.datastructs.schwab;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Screeners {
    @JsonProperty("screeners")
    public List<Screener> screeners;

    @Override
    public String toString() {
        return "Screeners{" +
                "screeners=" + screeners +
                '}';
    }
}