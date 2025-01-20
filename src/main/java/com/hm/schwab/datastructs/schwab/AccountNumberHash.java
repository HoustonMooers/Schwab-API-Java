package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountNumberHash {
    @JsonProperty("accountNumber")
    private String accountNumber;

    @JsonProperty("hashValue")
    private String hashValue;

    // Default constructor
    public AccountNumberHash() {
    }

    // Parameterized constructor
    public AccountNumberHash(String accountNumber, String hashValue) {
        this.accountNumber = accountNumber;
        this.hashValue = hashValue;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getHashValue() {
        return hashValue;
    }

    public void setHashValue(String hashValue) {
        this.hashValue = hashValue;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", hashValue='" + hashValue + '\'' +
                '}';
    }
}