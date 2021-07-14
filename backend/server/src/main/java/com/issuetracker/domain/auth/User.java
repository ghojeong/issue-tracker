package com.issuetracker.domain.auth;

import org.springframework.data.annotation.Id;

import java.util.List;

public class User {

    @Id
    private final String id;

    private String name;

    private String avatarUrl;

    private List<String> emails;

    public User(String id, String name, String avatarUrl, List<String> emails) {
        this.id = id;
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.emails = emails;
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

    public List<String> getEmails() {
        return emails;
    }
}
