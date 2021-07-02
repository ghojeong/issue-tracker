package com.issuetracker.dto.response;

import com.issuetracker.domain.Issue;
import com.issuetracker.domain.MilestoneInfo;

import java.time.LocalDateTime;
import java.util.List;

public class IssueSummaryDto {

    private Long issueId;

    private MilestoneInfo milestoneInfo;

    private String title;

    private String content;

    private String status;

    private WriterDto writer;

    private LocalDateTime createdDateTime;

    private AssigneesDto assignees;

    private LabelsDto labels;

    public static IssueSummaryDto from(Issue issue) {
        return new IssueSummaryDto(issue.getIssueId(), issue.getMilestoneInfo(), issue.getTitle(), issue.getContent(), issue.getStatus().name(), WriterDto.from(issue.getWriter()), issue.getCreatedDateTime(), AssigneesDto.from(issue.getAssignees()), LabelsDto.from(issue.getLabels()));
    }

    public IssueSummaryDto(Long issueId, MilestoneInfo milestoneInfo, String title, String content, String status, WriterDto writer, LocalDateTime createdDateTime, AssigneesDto assignees, LabelsDto labels) {
        this.issueId = issueId;
        this.milestoneInfo = milestoneInfo;
        this.title = title;
        this.content = content;
        this.status = status;
        this.writer = writer;
        this.createdDateTime = createdDateTime;
        this.assignees = assignees;
        this.labels = labels;
    }

    public Long getIssueId() {
        return issueId;
    }

    public MilestoneInfo getMilestoneInfo() {
        return milestoneInfo;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getStatus() {
        return status;
    }

    public WriterDto getWriter() {
        return writer;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public List<AssigneeDto> getAssignees() {
        return assignees.toList();
    }

    public List<LabelDto> getLabels() {
        return labels.getLabels();
    }
}
