package com.issuetracker.domain;

public class Assignee {
    private final String id;
    private String name;
    private String avatarUrl;

    public Assignee(String id, String name, String avatarUrl) {
        this.id = id;
        this.name = name;
        this.avatarUrl = avatarUrl;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }
}
