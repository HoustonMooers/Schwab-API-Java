package com.hm.schwab.datastructs.query.marketdata;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashSet;

import com.hm.schwab.util.StringUtils;

public class QuoteQuery {
	private HashSet<String> symbols;
	private String fields;
	private Boolean indicative;

	public QuoteQuery(String symbollist) {
		this.symbols = new HashSet<>();
		StringUtils.addStringsToSet(symbollist, symbols);
    }

	public String getSymbols() {
		 try {
			return URLEncoder.encode(String.join(",", this.symbols), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		 return null;
	}

	public void addCommaSepSymbolList(String symbollist) {
		StringUtils.addStringsToSet(symbollist, symbols);
	}

	public void addSymbol(String symbol) {
		this.symbols.add(symbol);
	}

	public String getFields() {
		return fields;
	}

	public void setFields(String fields) {
		this.fields = fields;
	}

	public boolean isIndicative() {
		return indicative;
	}

	public void setIndicative(boolean indicative) {
		this.indicative = indicative;
	}

	public String getURI(String baseurl) {
		StringBuilder sb = new StringBuilder(baseurl);
		sb.append("quotes");
		sb.append("?symbols=");
		sb.append(getSymbols());

		if(fields != null) {
			sb.append("&fields=");
			try {
				sb.append(URLEncoder.encode(fields, "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}

		if(indicative != null) {
			sb.append("&indicative=");
			sb.append(indicative);
		}
		return sb.toString();
	}
}
