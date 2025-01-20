package com.hm.schwab.datastructs.schwab;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class InstrumentResponse {
    @JsonProperty("instruments")
    public List<Instrument> instruments;

    @Override
    public String toString() {
        return "InstrumentResponse{" +
                "instruments=" + instruments +
                '}';
    }
}