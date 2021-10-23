package com.issuetracker.dto.auth;

import com.fasterxml.jackson.annotation.JsonGetter;

public class AccessTokenRequest {
    private final String clientId;
    private final String clientSecret;
    private final String code;

    public AccessTokenRequest(String clientId, String clientSecret, String code) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.code = code;
    }

    @JsonGetter("client_id")
    public String getClientId() {
        return clientId;
    }

    @JsonGetter("client_secret")
    public String getClientSecret() {
        return clientSecret;
    }

    @JsonGetter("code")
    public String getCode() {
        return code;
    }
}
