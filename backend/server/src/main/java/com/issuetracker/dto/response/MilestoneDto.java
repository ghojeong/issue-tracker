package com.issuetracker.dto.response;

import com.issuetracker.domain.Milestone;

import java.util.List;

public class MilestoneDto {

    private final Long id;

    private final IssuesDto issues;

    private final MilestoneInfo milestoneInfo;

    public MilestoneDto(Long id, IssuesDto issues, MilestoneInfo milestoneInfo) {
        this.id = id;
        this.issues = issues;
        this.milestoneInfo = milestoneInfo;
    }

    public static MilestoneDto from(Milestone milestone) {
        return new MilestoneDto(milestone.getId(), IssuesDto.from(milestone.getIssues()), MilestoneInfo.from(milestone.getMilestoneInfo()));
    }

    public Long getId() {
        return id;
    }

    public List<IssueSummaryDto> getIssues() {
        return issues.getIssues();
    }

    public MilestoneInfo getMilestoneInfo() {
        return milestoneInfo;
    }
}
