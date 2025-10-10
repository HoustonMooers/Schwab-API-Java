package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hm.schwab.datastructs.schwab.Enums.*;

import java.util.List;
// Other necessary imports for classes like OrderActivity, OrderLegCollection are implicit
// as they are in the same package or subpackages (enums).

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderRequest {

    @JsonProperty("session")
    public Session session;

    @JsonProperty("duration")
    public Duration duration;

    // Assuming JSON property name is "orderType" based on common practice,
    // not "orderTypeorderTypeRequeststring" from the schema description.
    @JsonProperty("orderType")
    public OrderType orderType;

    @JsonProperty("cancelTime")
    public String cancelTime; // $date-time

    @JsonProperty("complexOrderStrategyType")
    public ComplexOrderStrategyType complexOrderStrategyType;

    @JsonProperty("quantity")
    public Double quantity;

    @JsonProperty("filledQuantity")
    public Double filledQuantity;

    @JsonProperty("remainingQuantity")
    public Double remainingQuantity;

    @JsonProperty("destinationLinkName")
    public String destinationLinkName;

    @JsonProperty("releaseTime")
    public String releaseTime; // $date-time

    @JsonProperty("stopPrice")
    public Double stopPrice;

    @JsonProperty("stopPriceLinkBasis")
    public StopPriceLinkBasis stopPriceLinkBasis;

    @JsonProperty("stopPriceLinkType")
    public StopPriceLinkType stopPriceLinkType;

    @JsonProperty("stopPriceOffset")
    public Double stopPriceOffset;

    @JsonProperty("stopType")
    public StopType stopType;

    @JsonProperty("priceLinkBasis")
    public PriceLinkBasis priceLinkBasis;

    @JsonProperty("priceLinkType")
    public PriceLinkType priceLinkType;

    @JsonProperty("price")
    public Double price;

    @JsonProperty("taxLotMethod")
    public TaxLotMethod taxLotMethod;

    @JsonProperty("orderLegCollection")
    public List<OrderLegCollection> orderLegCollection; // List of OrderLegCollection items

    @JsonProperty("activationPrice")
    public Double activationPrice;

    @JsonProperty("specialInstruction")
    public SpecialInstruction specialInstruction;

    @JsonProperty("orderStrategyType")
    public OrderStrategyType orderStrategyType;

    @JsonProperty("orderId")
    public Long orderId; // $int64

    @JsonProperty("cancelable")
    public boolean cancelable = false; // Default from schema

    @JsonProperty("editable")
    public boolean editable = false; // Default from schema

    @JsonProperty("status")
    public Status status;

    @JsonProperty("enteredTime")
    public String enteredTime; // $date-time

    @JsonProperty("closeTime")
    public String closeTime; // $date-time

    @JsonProperty("accountNumber")
    public Long accountNumber; // $int64

    @JsonProperty("orderActivityCollection")
    public List<OrderActivity> orderActivityCollection;

    @JsonProperty("replacingOrderCollection")
    public List<Object> replacingOrderCollection; // Schema {} implies generic list

    @JsonProperty("childOrderStrategies")
    public List<Object> childOrderStrategies; // Schema {} implies generic list

    @JsonProperty("statusDescription")
    public String statusDescription;
    
    public String getURIByOrder(String baseurl, String accountnumber) {
        StringBuilder sb = new StringBuilder(baseurl);
        sb.append(accountnumber);
        sb.append("/orders/");
        sb.append(orderId);
        return sb.toString();
    }

    @Override
    public String toString() {
        // This is a basic toString(). A more comprehensive one might be needed for debugging.
        return "OrderRequest{" +
                "session=" + session +
                ", duration=" + duration +
                ", orderType=" + orderType +
                ", quantity=" + quantity +
                ", orderId=" + orderId +
                ", accountNumber=" + accountNumber +
                // Add other fields as needed for a quick overview
                ", orderLegCollection=" + orderLegCollection +
                ", status=" + status +
                '}';
    }
}