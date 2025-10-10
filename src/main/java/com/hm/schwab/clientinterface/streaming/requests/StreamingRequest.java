package com.hm.schwab.clientinterface.streaming.requests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hm.schwab.clientinterface.streaming.Service;
import com.hm.schwab.datastructs.schwab.StreamerInfo;

public class StreamingRequest {
	//subscribes to all fields
	public static String GetStreamingRequest(Service service, int requestid, StreamerInfo streamerInfo, Command command, String keys, String fields, ObjectMapper objectMapper) throws JsonProcessingException {
		Map<String, Object> parammap = new HashMap<>();
        parammap.put("service", service.name());
        parammap.put("requestid", Integer.toString(requestid));
        parammap.put("command", command.name());
        parammap.put("SchwabClientCustomerId", streamerInfo.schwabClientCustomerId);
        parammap.put("SchwabClientCorrelId", streamerInfo.schwabClientCorrelId);
        if(!NullOrEmpty(keys) && !NullOrEmpty(keys)) {
        	Map<String, Object> innerparammap = new HashMap<String, Object>();
        	if(!NullOrEmpty(keys)) {
        		innerparammap.put("keys", keys);
        	}
        	if(!NullOrEmpty(fields)) {
        		innerparammap.put("fields", fields);
        	}
        	parammap.put("parameters", innerparammap);
        }
        Map<String, List<Map<String, Object>>> requestRoot = new HashMap<>();
        List<Map<String, Object>> requestlist = new ArrayList<>();
        requestlist.add(parammap);
        requestRoot.put("requests", requestlist);
        return objectMapper.writeValueAsString(requestRoot);
	}

	private static boolean NullOrEmpty(String str) {
		return str == null || str.isEmpty();
	}
}
