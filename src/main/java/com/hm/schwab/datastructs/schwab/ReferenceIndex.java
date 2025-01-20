package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReferenceIndex {
    @JsonProperty("description")
    public String description;

    @JsonProperty("exchange")
    public String exchange;

    @JsonProperty("exchangeName")
    public String exchangeName;

    @Override
    public String toString() {
        return "ReferenceIndex{" +
                "description='" + description + '\'' +
                ", exchange='" + exchange + '\'' +
                ", exchangeName='" + exchangeName + '\'' +
                '}';
    }
}