package com.issuetracker.domain;

import java.util.ArrayList;
import java.util.List;

public class Issues {
    private final List<Issue> issues;

    public Issues() {
        this.issues = new ArrayList<>();
    }

    public Issues(List<Issue> issues) {
        this.issues = issues;
    }

    public void add(Issue issue) {
        issues.add(issue);
    }

    public List<Issue> toList() {
        return issues;
    }

}
