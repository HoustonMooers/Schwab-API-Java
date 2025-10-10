package com.hm.schwab.clientinterface.streaming.listeners;

import com.hm.schwab.clientinterface.streaming.responses.ScreenerResponse;

public interface ScreenerListener extends StreamListener {
	public void onData(ScreenerResponse response);
}
