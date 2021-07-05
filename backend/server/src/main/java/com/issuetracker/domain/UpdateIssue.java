package com.issuetracker.domain;

public class UpdateIssue {
    private final String title;
    private final String comment;
    private final Long milestoneId;

    public UpdateIssue(String title, String comment, Long milestoneId) {
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
}
