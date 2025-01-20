package com.hm.schwab.datastructs.schwab;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuoteError extends QuoteResponseObject  {
    @JsonProperty("invalidCusips")
    public List<String> invalidCusips;

    @JsonProperty("invalidSSIDs")
    public List<Long> invalidSSIDs;

    @JsonProperty("invalidSymbols")
    public List<String> invalidSymbols;

    @Override
    public String toString() {
        return "QuoteError{" +
                "invalidCusips=" + invalidCusips +
                ", invalidSSIDs=" + invalidSSIDs +
                ", invalidSymbols=" + invalidSymbols +
                '}';
    }
}
