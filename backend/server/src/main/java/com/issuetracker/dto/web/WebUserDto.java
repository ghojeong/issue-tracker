package com.issuetracker.dto.web;

public class WebUserDto {
    private final String id;
    private final String name;
    private final String profileImageUrl;

    public WebUserDto(String id, String name, String profileImageUrl) {
        this.id = id;
        this.name = name;
        this.profileImageUrl = profileImageUrl;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }
}
