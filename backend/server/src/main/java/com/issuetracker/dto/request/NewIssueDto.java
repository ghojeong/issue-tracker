package com.issuetracker.dto.request;

import com.issuetracker.domain.NewIssue;

import java.util.List;

public class NewIssueDto {
    private String title;
    private String comment;
    private List<String> assigneeIds;
    private List<Long> labelIds;
    private Long milestoneId;

    public NewIssueDto(String title, String comment, List<String> assigneeIds, List<Long> labelIds, Long milestoneId) {
        this.title = title;
        this.comment = comment;
        this.assigneeIds = assigneeIds;
        this.labelIds = labelIds;
        this.milestoneId = milestoneId;
    }

    public String getTitle() {
        return title;
    }

    public String getComment() {
        return comment;
    }

    public List<String> getAssigneeIds() {
        return assigneeIds;
    }

    public List<Long> getLabelIds() {
        return labelIds;
    }

    public Long getMilestoneId() {
        return milestoneId;
    }

    public NewIssue toNewIssue() {
        return new NewIssue(title, comment, assigneeIds, labelIds, milestoneId);
    }
}
