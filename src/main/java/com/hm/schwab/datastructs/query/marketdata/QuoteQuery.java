package com.hm.schwab.datastructs.query.marketdata;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;
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
	
	public QuoteQuery(Collection<String> collection) {
		this.symbols = new HashSet<String>(collection);
	}
	
	private QuoteQuery(QuoteQuery quotequery) {
		this.fields = quotequery.fields;
		this.indicative = quotequery.indicative;
		this.symbols = new HashSet<String>();
	}

	public QuoteQuery(SingleQuoteQuery quotequery) {
		this(quotequery.getSymbols());
		this.fields = quotequery.getFields();
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

	public int getNumSymbolsInRequest() {
		return this.symbols.size();
	}

	public QuoteQuery[] split(int maxsymbols) {
		int numsymbols = this.symbols.size();
		int batches = numsymbols / maxsymbols;
		if(numsymbols % maxsymbols != 0) {
			batches++;
		}
		QuoteQuery[] qqarr = new QuoteQuery[batches];
		QuoteQuery curbatch = new QuoteQuery(this);
		qqarr[0] = curbatch;
		int arrindex = 1;
		int count = 0;
		for(String symbol : symbols) {
			if(count == maxsymbols) {
				count = 0;
				curbatch = new QuoteQuery(this);
				qqarr[arrindex++] = curbatch;
			}
			curbatch.symbols.add(symbol);
			count++;
		}
		return qqarr;
	}
}
