package com.hm.schwab.clientinterface.streaming.listeners;

import com.hm.schwab.clientinterface.streaming.responses.LevelOneForexResponse;

public interface LevelOneForexListener extends StreamListener {
	public void onData(LevelOneForexResponse response);
}


