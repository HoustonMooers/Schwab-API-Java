package com.hm.schwab.datastructs.schwab;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hm.schwab.datastructs.schwab.Enums.ActivityType;
import com.hm.schwab.datastructs.schwab.Enums.Status;
import com.hm.schwab.datastructs.schwab.Enums.SubAccount;
import com.hm.schwab.datastructs.schwab.Enums.TransactionType;

public class Transaction {
    @JsonProperty("activityId")
    public long activityId;

    @JsonProperty("time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    public LocalDateTime time;

    @JsonProperty("user")
    public UserDetails user;

    @JsonProperty("description")
    public String description;

    @JsonProperty("accountNumber")
    public String accountNumber;

    @JsonProperty("type")
    public TransactionType type;

    @JsonProperty("status")
    public Status status;

    @JsonProperty("subAccount")
    public SubAccount subAccount;

    @JsonProperty("tradeDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    public LocalDateTime tradeDate;

    @JsonProperty("settlementDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    public LocalDateTime settlementDate;

    @JsonProperty("positionId")
    public long positionId;

    @JsonProperty("orderId")
    public long orderId;

    @JsonProperty("netAmount")
    public double netAmount;

    @JsonProperty("activityType")
    public ActivityType activityType;

    @JsonProperty("transferItems")
    public List<TransferItem> transferItems;
}