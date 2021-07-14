package com.issuetracker.dto.auth;

import com.issuetracker.domain.auth.Token;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class AccessTokenResponse {
    private String accessToken;
    private String tokenType;
    private String scope;

    @JsonGetter("access_token")
    public String getAccessToken() {
        return accessToken;
    }

    @JsonSetter("access_token")
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @JsonGetter("token_type")
    public String getTokenType() {
        return tokenType;
    }

    @JsonSetter("token_type")
    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    @JsonGetter("scope")
    public String getScope() {
        return scope;
    }

    @JsonSetter("scope")
    public void setScope(String scope) {
        this.scope = scope;
    }

    public Token toToken() {
        return new Token(accessToken, tokenType, scope);
    }
}
