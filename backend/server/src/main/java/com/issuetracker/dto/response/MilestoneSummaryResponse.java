package com.issuetracker.dto.response;

import com.issuetracker.domain.Milestone;

import java.time.LocalDateTime;

public class MilestoneSummaryResponse {
    private final Long id;
    private final MilestoneInfoResponse milestoneInfoResponse;

    public MilestoneSummaryResponse(Long id, MilestoneInfoResponse milestoneInfoResponse) {
        this.id = id;
        this.milestoneInfoResponse = milestoneInfoResponse;
    }

    public static MilestoneSummaryResponse from(Milestone milestone) {
        return new MilestoneSummaryResponse(milestone.getId(), MilestoneInfoResponse.from(milestone.getMilestoneInfo()));
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return milestoneInfoResponse.getTitle();
    }

    public String getDescription() {
        return milestoneInfoResponse.getDescription();
    }

    public LocalDateTime getDueDate() {
        return milestoneInfoResponse.getDueDate();
    }
}
