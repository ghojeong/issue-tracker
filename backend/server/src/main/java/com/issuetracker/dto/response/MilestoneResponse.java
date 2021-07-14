package com.issuetracker.dto.response;

import com.issuetracker.domain.Milestone;

import java.util.List;

import static com.issuetracker.dto.response.ResponseMapper.exportSummary;

public class MilestoneResponse {
    private final Long id;
    private final List<IssueSummaryResponse> issues;
    private final MilestoneInfoResponse milestoneInfoResponse;

    public MilestoneResponse(Long id, List<IssueSummaryResponse> issues, MilestoneInfoResponse milestoneInfoResponse) {
        this.id = id;
        this.issues = issues;
        this.milestoneInfoResponse = milestoneInfoResponse;
    }

    public static MilestoneResponse from(Milestone milestone) {
        return new MilestoneResponse(milestone.getId(), exportSummary(milestone.getIssues()), MilestoneInfoResponse.from(milestone.getMilestoneInfo()));
    }

    public Long getId() {
        return id;
    }

    public List<IssueSummaryResponse> getIssues() {
        return issues;
    }

    public MilestoneInfoResponse getMilestoneInfo() {
        return milestoneInfoResponse;
    }
}
