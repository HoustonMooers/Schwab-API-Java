package com.hm.schwab.oauth;

public class HttpRequestBody {
	private StringBuilder sb;

	public HttpRequestBody() {
		this.sb = new StringBuilder();
	}

	public void add(String key, String value) {
		if(!sb.isEmpty()) {
			sb.append('&');
		}
		sb.append(key);
		sb.append('=');
		sb.append(value);

//		sb.append(URLEncoder.encode(key, StandardCharsets.UTF_8));
//		sb.append('=');
//		sb.append(URLEncoder.encode(value, StandardCharsets.UTF_8));
	}

	@Override
	public String toString() {
		return sb.toString();
	}
}
