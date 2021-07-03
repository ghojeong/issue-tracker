package com.issuetracker.dto.request;

public class CommentRequest {
    private final String content;

    public CommentRequest(Long issueId, String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
