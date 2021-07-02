package com.issuetracker.dto.response;

import com.issuetracker.domain.NewIssue;

import java.util.List;

public class NewIssueDto {

    private String title;

    private String comment;

    private AssigneesDto assignees;

    private LabelsDto labels;

    private Long milestoneId;

    public NewIssueDto(String title, String comment, AssigneesDto assignees, LabelsDto labels, Long milestoneId) {
        this.title = title;
        this.comment = comment;
        this.assignees = assignees;
        this.labels = labels;
        this.milestoneId = milestoneId;
    }

    public static NewIssueDto from(NewIssue newIssue) {
        return new NewIssueDto(newIssue.getTitle(), newIssue.getComment(), AssigneesDto.from(newIssue.getAssignees()), LabelsDto.from(newIssue.getLabels()), newIssue.getMilestoneId());
    }

    public NewIssue toNewIssue() {
        return new NewIssue(title, comment, assignees.toAssignees(), labels.toLabels(), milestoneId);
    }

    public String getTitle() {
        return title;
    }

    public String getComment() {
        return comment;
    }

    public List<AssigneeDto> getAssignees() {
        return assignees.toList();
    }

    public List<LabelDto> getLabels() {
        return labels.toList();
    }

    public Long getMilestoneId() {
        return milestoneId;
    }
}
