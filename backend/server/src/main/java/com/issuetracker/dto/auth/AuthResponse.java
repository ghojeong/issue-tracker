package com.issuetracker.dto.auth;

public class AuthResponse {
    private final String token;
    private final String name;
    private final String avatarUrl;

    public AuthResponse(String token, String name, String avatarUrl) {
        this.token = token;
        this.name = name;
        this.avatarUrl = avatarUrl;
    }

    public String getToken() {
        return token;
    }

    public String getName() {
        return name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }
}
