package com.hm.schwab.datastructs.query.marketdata;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MarketHoursQuery {
	private Market market;
	private LocalDate date;
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public MarketHoursQuery(Market market, LocalDate date) {
		this.market = market;
		this.date = date;
	}

	public MarketHoursQuery(Market market) {
		this.market = market;
	}

	public String getURI(String baseuri) {
		StringBuilder sb = new StringBuilder(baseuri);
		sb.append("markets?markets=");
		sb.append(market);
		if(date != null) {
			sb.append("&date=");
			sb.append(date.format(formatter));
		}
		return sb.toString();
	}
}
