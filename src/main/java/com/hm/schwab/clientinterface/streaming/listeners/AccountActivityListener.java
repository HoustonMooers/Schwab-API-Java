package com.hm.schwab.clientinterface.streaming.listeners;

import com.hm.schwab.clientinterface.streaming.responses.AccountActivityResponse;
import com.hm.schwab.clientinterface.streaming.responses.ChartEquityResponse;

public interface AccountActivityListener extends StreamListener {
	public void onData(AccountActivityResponse response);
}

