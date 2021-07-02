package com.issuetracker.dto.response;

import com.issuetracker.domain.Issues;

import java.util.List;
import java.util.stream.Collectors;

public class IssuesDto {
    private final List<IssueSummaryDto> issues;

    public IssuesDto(List<IssueSummaryDto> issues) {
        this.issues = issues;
    }

    public static IssuesDto from(Issues issues) {
        return new IssuesDto(issues.toList().stream()
                .map(IssueSummaryDto::from)
                .collect(Collectors.toList()));
    }

    public List<IssueSummaryDto> getIssues() {
        return issues;
    }
}
