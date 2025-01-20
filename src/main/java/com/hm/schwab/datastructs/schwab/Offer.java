package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Offer {
    @JsonProperty("level2Permissions")
    public boolean level2Permissions;

    @JsonProperty("mktDataPermission")
    public String mktDataPermission;
}