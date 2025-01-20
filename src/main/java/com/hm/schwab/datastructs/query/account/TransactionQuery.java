package com.hm.schwab.datastructs.query.account;

import java.time.LocalDateTime;

import com.hm.schwab.util.TimeUtils;

public class TransactionQuery {
	private String accountNumber;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private String symbol;
	private TransactionType ordertype;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public TransactionType getOrdertype() {
		return ordertype;
	}

	public void setOrdertype(TransactionType ordertype) {
		this.ordertype = ordertype;
	}

	//it's ok to leave account number null if there is only 1 account
	public void populateAccountIfNeeded(String optionalaccount) {
		if(accountNumber == null) {
			accountNumber = optionalaccount;
		}
	}

	public String getURI(String baseurl) {
		StringBuilder sb = new StringBuilder(baseurl);
		sb.append(accountNumber);
		sb.append("/transactions?");

		sb.append("startDate=");
		sb.append(TimeUtils.getTimeFormat(startDate));

		sb.append("&endDate=");
		sb.append(TimeUtils.getTimeFormat(endDate));

		if(symbol != null) {
			sb.append("&symbol=");
			sb.append(symbol);
		}

		if(ordertype != null) {
			sb.append("&status=");
			sb.append(ordertype.name());
		}
		return sb.toString();
	}
}
