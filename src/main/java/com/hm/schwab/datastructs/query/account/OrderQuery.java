package com.hm.schwab.datastructs.query.account;

import java.time.LocalDateTime;

import com.hm.schwab.util.TimeUtils;

public class OrderQuery {
	private String accountNumber;
	private int maxResults;
	private LocalDateTime fromEnteredTime;
	private LocalDateTime toEnteredTime;
	private OrderType ordertype;

	public OrderQuery(LocalDateTime fromEnteredTime, LocalDateTime toEnteredTime) {
		this.fromEnteredTime = fromEnteredTime;
		this.toEnteredTime = toEnteredTime;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getMaxResults() {
		return maxResults;
	}

	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}

	public LocalDateTime getFromEnteredTime() {
		return fromEnteredTime;
	}

	public void setFromEnteredTime(LocalDateTime fromEnteredTime) {
		this.fromEnteredTime = fromEnteredTime;
	}

	public LocalDateTime getToEnteredTime() {
		return toEnteredTime;
	}

	public void setToEnteredTime(LocalDateTime toEnteredTime) {
		this.toEnteredTime = toEnteredTime;
	}

	public OrderType getOrdertype() {
		return ordertype;
	}

	public void setOrdertype(OrderType ordertype) {
		this.ordertype = ordertype;
	}

	public String getURI(String baseurl) {
		StringBuilder sb = new StringBuilder(baseurl);
		if(accountNumber != null) {
			sb.append(accountNumber);
			sb.append('/');
		}
		else {
			//URL is inconsistent here...why not just /trader/v1/accounts/orders?
			sb = new StringBuilder("https://api.schwabapi.com/trader/v1/");
		}
		sb.append("orders");
		boolean prepandamp = false;
		if(maxResults != 0) {
			if(!prepandamp) {
				sb.append('?');
				prepandamp = true;
			}
			else {
				sb.append('&');
			}
			sb.append("maxResults=");
			sb.append(maxResults);
		}

		if(!prepandamp) {
			sb.append('?');
			prepandamp = true;
		}
		else {
			sb.append('&');
		}
		sb.append("fromEnteredTime=");
		sb.append(TimeUtils.getTimeFormat(fromEnteredTime));

		sb.append("&toEnteredTime=");
		sb.append(TimeUtils.getTimeFormat(toEnteredTime));

		if(ordertype != null) {
			sb.append("&status=");
			sb.append(ordertype.name());
		}
		return sb.toString();
	}
}
