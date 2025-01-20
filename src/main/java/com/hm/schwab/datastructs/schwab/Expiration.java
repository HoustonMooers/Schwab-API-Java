package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hm.schwab.datastructs.schwab.Enums.ExpirationType;
import com.hm.schwab.datastructs.schwab.Enums.SettlementType;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Expiration {
    @JsonProperty("description")
    public String description;

    @JsonProperty("daysToExpiration")
    public int daysToExpiration;

    @JsonProperty("expirationDate")
    public String expirationDate;

    @JsonProperty("expirationType")
    public ExpirationType expirationType;

    @JsonProperty("standard")
    public boolean standard;

    @JsonProperty("settlementType")
    public SettlementType settlementType;

    @JsonProperty("optionRoots")
    public String optionRoots;

    @Override
    public String toString() {
        return "Expiration{" +
                "description='" + description + '\'' +
                ", daysToExpiration=" + daysToExpiration +
                ", expiration=" + expirationDate +
                ", expirationType=" + expirationType +
                ", standard=" + standard +
                ", settlementType=" + settlementType +
                ", optionRoots='" + optionRoots + '\'' +
                '}';
    }
}