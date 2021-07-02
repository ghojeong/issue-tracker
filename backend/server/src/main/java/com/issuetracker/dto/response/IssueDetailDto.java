package com.issuetracker.dto.response;

import com.issuetracker.domain.Comments;
import com.issuetracker.domain.Issue;

import java.time.LocalDateTime;
import java.util.List;

import static com.issuetracker.dto.response.ResponseMapper.export;

public class IssueDetailDto {
    private Long issueId;
    private MilestoneInfoDto milestoneInfo;
    private String title;
    private String content;
    private String status;
    private WriterDto writer;
    private LocalDateTime createdDateTime;
    private List<AssigneeDto> assignees;
    private List<LabelDto> labels;
    private List<CommentDto> comments;

    public static IssueDetailDto from(Issue issue, Comments comments) {
        return new IssueDetailDto(issue.getIssueId(),
                MilestoneInfoDto.from(issue.getMilestoneInfo()),
                issue.getTitle(),
                issue.getContent(),
                issue.getStatus().name(),
                WriterDto.from(issue.getWriter()),
                issue.getCreatedDateTime(),
                export(issue.getAssignees()),
                export(issue.getLabels()),
                export(comments)
        );
    }

    public IssueDetailDto(Long issueId, MilestoneInfoDto milestoneInfo, String title, String content, String status, WriterDto writer, LocalDateTime createdDateTime, List<AssigneeDto> assignees, List<LabelDto> labels, List<CommentDto> comments) {
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

    public List<CommentDto> getComments() {
        return comments;
    }
}
