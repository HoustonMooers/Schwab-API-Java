package com.hm.schwab.clientinterface.streaming.responses;

import java.util.Map;

public abstract class Response {
    public final Map<String, Object> dataMap;
	public long timestamp;

    public Response(Map<String, Object> dataMap, long timestamp) {
        this.dataMap = dataMap;
        this.timestamp = timestamp;
    }
    
    public boolean hasField(String field) {
        return dataMap.containsKey(field);
    }

    public Object getField(String field) {
        return dataMap.get(field);
    }
}
