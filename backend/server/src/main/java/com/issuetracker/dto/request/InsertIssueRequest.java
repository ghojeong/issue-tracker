package com.issuetracker.dto.request;

import com.issuetracker.domain.InsertIssue;

import java.util.List;

public class InsertIssueRequest {
    private final String title;
    private final String comment;
    private final Long milestoneId;
    private final List<String> assigneeIds;
    private final List<Long> labelIds;

    public InsertIssueRequest(String title, String comment, Long milestoneId, List<String> assigneeIds, List<Long> labelIds) {
        this.title = title;
        this.comment = comment;
        this.milestoneId = milestoneId;
        this.assigneeIds = assigneeIds;
        this.labelIds = labelIds;
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

    public List<String> getAssigneeIds() {
        return assigneeIds;
    }

    public List<Long> getLabelIds() {
        return labelIds;
    }

    public InsertIssue toInsertIssue() {
        return new InsertIssue(title, comment, milestoneId, assigneeIds, labelIds);
    }
}
