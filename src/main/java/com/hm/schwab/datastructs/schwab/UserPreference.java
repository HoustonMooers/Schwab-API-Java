package com.hm.schwab.datastructs.schwab;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserPreference {
    @JsonProperty("accounts")
    public List<UserPreferenceAccount> accounts;

    @JsonProperty("streamerInfo")
    public List<StreamerInfo> streamerInfo;

    @JsonProperty("offers")
    public List<Offer> offers;
}
