package com.issuetracker.domain;

public class Writer {
    private final String id;
    private final String avatarUrl;

    public Writer(String id, String avatarUrl) {
        this.id = id;
        this.avatarUrl = avatarUrl;
    }

    public String getId() {
        return id;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }
}
