package com.hm.schwab.datastructs.query.marketdata;

import java.time.LocalDateTime;

import com.hm.schwab.util.TimeUtils;

public class HistoricalDataQuery {
	private String symbol;
	private PeriodType periodtype;
	private int period;
	private FrequencyType frequencytype;
	private int frequency;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private Boolean extended;
	private Boolean includepreviousclose;

	//the Period parameters specify the length of time that the data should span...how many years, weeks, days, etc of data to return
	//the Frequency parameters specify the sampling interval
	public HistoricalDataQuery(String symbol, PeriodType periodtype, int period, FrequencyType frequencytype, int frequency) {
		this.symbol = symbol;
		this.periodtype = periodtype;
		this.period = period;
		this.frequencytype = frequencytype;
		this.frequency = frequency;
	}
	
	public HistoricalDataQuery(String symbol, PeriodType periodtype, FrequencyType frequencytype, int frequency) {
		this.symbol = symbol;
		this.periodtype = periodtype;
		this.period = -1;
		this.frequencytype = frequencytype;
		this.frequency = frequency;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public void setExtended(Boolean extended) {
		this.extended = extended;
	}

	public void setIncludepreviousclose(Boolean includepreviousclose) {
		this.includepreviousclose = includepreviousclose;
	}

	public String getURI(String baseuri) {
		StringBuilder sb = new StringBuilder(baseuri);
		sb.append("pricehistory?symbol=");
		sb.append(symbol);
		sb.append("&periodType=");
		sb.append(periodtype);
		if(period != -1) {
			sb.append("&period=");
			sb.append(period);
		}
		sb.append("&frequencyType=");
		sb.append(frequencytype);
		sb.append("&frequency=");
		sb.append(frequency);
		sb.append("&startDate=");

		if(startDate != null) {
			sb.append(TimeUtils.toEpochMillis(startDate));
		}
		else {
			sb.append(0);
		}

		if(endDate != null) {
			sb.append("&endDate=");
			sb.append(TimeUtils.toEpochMillis(endDate));
		}

		if(extended != null) {
			sb.append("&needExtendedHoursData=");
			sb.append(extended ? "true" : "false");
		}

		if(includepreviousclose != null) {
			sb.append("&needPreviousClose=");
			sb.append(includepreviousclose ? "true" : "false");
		}
		return sb.toString();
	}
}
