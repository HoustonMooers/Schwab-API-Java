package com.hm.schwab.oauth;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.swing.JOptionPane;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Authenticator {
	private static OauthParams secrets;
	private static Authenticator authenticator;
	private static File REFRESH_TOKEN_PATH;
	private static File initializedClientSecretsFile;
	private Token refreshtoken;
	private Token activetoken;

	public static synchronized Authenticator getAuthenticator() {
		File defaultClientSecretsFile = getDefaultClientSecretsFile();
		if (authenticator == null) {
			authenticator = new Authenticator(defaultClientSecretsFile);
			initializedClientSecretsFile = defaultClientSecretsFile.getAbsoluteFile();
		}
		return authenticator;
	}

	public static synchronized Authenticator getAuthenticator(File clientSecretsFile) {
		File requestedFile = normalizeClientSecretsFile(clientSecretsFile);
		if (authenticator == null) {
			authenticator = new Authenticator(requestedFile);
			initializedClientSecretsFile = requestedFile.getAbsoluteFile();
		}
		else if (!initializedClientSecretsFile.equals(requestedFile.getAbsoluteFile())) {
			throw new IllegalStateException(
				"Authenticator already initialized with client secrets file: "
				+ initializedClientSecretsFile
				+ ". Cannot reinitialize with different client secrets file: "
				+ requestedFile
			);
		}
		return authenticator;
	}

	private Authenticator(File clientSecretsFile) {
		setupSecretsAndRefreshToken(clientSecretsFile);
		initializeTokens();
	}

	private void initializeTokens() {
		if (REFRESH_TOKEN_PATH.exists()) {
			refreshtoken = Token.load(REFRESH_TOKEN_PATH);
			refreshActiveToken();
		}
		else {
			doFullAuthentication();
		}
	}

	private static File getDefaultClientSecretsFile() {
		File homeDir = new File(System.getProperty("user.home"), ".schwab");
		return new File(homeDir, "client_secrets.json");
	}

	private static File normalizeClientSecretsFile(File clientSecretsFile) {
		return clientSecretsFile == null ? getDefaultClientSecretsFile() : clientSecretsFile;
	}

	private void setupSecretsAndRefreshToken(File clientSecretsFile) {
		File homeDir = new File(System.getProperty("user.home"), ".schwab");
		File clientsecrets = normalizeClientSecretsFile(clientSecretsFile);

		if (!clientsecrets.exists()) {
			JOptionPane.showMessageDialog(null,
					"ERROR: Cannot find client_secrets.json file located at: " + clientsecrets,
					"File Not Found",
					JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}

		secrets = OauthParams.loadJSON(clientsecrets);
		if (secrets == null || secrets.getAppKey() == null || secrets.getAppKey().isBlank()) {
			JOptionPane.showMessageDialog(null,
					"ERROR: Failed to load valid client_secrets.json file located at: " + clientsecrets,
					"Invalid client_secrets.json",
					JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}

		REFRESH_TOKEN_PATH = new File(homeDir, "refresh_token_" + getAppKeySuffix(secrets.getAppKey()));
	}

	private String getAppKeySuffix(String appKey) {
		String cleaned = appKey.replaceAll("[^A-Za-z0-9]", "");
		if (cleaned.isEmpty()) {
			return "default";
		}
		if (cleaned.length() > 5) {
			return cleaned.substring(0, 5);
		}
		return cleaned;
	}

	public synchronized String getActiveToken() {
		if (activetoken.isExpired()) {
			refreshActiveToken();
		}
		return activetoken.token;
	}

	private void refreshActiveToken() {
		if (refreshtoken == null || refreshtoken.isExpired()) {
			doFullAuthentication();
		}
		else {
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
				Token newrefreshtoken = new Token(params.refresh_token, expirationtime);
				newrefreshtoken.store(REFRESH_TOKEN_PATH);
				refreshtoken = newrefreshtoken;
				// setup active token
				expirationtime = System.currentTimeMillis() + Integer.parseInt(params.expires_in) * 1000 - Token.EXPIRATION_SLACK_TIME_IN_MS;
				activetoken = new Token(params.access_token, expirationtime);
			}
			else {
				StringBuilder sb = new StringBuilder();
				sb.append("Authentication request failed!" + System.lineSeparator());
				sb.append("Response Code: " + response.statusCode() + System.lineSeparator());
				sb.append("Response Body: " + response.body() + System.lineSeparator());
				System.err.println(sb.toString());
				JOptionPane.showMessageDialog(null, "An error occurred: " + sb.toString(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}

	private String openURLInBrowser(String url) {
	    boolean opened = false;

	    try {
	        // 1. Try the standard Desktop API
	        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
	            Desktop.getDesktop().browse(new URI(url));
	            opened = true;
	        }
	    }
	    catch (Exception e) {
	        // Log the failure and fall through to the manual method
	        System.err.println("Standard Desktop.browse failed, trying fallback...");
	    }

	    // 2. Fallback for Linux/Fedora/KDE if the standard way failed
	    if (!opened) {
	        try {
	            // This works on virtually all Linux distros (Fedora, Mint, Ubuntu, etc.)
	            new ProcessBuilder("xdg-open", url).start();
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	            // At this point, you might want to show an error to the user
	            // telling them to copy-paste the URL manually.
	        }
	    }

	    return ResponsePopup.getResponse(url);
	}
}