package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.hm.schwab.datastructs.schwab.Enums.AssetMainType;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "assetMainType",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = EquityResponse.class, name = "EQUITY"),
        @JsonSubTypes.Type(value = OptionResponse.class, name = "OPTION"),
        @JsonSubTypes.Type(value = ForexResponse.class, name = "FOREX"),
        @JsonSubTypes.Type(value = FutureResponse.class, name = "FUTURE"),
        @JsonSubTypes.Type(value = FutureOptionResponse.class, name = "FUTURE_OPTION"),
        @JsonSubTypes.Type(value = IndexResponse.class, name = "INDEX"),
        @JsonSubTypes.Type(value = MutualFundResponse.class, name = "MUTUAL_FUND"),
        @JsonSubTypes.Type(value = QuoteError.class, name = "QuoteError")
})
public abstract class QuoteResponseObject {
    @JsonProperty("assetMainType")
    public AssetMainType assetMainType;
}