package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserPreferenceAccount {
    @JsonProperty("accountNumber")
    public String accountNumber;

    @JsonProperty("primaryAccount")
    public boolean primaryAccount;

    @JsonProperty("type")
    public String type;

    @JsonProperty("nickName")
    public String nickName;
    
    @JsonProperty("displayAcctId")
    public String displayAcctId;
    
    @JsonProperty("autoPositionEffect")
    public boolean autoPositionEffect;
    
    @JsonProperty("accountColor")
    public String accountColor;
    
    @JsonProperty("lotSelectionMethod")
    public String lotSelectionMethod;
    
    @JsonProperty("hasFuturesAccount")
    public boolean hasFuturesAccount;
    
    @JsonProperty("hasForexAccount")
    public boolean hasForexAccount;
}