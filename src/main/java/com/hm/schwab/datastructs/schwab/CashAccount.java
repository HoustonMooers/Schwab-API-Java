package com.hm.schwab.datastructs.schwab;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CashAccount extends SecuritiesAccount {
    @JsonProperty("accountNumber")
    public String accountNumber;
    @JsonProperty("roundTrips")
    public int roundTrips;
    @JsonProperty("isDayTrader")
    public boolean isDayTrader;
    @JsonProperty("isClosingOnlyRestricted")
    public boolean isClosingOnlyRestricted;
    @JsonProperty("pfcbFlag")
    public boolean pfcbFlag;
    @JsonProperty("positions")
    public List<Position> positions;
    @JsonProperty("initialBalances")
    public CashInitialBalance initialBalances;
    @JsonProperty("currentBalances")
    public CashBalance currentBalances;
    @JsonProperty("projectedBalances")
    public CashBalance projectedBalances;

    @Override
    public String toString() {
        return "CashAccount{" +
                "type='" + type + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", roundTrips=" + roundTrips +
                ", isDayTrader=" + isDayTrader +
                ", isClosingOnlyRestricted=" + isClosingOnlyRestricted +
                ", pfcbFlag=" + pfcbFlag +
                ", positions=" + positions +
                ", initialBalances=" + initialBalances +
                ", currentBalances=" + currentBalances +
                ", projectedBalances=" + projectedBalances +
                '}';
    }
}