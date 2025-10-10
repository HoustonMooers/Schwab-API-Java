package com.hm.schwab.datastructs.query.account;

public class OrderByID {
	//hashed account name
	private String accountnumber;
	private long orderid;

	public OrderByID(long orderid) {
		this.orderid = orderid;
	}

	public OrderByID(String accountnumber, long orderid) {
		this.accountnumber = accountnumber;
		this.orderid = orderid;
	}

	public String getAccountnumber() {
		return accountnumber;
	}

	public long getOrderid() {
		return orderid;
	}

	//it's ok to leave account number null if there is only 1 account
	public void populateAccountIfNeeded(String optionalaccount) {
		if(accountnumber == null) {
			accountnumber = optionalaccount;
		}
	}

	public String getURI(String baseurl) {
		StringBuilder sb = new StringBuilder(baseurl);
		sb.append(accountnumber);
		sb.append("/orders/");
		sb.append(orderid);
		return sb.toString();
	}
}
