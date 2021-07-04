package com.issuetracker.dto.request;

import com.issuetracker.domain.NewIssue;

public class IssueRequest {
    private final String title;
    private final String comment;
    private final Long milestoneId;

    public IssueRequest(String title, String comment, Long milestoneId) {
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

    public NewIssue toNewIssue() {
        return new NewIssue(title, comment, milestoneId);
    }
}
