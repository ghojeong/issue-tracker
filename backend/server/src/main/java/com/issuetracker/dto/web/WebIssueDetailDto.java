package com.issuetracker.dto.web;

import com.issuetracker.domain.DetailedComment;
import com.issuetracker.domain.Issue;
import com.issuetracker.domain.MilestoneInfo;
import com.issuetracker.dto.IssueStatusDto;
import com.issuetracker.dto.auth.UserDto;

import java.time.LocalDateTime;
import java.util.List;

public class WebIssueDetailDto {

    private Long issueId;

    private MilestoneInfo milestoneInfo;

    private String title;

    private String content;

    private IssueStatusDto status;

    private UserDto writer;

    private LocalDateTime createdDateTime;

    private WebAssigneesDto assignees;

    private WebLabelsDto labels;

    private WebCommentsDto comments;

    public static WebIssueDetailDto from(Issue issue, List<DetailedComment> comments) {
        return new WebIssueDetailDto(issue.getIssueId(), issue.getMilestoneInfo(), issue.getTitle(), issue.getContent(), IssueStatusDto.from(issue.getStatus()), UserDto.from(issue.getWriter()), issue.getCreatedDateTime(), WebAssigneesDto.from(issue.getAssignees()), WebLabelsDto.from(issue.getLabels()), WebCommentsDto.from(comments));
    }

    public WebIssueDetailDto(Long issueId, MilestoneInfo milestoneInfo, String title, String content, IssueStatusDto status, UserDto writer, LocalDateTime createdDateTime, WebAssigneesDto assignees, WebLabelsDto labels, WebCommentsDto comments) {
        this.issueId = issueId;
        this.milestoneInfo = milestoneInfo;
        this.title = title;
        this.content = content;
        this.status = status;
        this.writer = writer;
        this.createdDateTime = createdDateTime;
        this.assignees = assignees;
        this.labels = labels;
        this.comments = comments;
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

    public IssueStatusDto getStatus() {
        return status;
    }

    public UserDto getWriter() {
        return writer;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public WebAssigneesDto getAssignees() {
        return assignees;
    }

    public WebLabelsDto getLabels() {
        return labels;
    }

    public WebCommentsDto getComments() {
        return comments;
    }
}
