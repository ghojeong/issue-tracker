package com.issuetracker.dto.response;

import com.issuetracker.domain.*;

import java.util.List;
import java.util.stream.Collectors;

public class ResponseMapper {
    private ResponseMapper() {}

    public static List<AssigneeDto> export(Assignees assignees) {
        return assignees.toList().stream()
                .map(AssigneeDto::from)
                .collect(Collectors.toList());
    }

    public static List<LabelDto> export(Labels labels) {
        return labels.toList().stream()
                .map(LabelDto::from)
                .collect(Collectors.toList());
    }

    public static List<CommentDto> export(Comments comments) {
        return comments.toList().stream()
                .map(CommentDto::from)
                .collect(Collectors.toList());
    }

    public static List<MilestoneSummaryDto> exportSummary(Milestones milestones) {
        return milestones.toList().stream()
                .map(MilestoneSummaryDto::from)
                .collect(Collectors.toList());
    }

    public static List<IssueSummaryDto> exportSummary(Issues issues) {
        return issues.toList().stream()
                .map(IssueSummaryDto::from)
                .collect(Collectors.toList());
    }
}
