package com.issuetracker.dto.request;

import com.issuetracker.domain.UpdateIssue;

public class UpdateIssueRequest {
    private final String title;
    private final String comment;

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
