package com.hm.schwab.datastructs.schwab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FundamentalInst {
    @JsonProperty("symbol")
    public String symbol;

    @JsonProperty("high52")
    public double high52;

    @JsonProperty("low52")
    public double low52;

    @JsonProperty("dividendAmount")
    public double dividendAmount;

    @JsonProperty("dividendYield")
    public double dividendYield;

    @JsonProperty("dividendDate")
    public String dividendDate;

    @JsonProperty("peRatio")
    public double peRatio;

    @JsonProperty("pegRatio")
    public double pegRatio;

    @JsonProperty("pbRatio")
    public double pbRatio;

    @JsonProperty("prRatio")
    public double prRatio;

    @JsonProperty("pcfRatio")
    public double pcfRatio;

    @JsonProperty("grossMarginTTM")
    public double grossMarginTTM;

    @JsonProperty("grossMarginMRQ")
    public double grossMarginMRQ;

    @JsonProperty("netProfitMarginTTM")
    public double netProfitMarginTTM;

    @JsonProperty("netProfitMarginMRQ")
    public double netProfitMarginMRQ;

    @JsonProperty("operatingMarginTTM")
    public double operatingMarginTTM;

    @JsonProperty("operatingMarginMRQ")
    public double operatingMarginMRQ;

    @JsonProperty("returnOnEquity")
    public double returnOnEquity;

    @JsonProperty("returnOnAssets")
    public double returnOnAssets;

    @JsonProperty("returnOnInvestment")
    public double returnOnInvestment;

    @JsonProperty("quickRatio")
    public double quickRatio;

    @JsonProperty("currentRatio")
    public double currentRatio;

    @JsonProperty("interestCoverage")
    public double interestCoverage;

    @JsonProperty("totalDebtToCapital")
    public double totalDebtToCapital;

    @JsonProperty("ltDebtToEquity")
    public double ltDebtToEquity;

    @JsonProperty("totalDebtToEquity")
    public double totalDebtToEquity;

    @JsonProperty("epsTTM")
    public double epsTTM;

    @JsonProperty("epsChangePercentTTM")
    public double epsChangePercentTTM;

    @JsonProperty("epsChangeYear")
    public double epsChangeYear;

    @JsonProperty("epsChange")
    public double epsChange;

    @JsonProperty("revChangeYear")
    public double revChangeYear;

    @JsonProperty("revChangeTTM")
    public double revChangeTTM;

    @JsonProperty("revChangeIn")
    public double revChangeIn;

    @JsonProperty("sharesOutstanding")
    public double sharesOutstanding;

    @JsonProperty("marketCapFloat")
    public double marketCapFloat;

    @JsonProperty("marketCap")
    public double marketCap;

    @JsonProperty("bookValuePerShare")
    public double bookValuePerShare;

    @JsonProperty("shortIntToFloat")
    public double shortIntToFloat;

    @JsonProperty("shortIntDayToCover")
    public double shortIntDayToCover;

    @JsonProperty("divGrowthRate3Year")
    public double divGrowthRate3Year;

    @JsonProperty("dividendPayAmount")
    public double dividendPayAmount;

    @JsonProperty("dividendPayDate")
    public String dividendPayDate;

    @JsonProperty("beta")
    public double beta;

    @JsonProperty("vol1DayAvg")
    public double vol1DayAvg;

    @JsonProperty("vol10DayAvg")
    public double vol10DayAvg;

    @JsonProperty("vol3MonthAvg")
    public double vol3MonthAvg;

    @JsonProperty("avg10DaysVolume")
    public long avg10DaysVolume;

    @JsonProperty("avg1DayVolume")
    public long avg1DayVolume;

    @JsonProperty("avg3MonthVolume")
    public long avg3MonthVolume;

    @JsonProperty("declarationDate")
    public String declarationDate;

    @JsonProperty("dividendFreq")
    public int dividendFreq;

    @JsonProperty("eps")
    public double eps;

    @JsonProperty("corpactionDate")
    public String corpactionDate;

    @JsonProperty("dtnVolume")
    public long dtnVolume;

    @JsonProperty("nextDividendPayDate")
    public String nextDividendPayDate;

    @JsonProperty("nextDividendDate")
    public String nextDividendDate;

    @JsonProperty("fundLeverageFactor")
    public double fundLeverageFactor;

    @JsonProperty("fundStrategy")
    public String fundStrategy;

    @Override
    public String toString() {
        return "FundamentalInst{" +
                "symbol='" + symbol + '\'' +
                ", high52=" + high52 +
                ", low52=" + low52 +
                ", dividendAmount=" + dividendAmount +
                ", dividendYield=" + dividendYield +
                ", dividendDate='" + dividendDate + '\'' +
                ", peRatio=" + peRatio +
                ", pegRatio=" + pegRatio +
                ", pbRatio=" + pbRatio +
                ", prRatio=" + prRatio +
                ", pcfRatio=" + pcfRatio +
                ", grossMarginTTM=" + grossMarginTTM +
                ", grossMarginMRQ=" + grossMarginMRQ +
                ", netProfitMarginTTM=" + netProfitMarginTTM +
                ", netProfitMarginMRQ=" + netProfitMarginMRQ +
                ", operatingMarginTTM=" + operatingMarginTTM +
                ", operatingMarginMRQ=" + operatingMarginMRQ +
                ", returnOnEquity=" + returnOnEquity +
                ", returnOnAssets=" + returnOnAssets +
                ", returnOnInvestment=" + returnOnInvestment +
                ", quickRatio=" + quickRatio +
                ", currentRatio=" + currentRatio +
                ", interestCoverage=" + interestCoverage +
                ", totalDebtToCapital=" + totalDebtToCapital +
                ", ltDebtToEquity=" + ltDebtToEquity +
                ", totalDebtToEquity=" + totalDebtToEquity +
                ", epsTTM=" + epsTTM +
                ", epsChangePercentTTM=" + epsChangePercentTTM +
                ", epsChangeYear=" + epsChangeYear +
                ", epsChange=" + epsChange +
                ", revChangeYear=" + revChangeYear +
                ", revChangeTTM=" + revChangeTTM +
                ", revChangeIn=" + revChangeIn +
                ", sharesOutstanding=" + sharesOutstanding +
                ", marketCapFloat=" + marketCapFloat +
                ", marketCap=" + marketCap +
                ", bookValuePerShare=" + bookValuePerShare +
                ", shortIntToFloat=" + shortIntToFloat +
                ", shortIntDayToCover=" + shortIntDayToCover +
                ", divGrowthRate3Year=" + divGrowthRate3Year +
                ", dividendPayAmount=" + dividendPayAmount +
                ", dividendPayDate='" + dividendPayDate + '\'' +
                ", beta=" + beta +
                ", vol1DayAvg=" + vol1DayAvg +
                ", vol10DayAvg=" + vol10DayAvg +
                ", vol3MonthAvg=" + vol3MonthAvg +
                ", avg10DaysVolume=" + avg10DaysVolume +
                ", avg1DayVolume=" + avg1DayVolume +
                ", avg3MonthVolume=" + avg3MonthVolume +
                ", declarationDate='" + declarationDate + '\'' +
                ", dividendFreq=" + dividendFreq +
                ", eps=" + eps +
                ", corpactionDate='" + corpactionDate + '\'' +
                ", dtnVolume=" + dtnVolume +
                ", nextDividendPayDate='" + nextDividendPayDate + '\'' +
                ", nextDividendDate='" + nextDividendDate + '\'' +
                ", fundLeverageFactor=" + fundLeverageFactor +
                ", fundStrategy='" + fundStrategy + '\'' +
                '}';
    }
}
