package com.issuetracker.dto.response;

import com.issuetracker.domain.Writer;

public class WriterResponse {
    private final String name;
    private final String avatarUrl;

    public WriterResponse(String name, String avatarUrl) {
        this.name = name;
        this.avatarUrl = avatarUrl;
    }

    public String getName() {
        return name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public static WriterResponse from(Writer writer) {
        return new WriterResponse(writer.getName(), writer.getAvatarUrl());
    }
}
