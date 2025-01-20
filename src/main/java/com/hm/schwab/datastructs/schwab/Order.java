package com.hm.schwab.datastructs.schwab;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hm.schwab.datastructs.schwab.Enums.ComplexOrderStrategyType;
import com.hm.schwab.datastructs.schwab.Enums.Duration;
import com.hm.schwab.datastructs.schwab.Enums.OrderStrategyType;
import com.hm.schwab.datastructs.schwab.Enums.OrderType;
import com.hm.schwab.datastructs.schwab.Enums.PriceLinkBasis;
import com.hm.schwab.datastructs.schwab.Enums.PriceLinkType;
import com.hm.schwab.datastructs.schwab.Enums.RequestedDestination;
import com.hm.schwab.datastructs.schwab.Enums.Session;
import com.hm.schwab.datastructs.schwab.Enums.Status;
import com.hm.schwab.datastructs.schwab.Enums.StopPriceLinkBasis;
import com.hm.schwab.datastructs.schwab.Enums.StopPriceLinkType;
import com.hm.schwab.datastructs.schwab.Enums.StopType;
import com.hm.schwab.datastructs.schwab.Enums.TaxLotMethod;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {
    public Order(OrderType ordertype, Session session, Duration duration, OrderStrategyType strategytype) {
        this.orderType = ordertype;
        this.session = session;
        this.duration = duration;
        this.orderStrategyType = strategytype;
    }

    public Order() { }

    @JsonProperty("session")
    public Session session;

    @JsonProperty("duration")
    public Duration duration;

    @JsonProperty("orderType")
    public OrderType orderType;

    @JsonProperty("cancelTime")
    public String cancelTime;

    @JsonProperty("complexOrderStrategyType")
    public ComplexOrderStrategyType complexOrderStrategyType;

    @JsonProperty("quantity")
    public Double quantity;

    @JsonProperty("filledQuantity")
    public Double filledQuantity;

    @JsonProperty("remainingQuantity")
    public Double remainingQuantity;

    @JsonProperty("requestedDestination")
    public RequestedDestination requestedDestination;

    @JsonProperty("destinationLinkName")
    public String destinationLinkName;

    @JsonProperty("releaseTime")
    public String releaseTime;

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
    public List<OrderLegCollection> orderLegCollection;

    @JsonProperty("orderStrategyType")
    public OrderStrategyType orderStrategyType;

    @JsonProperty("orderId")
    public Long orderId;

    @JsonProperty("cancelable")
    public Boolean cancelable;

    @JsonProperty("editable")
    public Boolean editable;

    @JsonProperty("status")
    public Status status;

    @JsonProperty("enteredTime")
    public String enteredTime;

    @JsonProperty("closeTime")
    public String closeTime;

    @JsonProperty("tag")
    public String tag;

    @JsonProperty("accountNumber")
    public Long accountNumber;

    @JsonProperty("orderActivityCollection")
    public List<OrderActivity> orderActivityCollection;

    @JsonProperty("replacingOrderCollection")
    public List<Order> replacingOrderCollection;

    @JsonProperty("childOrderStrategies")
    public List<Order> childOrderStrategies;

    @JsonProperty("statusDescription")
    public String statusDescription;

    public void addOrderLeg(OrderLegCollection leg) {
        if (this.orderLegCollection == null) {
            this.orderLegCollection = new ArrayList<>();
        }
        this.orderLegCollection.add(leg);
    }

	public void addChildOrderStrategy(Order dependentorder) {
		if(childOrderStrategies == null) {
			this.childOrderStrategies = new ArrayList<>();
		}
		childOrderStrategies.add(dependentorder);
	}

    public String getURI(String baseurl, String accountnumber) {
        StringBuilder sb = new StringBuilder(baseurl);
        sb.append(accountnumber);
        sb.append("/orders");
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Order{" +
                "session=" + session +
                ", duration=" + duration +
                ", orderType=" + orderType +
                ", cancelTime='" + cancelTime + '\'' +
                ", complexOrderStrategyType=" + complexOrderStrategyType +
                ", quantity=" + quantity +
                ", filledQuantity=" + filledQuantity +
                ", remainingQuantity=" + remainingQuantity +
                ", requestedDestination=" + requestedDestination +
                ", destinationLinkName='" + destinationLinkName + '\'' +
                ", releaseTime='" + releaseTime + '\'' +
                ", stopPrice=" + stopPrice +
                ", stopPriceLinkBasis=" + stopPriceLinkBasis +
                ", stopPriceLinkType=" + stopPriceLinkType +
                ", stopPriceOffset=" + stopPriceOffset +
                ", stopType=" + stopType +
                ", priceLinkBasis=" + priceLinkBasis +
                ", priceLinkType=" + priceLinkType +
                ", price=" + price +
                ", taxLotMethod=" + taxLotMethod +
                ", orderLegCollection=" + orderLegCollection +
                ", orderStrategyType=" + orderStrategyType +
                ", orderId=" + orderId +
                ", cancelable=" + cancelable +
                ", editable=" + editable +
                ", status=" + status +
                ", enteredTime='" + enteredTime + '\'' +
                ", closeTime='" + closeTime + '\'' +
                ", tag='" + tag + '\'' +
                ", accountNumber=" + accountNumber +
                ", orderActivityCollection=" + orderActivityCollection +
                ", replacingOrderCollection=" + replacingOrderCollection +
                ", childOrderStrategies=" + childOrderStrategies +
                ", statusDescription='" + statusDescription + '\'' +
                '}';
    }
}