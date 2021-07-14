package com.issuetracker.domain;

import org.springframework.data.annotation.Id;

public class Milestone {

    @Id
    private final Long id;

    private final Issues issues;

    private final MilestoneInfo milestoneInfo;

    public Milestone(Long id, Issues issues, MilestoneInfo milestoneInfo) {
        this.id = id;
        this.issues = issues;
        this.milestoneInfo = milestoneInfo;
    }

    public Long getId() {
        return id;
    }

    public MilestoneInfo getMilestoneInfo() {
        return milestoneInfo;
    }

    public Issues getIssues() {
        return issues;
    }
}
