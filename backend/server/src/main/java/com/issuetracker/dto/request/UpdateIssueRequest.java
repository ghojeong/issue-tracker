package com.issuetracker.dto.request;

import com.issuetracker.domain.UpdateIssue;

public class UpdateIssueRequest {
    private final String title;
    private final String comment;
    private final Long milestoneId;

    public UpdateIssueRequest(String title, String comment, Long milestoneId) {
        this.title = title;
        this.comment = comment;
        this.milestoneId = milestoneId;
    }

    public String getTitle() {
        return title;
    }

    public String getComment() {
        return comment;
    }

    public Long getMilestoneId() {
        return milestoneId;
    }

    public UpdateIssue toUpdateIssue() {
        return new UpdateIssue(title, comment, milestoneId);
    }
}
