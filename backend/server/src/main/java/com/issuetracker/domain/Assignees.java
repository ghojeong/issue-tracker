package com.issuetracker.domain;

import java.util.List;

public class Assignees {
    private final List<Assignee> assignees;

    public Assignees(List<Assignee> assignees) {
        this.assignees = assignees;
    }

    public List<Assignee> toList() {
        return assignees;
    }
}
