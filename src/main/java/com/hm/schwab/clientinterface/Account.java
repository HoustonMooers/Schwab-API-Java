package com.hm.schwab.clientinterface;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;

import javax.swing.JOptionPane;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hm.schwab.datastructs.query.account.OrderByID;
import com.hm.schwab.datastructs.query.account.OrderQuery;
import com.hm.schwab.datastructs.query.account.TransactionByID;
import com.hm.schwab.datastructs.query.account.TransactionQuery;
import com.hm.schwab.datastructs.schwab.AccountNumberHash;
import com.hm.schwab.datastructs.schwab.Order;
import com.hm.schwab.datastructs.schwab.OrderRequest;
import com.hm.schwab.datastructs.schwab.Transaction;
import com.hm.schwab.datastructs.schwab.UserPreference;

public class Account {
    public static String baseurl = "https://api.schwabapi.com/trader/v1/accounts/";
    private static Connection connection = Connection.getConnection();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static List<AccountNumberHash> getAccountNumbers(String token) throws IOException, InterruptedException {
        HttpResponse<String> response = connection.getRequest(baseurl + "accountNumbers", Connection.getHeaders(token));
        connection.checkResponseCode(response);
        try {
            return objectMapper.readValue(response.body(), new TypeReference<List<AccountNumberHash>>() {});
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse AccountNumbers response", e);
        }
    }

    public static List<com.hm.schwab.datastructs.schwab.Account> getAccountPositions(String token) throws IOException, InterruptedException {
        HttpResponse<String> response = connection.getRequest(baseurl + "?fields=positions", Connection.getHeaders(token));
        connection.checkResponseCode(response);
        try {
            return objectMapper.readValue(response.body(), new TypeReference<List<com.hm.schwab.datastructs.schwab.Account>>() {});
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse AccountPositions response", e);
        }
    }

    public static List<Order> getOrders(OrderQuery orderquery, String token) throws IOException, InterruptedException {
    	System.out.println(orderquery.getURI(baseurl));
        HttpResponse<String> response = connection.getRequest(orderquery.getURI(baseurl), Connection.getHeaders(token));
        connection.checkResponseCode(response);
        try {
            return objectMapper.readValue(response.body(), new TypeReference<List<Order>>() {});
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse Orders response", e);
        }
    }

    public static Order getOrder(OrderByID orderid, String optionalaccount, String token) throws IOException, InterruptedException {
        orderid.populateAccountIfNeeded(optionalaccount);
        HttpResponse<String> response = connection.getRequest(orderid.getURI(baseurl), Connection.getHeaders(token));
        connection.checkResponseCode(response);
        try {
            return objectMapper.readValue(response.body(), new TypeReference<Order>() {});
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse Order response", e);
        }
    }

    public static void cancelOrder(OrderByID orderid, String optionalaccount, String token) throws IOException, InterruptedException {
        orderid.populateAccountIfNeeded(optionalaccount);
        HttpResponse<String> response = connection.deleteRequest(orderid.getURI(baseurl), token);
        connection.checkResponseCode(response);
    }

    public static void submitOrder(Order order, String accountnumber, String token) throws IOException, InterruptedException {
        String body;
        try {
            body = objectMapper.writeValueAsString(order);
        } catch (Exception e) {
            throw new RuntimeException("Failed to serialize Order", e);
        }
        HttpResponse<String> response = connection.postRequest(order.getURI(baseurl, accountnumber), token, body);
        connection.checkResponseCode(response);
    }
    
    public static void replaceOrder(OrderRequest orderrequest, String accountnumber, String token) throws IOException, InterruptedException {
        String body;
        try {
            body = objectMapper.writeValueAsString(orderrequest);
        } catch (Exception e) {
            throw new RuntimeException("Failed to serialize Order", e);
        }
        HttpResponse<String> response = connection.putRequest(orderrequest.getURIByOrder(baseurl, accountnumber), token, body);
        connection.checkResponseCode(response);
    }

    public static List<Transaction> getTransactions(TransactionQuery transactionquery, String accountnumber, String token) throws IOException, InterruptedException {
        transactionquery.populateAccountIfNeeded(accountnumber);
        HttpResponse<String> response = connection.getRequest(transactionquery.getURI(baseurl), Connection.getHeaders(token));
        connection.checkResponseCode(response);
        try {
            return objectMapper.readValue(response.body(), new TypeReference<List<Transaction>>() {});
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse Transactions response", e);
        }
    }

    public static Transaction getTransaction(TransactionByID transactionid, String optionalaccount, String token) throws IOException, InterruptedException {
        transactionid.populateAccountIfNeeded(optionalaccount);
        HttpResponse<String> response = connection.getRequest(transactionid.getURI(baseurl), Connection.getHeaders(token));
        connection.checkResponseCode(response);
        try {
            List<Transaction> transactions = objectMapper.readValue(response.body(), new TypeReference<List<Transaction>>() {});
            return transactions.get(0);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse Transaction response", e);
        }
    }

    public static UserPreference getUserPreferences(String token) throws IOException, InterruptedException {
        HttpResponse<String> response = connection.getRequest("https://api.schwabapi.com/trader/v1/userPreference", Connection.getHeaders(token));
        connection.checkResponseCode(response);
        try {
            return objectMapper.readValue(response.body(), UserPreference.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse UserPreference response", e);
        }
    }
}
