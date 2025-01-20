package com.hm.schwab.oauth;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OauthParams {
    @JsonProperty("app_key")
    public String app_key;
    @JsonProperty("app_secret")
    public String app_secret;
    @JsonProperty("redirect_uris")
    public String redirect_uris;
    @JsonProperty("auth_uri")
    public String auth_uri;
    @JsonProperty("token_uri")
    public String token_uri;
    @JsonProperty("refresh_token")
    public String refresh_token;
    @JsonProperty("expires_in")
    public String expires_in;
    @JsonProperty("access_token")
    public String access_token;

    public String getAppKey() {
        return app_key;
    }

    public String getAppSecret() {
        return app_secret;
    }

    public String getRedirectUris() {
        return redirect_uris;
    }

    public String getAuthUri() {
        return auth_uri;
    }

    public String getTokenUri() {
        return token_uri;
    }

    public String getCredentialsBase64() {
        String credentials = app_key + ":" + app_secret;
        return Base64.getEncoder().encodeToString(credentials.getBytes(StandardCharsets.UTF_8));
    }

    public static OauthParams loadJSON(File client_secrets) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(client_secrets, OauthParams.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}