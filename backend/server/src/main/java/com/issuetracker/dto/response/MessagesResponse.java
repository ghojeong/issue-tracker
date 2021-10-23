package com.issuetracker.dto.response;

import java.util.List;

public class MessagesResponse {
    private final List<String> messages;

    public MessagesResponse(List<String> messages) {
        this.messages = messages;
    }

    public List<String> getMessages() {
        return messages;
    }
}
