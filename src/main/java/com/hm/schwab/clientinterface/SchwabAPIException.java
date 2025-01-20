package com.hm.schwab.clientinterface;

import java.net.http.HttpResponse;

public class SchwabAPIException extends RuntimeException {
    private HttpResponse<String> response;

    public SchwabAPIException(HttpResponse<String> response) {
        super("Schwab API returned an error: " + response.statusCode() + " - " + response.body());
        this.response = response;
    }

    public HttpResponse<String> getResponse() {
        return response;
    }
}