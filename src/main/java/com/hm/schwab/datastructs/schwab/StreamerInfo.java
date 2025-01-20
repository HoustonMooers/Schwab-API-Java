package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StreamerInfo {
    @JsonProperty("streamerSocketUrl")
    public String streamerSocketUrl;

    @JsonProperty("schwabClientCustomerId")
    public String schwabClientCustomerId;

    @JsonProperty("schwabClientCorrelId")
    public String schwabClientCorrelId;

    @JsonProperty("schwabClientChannel")
    public String schwabClientChannel;

    @JsonProperty("schwabClientFunctionId")
    public String schwabClientFunctionId;
}