package com.issuetracker.dto.response;

import com.issuetracker.domain.Issues;

import java.util.List;
import java.util.stream.Collectors;

public class IssuesResponse {
    private final List<IssueSummaryResponse> issues;

    public IssuesResponse(List<IssueSummaryResponse> issues) {
        this.issues = issues;
    }

    public static IssuesResponse from(Issues issues) {
        return new IssuesResponse(issues.toList().stream()
                .map(IssueSummaryResponse::from)
                .collect(Collectors.toList()));
    }

    public List<IssueSummaryResponse> getIssues() {
        return issues;
    }
}
