package com.hm.schwab.datastructs.query.account;

public class TransactionByID {
	//hashed account name
	private String accountnumber;
	private int transactionid;

	public TransactionByID(int transactionid) {
		this.transactionid = transactionid;
	}

	public TransactionByID(String accountnumber, int transactionid) {
		this.accountnumber = accountnumber;
		this.transactionid = transactionid;
	}

	public String getAccountnumber() {
		return accountnumber;
	}

	public int getTransactionID() {
		return transactionid;
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
		sb.append("/transactions/");
		sb.append(transactionid);
		return sb.toString();
	}
}
