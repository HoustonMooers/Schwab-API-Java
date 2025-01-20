package com.hm.schwab.clientinterface;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpRequest.Builder;
import java.net.http.HttpResponse;

public class Connection {
	private static Connection connection = new Connection();
	private HttpClient client;

	private Connection() {
		client = HttpClient.newHttpClient();
	}

	public HttpResponse<String> getRequest(String uri, Header[] headers) throws IOException, InterruptedException {
		Builder requestbuilder = HttpRequest.newBuilder().uri(URI.create(uri)).GET();
		addHeaders(requestbuilder, headers);
		HttpRequest request = requestbuilder.build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
	}

	//used for canceling orders
	public HttpResponse<String> deleteRequest(String uri, Header[] headers) throws IOException, InterruptedException {
		Builder requestbuilder = HttpRequest.newBuilder().uri(URI.create(uri)).DELETE();
		addHeaders(requestbuilder, headers);
		HttpRequest request = requestbuilder.build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
	}

	public HttpResponse<String> postRequest(String uri, String token, String body) throws IOException, InterruptedException {
		Builder requestbuilder = HttpRequest.newBuilder()
				.uri(URI.create(uri))
				.POST(BodyPublishers.ofString(body))
				.header("Content-Type", "application/json")
				.header("Authorization", "Bearer " + token);
		HttpRequest request = requestbuilder.build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
	}

	private void addHeaders(Builder requestbuilder, Header[] headers) {
		for(Header header : headers) {
			requestbuilder.header(header.key, header.value);
		}
	}

	public static Connection getConnection() {
		return connection;
	}

	public void checkResponseCode(HttpResponse<String> resp) {
		int code = resp.statusCode();
		if(code != 200 && code != 201) {
			throw new SchwabAPIException(resp);
		}
	}

	public static Header[] getHeaders(String token) {
        Header[] headers = new Header[2];
        headers[0] = new Header("accept", "application/json");
        headers[1] = new Header("Authorization", "Bearer " + token);
        return headers;
	}
}
