package com.hm.schwab.datastructs.schwab;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomQuoteResponseDeserializer extends JsonDeserializer<QuoteResponse> {

    @Override
    public QuoteResponse deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        ObjectMapper mapper = (ObjectMapper) jp.getCodec();
        JsonNode root = mapper.readTree(jp);

        QuoteResponse quoteResponse = new QuoteResponse();
        Map<String, QuoteResponseObject> quotes = new HashMap<>();

        Iterator<Map.Entry<String, JsonNode>> fields = root.fields();
        while (fields.hasNext()) {
            Map.Entry<String, JsonNode> field = fields.next();
            String key = field.getKey();
            JsonNode value = field.getValue();

            // Determine the type of the object
            JsonNode assetMainTypeNode = value.get("assetMainType");
            if (assetMainTypeNode != null) {
                String assetMainType = assetMainTypeNode.asText();
                Class<? extends QuoteResponseObject> clazz = getClassForAssetMainType(assetMainType);
                if (clazz != null) {
                    QuoteResponseObject quoteResponseObject = mapper.treeToValue(value, clazz);
                    quotes.put(key, quoteResponseObject);
                }
            }
        }

        quoteResponse.quotes = quotes;
        return quoteResponse;
    }

    private Class<? extends QuoteResponseObject> getClassForAssetMainType(String assetMainType) {
        switch (assetMainType) {
            case "EQUITY":
                return EquityResponse.class;
            case "OPTION":
                return OptionResponse.class;
            case "FOREX":
                return ForexResponse.class;
            case "FUTURE":
                return FutureResponse.class;
            case "FUTURE_OPTION":
                return FutureOptionResponse.class;
            case "INDEX":
                return IndexResponse.class;
            case "MUTUAL_FUND":
                return MutualFundResponse.class;
            default:
                return null;
        }
    }
}