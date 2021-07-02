package com.issuetracker.dto.response;

import com.fasterxml.jackson.annotation.JsonGetter;

public class MessageResponse {
    private final String message;

    public MessageResponse(String message) {
        this.message = message;
    }

    @JsonGetter("message")
    public String getMessage() {
        return message;
    }
}
