package com.hm.schwab.datastructs.schwab;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = CustomQuoteResponseDeserializer.class)
public class QuoteResponse {
    @JsonProperty
    public Map<String, QuoteResponseObject> quotes;

    @Override
    public String toString() {
        return "QuoteResponse{" +
                "quotes=" + quotes +
                '}';
    }
}