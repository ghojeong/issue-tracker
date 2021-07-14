package com.issuetracker.domain;

public class IssueOption {

    private final Assignees assignees;

    private final Labels labels;

    private final Milestones milestones;

    public IssueOption(Assignees assignees, Labels labels, Milestones milestones) {
        this.assignees = assignees;
        this.labels = labels;
        this.milestones = milestones;
    }

    public Assignees getAssignees() {
        return assignees;
    }

    public Labels getLabels() {
        return labels;
    }

    public Milestones getMilestones() {
        return milestones;
    }
}
