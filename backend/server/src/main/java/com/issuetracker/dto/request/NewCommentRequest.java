package com.issuetracker.dto.request;

public class NewCommentRequest {
    private final String content;

    public NewCommentRequest(Long issueId, String content) {
        this.content = content;
    }
    
    public String getContent() {
        return content;
    }
}
