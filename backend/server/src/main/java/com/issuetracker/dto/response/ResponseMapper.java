package com.issuetracker.dto.response;

import com.issuetracker.domain.*;

import java.util.List;
import java.util.stream.Collectors;

public class ResponseMapper {
    private ResponseMapper() {}

    public static List<AssigneeResponse> export(Assignees assignees) {
        return assignees.toList().stream()
                .map(AssigneeResponse::from)
                .collect(Collectors.toList());
    }

    public static List<LabelResponse> export(Labels labels) {
        return labels.toList().stream()
                .map(LabelResponse::from)
                .collect(Collectors.toList());
    }

    public static List<CommentResponse> export(Comments comments) {
        return comments.toList().stream()
                .map(CommentResponse::from)
                .collect(Collectors.toList());
    }

    public static List<MilestoneSummaryResponse> exportSummary(Milestones milestones) {
        return milestones.toList().stream()
                .map(MilestoneSummaryResponse::from)
                .collect(Collectors.toList());
    }

    public static List<IssueSummaryResponse> exportSummary(Issues issues) {
        return issues.toList().stream()
                .map(IssueSummaryResponse::from)
                .collect(Collectors.toList());
    }
}
