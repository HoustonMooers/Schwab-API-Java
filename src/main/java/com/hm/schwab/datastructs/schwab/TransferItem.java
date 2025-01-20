package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hm.schwab.datastructs.schwab.Enums.FeeType;
import com.hm.schwab.datastructs.schwab.Enums.PositionEffect;

public class TransferItem {
    @JsonProperty("instrument")
    public TransactionInstrument instrument;

    @JsonProperty("amount")
    public double amount;

    @JsonProperty("cost")
    public double cost;

    @JsonProperty("price")
    public double price;

    @JsonProperty("feeType")
    public FeeType feeType;

    @JsonProperty("positionEffect")
    public PositionEffect positionEffect;
}