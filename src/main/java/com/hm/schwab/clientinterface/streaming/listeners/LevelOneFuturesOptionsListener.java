package com.hm.schwab.clientinterface.streaming.listeners;

import com.hm.schwab.clientinterface.streaming.responses.LevelOneFuturesOptionsResponse;

public interface LevelOneFuturesOptionsListener extends StreamListener {
	public void onData(LevelOneFuturesOptionsResponse response);
}
