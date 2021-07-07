package com.issuetracker.dto.request;

public class UpdateIssueMilestoneRequest {
    private Long milestoneId;

    protected UpdateIssueMilestoneRequest() {}

    public UpdateIssueMilestoneRequest(Long milestoneId) {
        this.milestoneId = milestoneId;
    }

    public Long getMilestoneId() {
        return milestoneId;
    }
}
