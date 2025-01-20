package com.hm.schwab.datastructs.schwab;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionInstrument {
    @JsonProperty("assetType")
    public String assetType;

    @JsonProperty("cusip")
    public String cusip;

    @JsonProperty("symbol")
    public String symbol;

    @JsonProperty("description")
    public String description;

    @JsonProperty("instrumentId")
    public long instrumentId;

    @JsonProperty("netChange")
    public double netChange;

    @JsonProperty("type")
    public String type;

    // Additional fields for specific instrument types
    @JsonProperty("maturityDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public LocalDate maturityDate;

    @JsonProperty("factor")
    public double factor;

    @JsonProperty("multiplier")
    public double multiplier;

    @JsonProperty("variableRate")
    public double variableRate;

    @JsonProperty("baseCurrency")
    public Currency baseCurrency;

    @JsonProperty("counterCurrency")
    public Currency counterCurrency;

    @JsonProperty("activeContract")
    public boolean activeContract;

    @JsonProperty("expirationDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public LocalDate expirationDate;

    @JsonProperty("lastTradingDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public LocalDate lastTradingDate;

    @JsonProperty("firstNoticeDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public LocalDate firstNoticeDate;

    @JsonProperty("fundFamilyName")
    public String fundFamilyName;

    @JsonProperty("fundFamilySymbol")
    public String fundFamilySymbol;

    @JsonProperty("fundGroup")
    public String fundGroup;

    @JsonProperty("exchangeCutoffTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    public LocalDateTime exchangeCutoffTime;

    @JsonProperty("purchaseCutoffTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    public LocalDateTime purchaseCutoffTime;

    @JsonProperty("redemptionCutoffTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    public LocalDateTime redemptionCutoffTime;

    @JsonProperty("optionDeliverables")
    public List<TransactionAPIOptionDeliverable> optionDeliverables;

    @JsonProperty("optionPremiumMultiplier")
    public int optionPremiumMultiplier;

    @JsonProperty("putCall")
    public String putCall;

    @JsonProperty("strikePrice")
    public double strikePrice;

    @JsonProperty("underlyingSymbol")
    public String underlyingSymbol;

    @JsonProperty("underlyingCusip")
    public String underlyingCusip;

    @JsonProperty("deliverable")
    public Object deliverable;
}