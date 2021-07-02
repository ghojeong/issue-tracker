package com.issuetracker.dto.response;

import com.issuetracker.domain.Writer;

public class WriterResponse {
    private final String name;
    private final String profileImageUrl;

    public WriterResponse(String name, String profileImageUrl) {
        this.name = name;
        this.profileImageUrl = profileImageUrl;
    }

    public String getName() {
        return name;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public static WriterResponse from(Writer writer) {
        return new WriterResponse(writer.getName(), writer.getProfileImageUrl());
    }
}
