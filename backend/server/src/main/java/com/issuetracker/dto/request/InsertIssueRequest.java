package com.issuetracker.dto.request;

import com.issuetracker.domain.InsertIssue;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class InsertIssueRequest {

    @NotBlank(message = "title이 공백이어선 안됩니다.")
    @NotNull(message = "title 이 null 값이어선 안됩니다.")
    private String title;

    @NotBlank(message = "comment가 공백이어선 안됩니다.")
    @NotNull(message = "comment 가 null 값이어선 안됩니다.")
    private String comment;

    private Long milestoneId;
    private List<String> assigneeIds;
    private List<Long> labelIds;

    protected InsertIssueRequest() {}

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
