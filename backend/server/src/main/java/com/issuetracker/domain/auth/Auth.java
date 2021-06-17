package com.issuetracker.domain.auth;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("auth")
public class Auth {
    @Id
    private final String userEmail;

    private final User user;

    private final Token token;

    public Auth(String userEmail, User user, Token token) {
        this.userEmail = userEmail;
        this.user = user;
        this.token = token;
    }

    public static Auth from(User user, Token token) {
        return new Auth(user.getEmail(), user, token);
    }
}