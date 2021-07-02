package com.issuetracker.dto.response;

import com.issuetracker.domain.Issue;

import java.time.LocalDateTime;
import java.util.List;

import static com.issuetracker.dto.response.ResponseMapper.export;

public class IssueSummaryResponse {
    private final Long issueId;
    private final MilestoneInfoResponse milestoneInfo;
    private final String title;
    private final String content;
    private final String status;
    private final WriterResponse writer;
    private final LocalDateTime createdDateTime;
    private final List<AssigneeResponse> assignees;
    private final List<LabelResponse> labels;

    public static IssueSummaryResponse from(Issue issue) {
        return new IssueSummaryResponse(issue.getIssueId(),
                MilestoneInfoResponse.from(issue.getMilestoneInfo()),
                issue.getTitle(),
                issue.getContent(),
                issue.getStatus().name(),
                WriterResponse.from(issue.getWriter()),
                issue.getCreatedDateTime(),
                export(issue.getAssignees()),
                export(issue.getLabels())
        );
    }

    public IssueSummaryResponse(Long issueId, MilestoneInfoResponse milestoneInfo, String title, String content, String status, WriterResponse writer, LocalDateTime createdDateTime, List<AssigneeResponse> assignees, List<LabelResponse> labels) {
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

    public MilestoneInfoResponse getMilestoneInfo() {
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

    public WriterResponse getWriter() {
        return writer;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public List<AssigneeResponse> getAssignees() {
        return assignees;
    }

    public List<LabelResponse> getLabels() {
        return labels;
    }
}
