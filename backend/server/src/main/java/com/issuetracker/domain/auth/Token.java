package com.issuetracker.domain.auth;

public class Token {
    private final String accessToken;
    private final String tokenType;
    private final String scope;

    public Token(String accessToken, String tokenType, String scope) {
        this.accessToken = accessToken;
        this.tokenType = tokenType;
        this.scope = scope;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public String getScope() {
        return scope;
    }
}
