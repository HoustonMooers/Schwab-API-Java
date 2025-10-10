package com.hm.schwab.clientinterface.streaming.listeners;

import com.hm.schwab.clientinterface.streaming.responses.ChartEquityResponse;

public interface ChartEquityListener extends StreamListener {
	public void onData(ChartEquityResponse response);
}
