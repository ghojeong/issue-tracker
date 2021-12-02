package com.issuetracker.dto.request;

import com.issuetracker.domain.UpdateIssue;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UpdateIssueRequest {

    @NotBlank(message = "title이 공백이어선 안됩니다.")
    @NotNull(message = "title 이 null 값이어선 안됩니다.")
    private String title;

    @NotBlank(message = "comment가 공백이어선 안됩니다.")
    @NotNull(message = "comment가 null 값이어선 안됩니다.")
    private String comment;

    protected UpdateIssueRequest() {}

    public UpdateIssueRequest(String title, String comment) {
        this.title = title;
        this.comment = comment;
    }

    public String getTitle() {
        return title;
    }

    public String getComment() {
        return comment;
    }

    public UpdateIssue toUpdateIssue() {
        return new UpdateIssue(title, comment);
    }
}
