package com.hm.schwab.oauth;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.swing.JOptionPane;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Authenticator {
	private static OauthParams secrets;
	private static Authenticator authenticator = new Authenticator();
	private static File REFRESH_TOKEN_PATH;
	private Token refreshtoken;
	private Token activetoken;


	public static Authenticator getAuthenticator() {
		return authenticator;
	}

	private Authenticator() {
		setupSecretsAndRefreshToken();
		if (REFRESH_TOKEN_PATH.exists()) {
			refreshtoken = Token.load(REFRESH_TOKEN_PATH);
			refreshActiveToken();
		} else {
			doFullAuthentication();
		}
	}

	private void setupSecretsAndRefreshToken() {
		// Get the path to the user's home directory
		File homeDir = new File(System.getProperty("user.home"), ".schwab");
		File clientsecrets = new File(homeDir, "client_secrets.json");
		if(!clientsecrets.exists()) {
			JOptionPane.showMessageDialog(null,
					"ERROR: Cannot find client_secrets.json file located at: " + clientsecrets,
					"File Not Found",
					JOptionPane.ERROR_MESSAGE);
			System.exit(1); // Terminate the program after displaying the error message
		}
		secrets = OauthParams.loadJSON(clientsecrets);

		// Path to refresh token it exists.  It will be created after first use.
		REFRESH_TOKEN_PATH = new File(homeDir, "refresh_token");
	}

	public synchronized String getActiveToken() {
		if (activetoken.isExpired()) {
			refreshActiveToken();
		}
		return activetoken.token;
	}

	private void refreshActiveToken() {
		if (refreshtoken.isExpired()) {
			doFullAuthentication();
		} else {
			activetoken = RefreshToken.refresh(refreshtoken, secrets);
		}
	}

	private void doFullAuthentication() {
		String webloginresponse = openURLInBrowser("https://api.schwabapi.com/v1/oauth/authorize?client_id=" + secrets.getAppKey() + "&redirect_uri=https://127.0.0.1");

		// Find the start of the code parameter
		int codeStartIndex = webloginresponse.indexOf("code=") + 5; // 5 is the length of "code="

		// Find the end of the code parameter
		int codeEndIndex = webloginresponse.indexOf("%40", codeStartIndex);

		// Extract the code value
		String codeValue = webloginresponse.substring(codeStartIndex, codeEndIndex) + "@";

		String credentialsbase64 = secrets.getCredentialsBase64();

		HttpRequestBody requestbody = new HttpRequestBody();
		requestbody.add("grant_type", "authorization_code");
		requestbody.add("code", codeValue);
		requestbody.add("redirect_uri", "https://127.0.0.1");

		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(secrets.getTokenUri()))
				.header("Authorization", "Basic " + credentialsbase64)
				.header("Content-Type", "application/x-www-form-urlencoded")
				.POST(HttpRequest.BodyPublishers.ofString(requestbody.toString()))
				.build();

		HttpClient client = HttpClient.newHttpClient();
		try {
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			if (response.statusCode() == 200) {
				ObjectMapper objectMapper = new ObjectMapper();
				OauthParams params = objectMapper.readValue(response.body(), OauthParams.class);
				// store refresh token
				LocalDateTime refreshexpirationtime = LocalDateTime.now().plusDays(7).minusMinutes(4);
				long expirationtime = refreshexpirationtime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
				Token refreshtoken = new Token(params.refresh_token, expirationtime);
				refreshtoken.store(REFRESH_TOKEN_PATH);
				// setup active token
				expirationtime = System.currentTimeMillis() + Integer.parseInt(params.expires_in) * 1000 - Token.EXPIRATION_SLACK_TIME_IN_MS;
				activetoken = new Token(params.access_token, expirationtime);
			} else {
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
	}

	private String openURLInBrowser(String url) {
		if (Desktop.isDesktopSupported()) {
			try {
				Desktop desktop = Desktop.getDesktop();
				desktop.browse(new URI(url));
			} catch (IOException | URISyntaxException e) {
				e.printStackTrace();
			}
		}
		return ResponsePopup.getResponse(url);
	}
}