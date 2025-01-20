package com.hm.schwab.datastructs.query.marketdata;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class SingleQuoteQuery {
	private String symbol;
	private String fields;

	public SingleQuoteQuery(String symbol) {
		this.symbol = symbol;
    }

	public String getSymbols() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getFields() {
		return fields;
	}

	public void setFields(String fields) {
		this.fields = fields;
	}

	public String getURI(String baseurl) {
		StringBuilder sb = new StringBuilder(baseurl);
		sb.append(symbol);
		sb.append("/quotes");

		if(fields != null) {
			sb.append("?fields=");
			try {
				sb.append(URLEncoder.encode(fields, "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
}
