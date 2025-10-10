package com.hm.schwab.clientinterface.streaming.listeners;

import com.hm.schwab.clientinterface.streaming.responses.LevelOneFuturesResponse;

public interface LevelOneFuturesListener extends StreamListener {
	public void onData(LevelOneFuturesResponse response);
}
