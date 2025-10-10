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

	@Override
	public double getBid() {
		return -1;
	}

	@Override
	public double getAsk() {
		return -1;
	}
	
	@Override
	public double getLast() {
		return -1;
	}

	@Override
	public double getLow() {
		return -1;
	}

	@Override
	public double getHigh() {
		return -1;
	}

	@Override
	public double getOpen() {
		return -1;
	}

	@Override
	public double getClose() {
		return -1;
	}
	
	@Override
	public double getChange() {
		return 0;
	}
	
	@Override
	public long getVolume() {
		return 0;
	}
}
