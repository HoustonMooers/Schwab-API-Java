package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hm.schwab.datastructs.schwab.Enums.DivFreq;
import com.hm.schwab.datastructs.schwab.Enums.FundStrategy;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Fundamental {
    @JsonProperty("avg10DaysVolume")
    public double avg10DaysVolume;

    @JsonProperty("avg1YearVolume")
    public double avg1YearVolume;

    @JsonProperty("declarationDate")
    public String declarationDate;

    @JsonProperty("divAmount")
    public double divAmount;

    @JsonProperty("divExDate")
    public String divExDate;

    @JsonProperty("divFreq")
    public DivFreq divFreq;

    @JsonProperty("divPayAmount")
    public double divPayAmount;

    @JsonProperty("divPayDate")
    public String divPayDate;

    @JsonProperty("divYield")
    public double divYield;

    @JsonProperty("eps")
    public double eps;

    @JsonProperty("fundLeverageFactor")
    public double fundLeverageFactor;

    @JsonProperty("fundStrategy")
    public FundStrategy fundStrategy;

    @JsonProperty("nextDivExDate")
    public String nextDivExDate;

    @JsonProperty("nextDivPayDate")
    public String nextDivPayDate;

    @JsonProperty("peRatio")
    public double peRatio;

    @Override
    public String toString() {
        return "Fundamental{" +
                "avg10DaysVolume=" + avg10DaysVolume +
                ", avg1YearVolume=" + avg1YearVolume +
                ", declarationDate='" + declarationDate + '\'' +
                ", divAmount=" + divAmount +
                ", divExDate='" + divExDate + '\'' +
                ", divFreq=" + divFreq +
                ", divPayAmount=" + divPayAmount +
                ", divPayDate='" + divPayDate + '\'' +
                ", divYield=" + divYield +
                ", eps=" + eps +
                ", fundLeverageFactor=" + fundLeverageFactor +
                ", fundStrategy=" + fundStrategy +
                ", nextDivExDate='" + nextDivExDate + '\'' +
                ", nextDivPayDate='" + nextDivPayDate + '\'' +
                ", peRatio=" + peRatio +
                '}';
    }
}
