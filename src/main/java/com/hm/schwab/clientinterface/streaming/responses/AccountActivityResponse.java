package com.hm.schwab.clientinterface.streaming.responses;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AccountActivityResponse {
    // Public fields
    public int sequence;
    public String key;
    public String account;
    public String messageType;
    public String messageData;
	private long timestamp;

    public AccountActivityResponse(Map<String, Object> dataMap, long timestamp) {
    	this.timestamp = timestamp;
        this.sequence = (Integer) dataMap.get("seq");
        this.key = (String) dataMap.get("key");
        this.account = (String) dataMap.get("1");
        this.messageType = (String) dataMap.get("2");
        this.messageData = (String) dataMap.get("3");
    }

    // This field identifies the message number. If client reconnects and receives the same seq number again, it can choose to ignore the duplicate.
    public int getSequence() {
        return sequence;
    }

    // Passed back to the client from the request to identify a subscription this response belongs to.
    public String getKey() {
        return key;
    }

    // Account Number that the activity occurred on.
    public String getAccount() {
        return account;
    }

    // Message Type that dictates the format of the Message Data field.
    public String getMessageType() {
        return messageType;
    }

    // The core data for the message. Either JSON-formatted data describing the update, NULL in some cases, or plain text in case of ERROR.
    public String getMessageData() {
        return messageData;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AccountActivityResponse:\n");
        sb.append("  Sequence: ").append(sequence).append("\n");
        sb.append("  Key: ").append(key).append("\n");
        sb.append("  Account: ").append(account).append("\n");
        sb.append("  Message Type: ").append(messageType).append("\n");
        sb.append("  Message Data: ").append(messageData).append("\n");
        return sb.toString();
    }

	public String getOrderID() {
	    ObjectMapper objectMapper = new ObjectMapper();
	    JsonNode rootNode = null;
	    try {
	    	rootNode = objectMapper.readTree(messageData);
	    }
	    catch (IOException e) {
	        e.printStackTrace();
	    }
        // Extract the SchwabOrderID at the top level
        return rootNode.path("SchwabOrderID").asText();	
	}
}