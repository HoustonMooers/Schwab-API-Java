package com.hm.schwab.datastructs.query.marketdata;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Set;

import com.hm.schwab.util.StringUtils;

public class InstrumentSearchQuery {
	private Set<String> symbols;
	private Projection projection;

	public InstrumentSearchQuery(String symbollist, Projection projection) {
		this.symbols = new HashSet<>();
		StringUtils.addStringsToSet(symbollist, this.symbols);
		this.projection = projection;
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

	public Projection getProjection() {
		return projection;
	}

	public void setProjection(Projection projection) {
		this.projection = projection;
	}

	public String getURI(String baseurl) {
		StringBuilder sb = new StringBuilder(baseurl);
		sb.append("instruments?symbol=");
		sb.append(getSymbols());
		sb.append("&projection=");
		sb.append(projection.getLabel());
		return sb.toString();
	}
}
