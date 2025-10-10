package com.hm.schwab.clientinterface.streaming.listeners;

import com.hm.schwab.clientinterface.streaming.responses.ChartFuturesResponse;

public interface ChartFuturesListener extends StreamListener {
	public void onData(ChartFuturesResponse response);
}
