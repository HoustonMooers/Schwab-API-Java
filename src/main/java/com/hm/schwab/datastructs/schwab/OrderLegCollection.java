package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hm.schwab.datastructs.schwab.Enums.DivCapGains;
import com.hm.schwab.datastructs.schwab.Enums.Instruction;
import com.hm.schwab.datastructs.schwab.Enums.OrderLegType;
import com.hm.schwab.datastructs.schwab.Enums.PositionEffect;
import com.hm.schwab.datastructs.schwab.Enums.QuantityType;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderLegCollection {
	public OrderLegCollection(Instruction instruction, int quantity, AccountsInstrument instrument) {
		this.instruction = instruction;
		this.quantity = quantity;
		this.instrument = instrument;
		this.positionEffect = PositionEffect.AUTOMATIC;
	}

	public OrderLegCollection() { }

    @JsonProperty("orderLegType")
    public OrderLegType orderLegType;

    @JsonProperty("legId")
    public Integer legId;

    @JsonProperty("instrument")
    public AccountsInstrument instrument;

    @JsonProperty("instruction")
    public Instruction instruction;

    @JsonProperty("positionEffect")
    public PositionEffect positionEffect;

    @JsonProperty("quantity")
    public double quantity;

    @JsonProperty("quantityType")
    public QuantityType quantityType;

    @JsonProperty("divCapGains")
    public DivCapGains divCapGains;

    @JsonProperty("toSymbol")
    public String toSymbol;

    @Override
    public String toString() {
        return "OrderLegCollection{" +
                "orderLegType=" + orderLegType +
                ", legId=" + legId +
                ", instrument=" + instrument +
                ", instruction=" + instruction +
                ", positionEffect=" + positionEffect +
                ", quantity=" + quantity +
                ", quantityType=" + quantityType +
                ", divCapGains=" + divCapGains +
                ", toSymbol='" + toSymbol + '\'' +
                '}';
    }
}