package com.hm.schwab.datastructs.query.marketdata;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class MarketMoversQuery {
	private SymbolID symbolid;
	private SortOrder sort;
	private Frequency frequency;

	//SortOrder and Frequency can be null
	public MarketMoversQuery(SymbolID symbolid, SortOrder sortorder, Frequency frequency) {
		this.symbolid = symbolid;
		this.sort = sortorder;
		this.frequency = frequency;
	}

	public MarketMoversQuery(SymbolID symbolid) {
		this.symbolid = symbolid;
	}

	public void setSort(SortOrder sort) {
		this.sort = sort;
	}

	public void setFrequency(Frequency frequency) {
		this.frequency = frequency;
	}

	public String getURI(String baseuri) {
		StringBuilder sb = new StringBuilder(baseuri);
		sb.append("movers/");
		try {
			sb.append(URLEncoder.encode(symbolid.getLabel(), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		boolean prependamp = false;
		if(sort != null) {
			if(prependamp) {
				sb.append('&');
			}
			else {
				sb.append('?');
				prependamp = true;
			}
			sb.append("sort=");
			sb.append(sort);
		}

		if(frequency != null) {
			if(prependamp) {
				sb.append('&');
			}
			else {
				sb.append('?');
				prependamp = true;
			}
			sb.append("frequency=");
			sb.append(frequency.getLabel());
		}
		return sb.toString();
	}
}
