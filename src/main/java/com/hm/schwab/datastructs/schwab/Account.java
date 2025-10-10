package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Account {
    @JsonProperty("securitiesAccount")
    public SecuritiesAccount securitiesAccount;
    @JsonProperty("aggregatedBalance")
    public AggregatedBalance aggregatedBalance;
    
    public double getNetLiq() {
    	return aggregatedBalance.currentLiquidationValue;
    }
    
    public double getBuyingPower() {
    	return securitiesAccount.getBuyingPower();
    }
    
    public double getCash() {
    	return securitiesAccount.getCash();
    }
    
    public String getAccountNumber() {
    	return securitiesAccount.getAccountNumber();
    }

    @Override
    public String toString() {
        return "Account{" +
                "securitiesAccount=" + securitiesAccount +
                ", aggregatedBalance=" + aggregatedBalance +
                '}';
    }
}