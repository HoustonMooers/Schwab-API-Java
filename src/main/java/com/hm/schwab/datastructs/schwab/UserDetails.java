package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDetails {
    @JsonProperty("cdDomainId")
    public String cdDomainId;

    @JsonProperty("login")
    public String login;

    @JsonProperty("type")
    public String type;

    @JsonProperty("userId")
    public long userId;

    @JsonProperty("systemUserName")
    public String systemUserName;

    @JsonProperty("firstName")
    public String firstName;

    @JsonProperty("lastName")
    public String lastName;

    @JsonProperty("brokerRepCode")
    public String brokerRepCode;
}