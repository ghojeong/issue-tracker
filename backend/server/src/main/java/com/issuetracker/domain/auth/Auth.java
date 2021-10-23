package com.issuetracker.domain.auth;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("auth")
public class Auth {
    @Id
    private final String userId;

    private final User user;

    private final Token token;

    public Auth(String userId, User user, Token token) {
        this.userId = userId;
        this.user = user;
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public static Auth from(User user, Token token) {
        return new Auth(user.getId(), user, token);
    }
}
