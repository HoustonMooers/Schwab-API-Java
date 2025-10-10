package com.hm.schwab.clientinterface.streaming.listeners;

import com.hm.schwab.clientinterface.streaming.responses.LevelOneEquitiesResponse;

public interface LevelOneEquitiesListener extends StreamListener {
	public void onData(LevelOneEquitiesResponse response);
}
