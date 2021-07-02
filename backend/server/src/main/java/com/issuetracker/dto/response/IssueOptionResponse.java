package com.issuetracker.dto.response;

import com.issuetracker.domain.IssueOption;

import java.util.List;

import static com.issuetracker.dto.response.ResponseMapper.export;
import static com.issuetracker.dto.response.ResponseMapper.exportSummary;

//INFO, 새로운 이슈 작성할 때, [담당자, 레이블, 마일스톤] 보여주는 건대, 네이밍 변경이 필요해보임.
public class IssueOptionResponse {
    private final List<AssigneeResponse> assignees;
    private final List<LabelResponse> labels;
    private final List<MilestoneSummaryResponse> milestones;

    public IssueOptionResponse(List<AssigneeResponse> assignees, List<LabelResponse> labels, List<MilestoneSummaryResponse> milestones) {
        this.assignees = assignees;
        this.labels = labels;
        this.milestones = milestones;
    }

    public static IssueOptionResponse from(IssueOption issueOption) {
        return new IssueOptionResponse(export(issueOption.getAssignees()), export(issueOption.getLabels()), exportSummary(issueOption.getMilestones()));
    }

    public List<AssigneeResponse> getAssignees() {
        return assignees;
    }

    public List<LabelResponse> getLabels() {
        return labels;
    }

    public List<MilestoneSummaryResponse> getMilestones() {
        return milestones;
    }
}
