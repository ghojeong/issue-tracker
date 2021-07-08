package com.issuetracker.dto.response;

import java.util.List;

public class MessagesResponse {
    private final List<String> message;

    public MessagesResponse(List<String> message) {
        this.message = message;
    }

    public List<String> getMessage() {
        return message;
    }
}
