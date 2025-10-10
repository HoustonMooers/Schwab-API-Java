package com.hm.schwab.clientinterface.streaming.listeners;

import java.util.Map;

public interface RawStreamListener extends StreamListener{
	void onData(Map<String, Object> data);
}