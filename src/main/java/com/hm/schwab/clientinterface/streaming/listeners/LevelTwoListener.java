package com.hm.schwab.clientinterface.streaming.listeners;

import com.hm.schwab.clientinterface.streaming.responses.level2.LevelTwoResponse;

public interface LevelTwoListener extends StreamListener {
	public void onData(LevelTwoResponse response);
}
