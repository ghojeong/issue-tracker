package com.issuetracker.domain;

public class Writer {
    private final String name;
    private final String avatarUrl;

    public Writer(String name, String avatarUrl) {
        this.name = name;
        this.avatarUrl = avatarUrl;
    }

    public String getName() {
        return name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }
}
