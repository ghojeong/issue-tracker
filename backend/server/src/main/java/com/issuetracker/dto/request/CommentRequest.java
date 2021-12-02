package com.issuetracker.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CommentRequest {
    @NotNull(message = "content는 null일 수 없습니다.")
    @NotBlank(message = "content는 공백일 수 없습니다.")
    private String content;

    protected CommentRequest() {}

    public CommentRequest(Long issueId, String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
