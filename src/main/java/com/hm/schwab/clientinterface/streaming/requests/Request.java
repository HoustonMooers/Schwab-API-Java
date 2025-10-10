package com.hm.schwab.clientinterface.streaming.requests;

import java.util.Map;

public class Request {
    private final Map<String, String> primaryParams;  // Required fields like service, requestid, etc.
    private final Map<String, String> optionalParams; // Optional "parameters" map, can be null

    public Request(Map<String, String> primaryParams, Map<String, String> optionalParams) {
        this.primaryParams = primaryParams;
        this.optionalParams = optionalParams;
    }

    public Map<String, String> getPrimaryParams() {
        return primaryParams;
    }

    public Map<String, String> getOptionalParams() {
        return optionalParams;
    }
}