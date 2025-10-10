package com.hm.schwab.clientinterface.streaming.listeners;

import com.hm.schwab.clientinterface.streaming.responses.LevelOneOptionsResponse;

public interface LevelOneOptionsListener extends StreamListener {
	public void onData(LevelOneOptionsResponse response);
}
