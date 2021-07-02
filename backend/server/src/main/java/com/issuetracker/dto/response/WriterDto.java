package com.issuetracker.dto.response;

import com.issuetracker.domain.Writer;

public class WriterDto {
    private final String name;
    private final String profileImageUrl;

    public WriterDto(String name, String profileImageUrl) {
        this.name = name;
        this.profileImageUrl = profileImageUrl;
    }

    public String getName() {
        return name;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public static WriterDto from(Writer writer) {
        return new WriterDto(writer.getName(), writer.getProfileImageUrl());
    }
}
