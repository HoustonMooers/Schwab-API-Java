package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hm.schwab.datastructs.schwab.Enums.ContractType;
import com.hm.schwab.datastructs.schwab.Enums.ExerciseType;
import com.hm.schwab.datastructs.schwab.Enums.ExpirationType;
import com.hm.schwab.datastructs.schwab.Enums.SettlementType;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReferenceOption {
    @JsonProperty("contractType")
    public ContractType contractType;

    @JsonProperty("cusip")
    public String cusip;

    @JsonProperty("daysToExpiration")
    public int daysToExpiration;

    @JsonProperty("deliverables")
    public String deliverables;

    @JsonProperty("description")
    public String description;

    @JsonProperty("exchange")
    public String exchange;

    @JsonProperty("exchangeName")
    public String exchangeName;

    @JsonProperty("exerciseType")
    public ExerciseType exerciseType;

    @JsonProperty("expirationDay")
    public int expirationDay;

    @JsonProperty("expirationMonth")
    public int expirationMonth;

    @JsonProperty("expirationType")
    public ExpirationType expirationType;

    @JsonProperty("expirationYear")
    public int expirationYear;

    @JsonProperty("isPennyPilot")
    public boolean isPennyPilot;

    @JsonProperty("lastTradingDay")
    public long lastTradingDay;

    @JsonProperty("multiplier")
    public double multiplier;

    @JsonProperty("settlementType")
    public SettlementType settlementType;

    @JsonProperty("strikePrice")
    public double strikePrice;

    @JsonProperty("underlying")
    public String underlying;

    @Override
    public String toString() {
        return "ReferenceOption{" +
                "contractType=" + contractType +
                ", cusip='" + cusip + '\'' +
                ", daysToExpiration=" + daysToExpiration +
                ", deliverables='" + deliverables + '\'' +
                ", description='" + description + '\'' +
                ", exchange='" + exchange + '\'' +
                ", exchangeName='" + exchangeName + '\'' +
                ", exerciseType=" + exerciseType +
                ", expirationDay=" + expirationDay +
                ", expirationMonth=" + expirationMonth +
                ", expirationType=" + expirationType +
                ", expirationYear=" + expirationYear +
                ", isPennyPilot=" + isPennyPilot +
                ", lastTradingDay=" + lastTradingDay +
                ", multiplier=" + multiplier +
                ", settlementType=" + settlementType +
                ", strikePrice=" + strikePrice +
                ", underlying='" + underlying + '\'' +
                '}';
    }
}