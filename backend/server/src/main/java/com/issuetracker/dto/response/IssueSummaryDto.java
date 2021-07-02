package com.issuetracker.dto.response;

import com.issuetracker.domain.Issue;

import java.time.LocalDateTime;
import java.util.List;

import static com.issuetracker.dto.response.ResponseMapper.export;

public class IssueSummaryDto {
    private Long issueId;
    private MilestoneInfoDto milestoneInfo;
    private String title;
    private String content;
    private String status;
    private WriterDto writer;
    private LocalDateTime createdDateTime;
    private List<AssigneeDto> assignees;
    private List<LabelDto> labels;

    public static IssueSummaryDto from(Issue issue) {
        return new IssueSummaryDto(issue.getIssueId(),
                MilestoneInfoDto.from(issue.getMilestoneInfo()),
                issue.getTitle(),
                issue.getContent(),
                issue.getStatus().name(),
                WriterDto.from(issue.getWriter()),
                issue.getCreatedDateTime(),
                export(issue.getAssignees()),
                export(issue.getLabels())
        );
    }

    public IssueSummaryDto(Long issueId, MilestoneInfoDto milestoneInfo, String title, String content, String status, WriterDto writer, LocalDateTime createdDateTime, List<AssigneeDto> assignees, List<LabelDto> labels) {
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

    public MilestoneInfoDto getMilestoneInfo() {
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
        return assignees;
    }

    public List<LabelDto> getLabels() {
        return labels;
    }
}
