package com.hm.schwab.clientinterface;

public class Header {
	public String key;
	public String value;

	public Header(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getHeader() {
		return key + "=" + value;
	}
}
