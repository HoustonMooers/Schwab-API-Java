package com.hm.schwab.oauth;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.swing.JOptionPane;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RefreshToken {

	public static Token refresh(Token refreshtoken, OauthParams secrets) {
		String credentialsbase64 = secrets.getCredentialsBase64();

		HttpRequestBody requestbody = new HttpRequestBody();
		requestbody.add("grant_type", "refresh_token");
		requestbody.add("refresh_token", refreshtoken.token);

		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(secrets.getTokenUri()))
				.header("Authorization", "Basic " + credentialsbase64)
				.header("Content-Type", "application/x-www-form-urlencoded")
				.POST(HttpRequest.BodyPublishers.ofString(requestbody.toString()))
				.build();

		HttpClient client = HttpClient.newHttpClient();
		try {
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			if(response.statusCode() == 200) {
				ObjectMapper objectMapper = new ObjectMapper();
				OauthParams params = objectMapper.readValue(response.body(), OauthParams.class);
				//setup active token
				long expirationtime = System.currentTimeMillis() + Integer.parseInt(params.expires_in) * 1000 - Token.EXPIRATION_SLACK_TIME_IN_MS;
				return new Token(params.access_token, expirationtime);
			}
			else {
				StringBuilder sb = new StringBuilder();
				sb.append("Authentication request failed!" + System.lineSeparator());
				sb.append("Response Code: " + response.statusCode() + System.lineSeparator());
				sb.append("Response Body: " + response.body() + System.lineSeparator());
				System.err.println(sb.toString());
				JOptionPane.showMessageDialog(null, "An error occurred: " + sb.toString(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
}
