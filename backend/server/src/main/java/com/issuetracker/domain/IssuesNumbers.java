package com.issuetracker.domain;

import java.util.List;

public class IssuesNumbers {
    private final List<Long> issueNumbers;

    public IssuesNumbers(List<Long> issueNumbers) {
        this.issueNumbers = issueNumbers;
    }

    public List<Long> toList() {
        return issueNumbers;
    }
}
