package com.issuetracker.domain;

public class UpdateIssue {
    private final String title;
    private final String comment;

    public UpdateIssue(String title, String comment) {
        this.title = title;
        this.comment = comment;
    }

    public String getTitle() {
        return title;
    }

    public String getComment() {
        return comment;
    }
}
