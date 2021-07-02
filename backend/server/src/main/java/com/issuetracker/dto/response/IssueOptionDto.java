package com.issuetracker.dto.response;

import com.issuetracker.domain.IssueOption;

import java.util.List;

import static com.issuetracker.dto.response.ResponseMapper.export;
import static com.issuetracker.dto.response.ResponseMapper.exportSummary;

//INFO, 새로운 이슈 작성할 때, [담당자, 레이블, 마일스톤] 보여주는 건대, 네이밍 변경이 필요해보임.
public class IssueOptionDto {
    private final List<AssigneeDto> assignees;
    private final List<LabelDto> labels;
    private final List<MilestoneSummaryDto> milestones;

    public IssueOptionDto(List<AssigneeDto> assignees, List<LabelDto> labels, List<MilestoneSummaryDto> milestones) {
        this.assignees = assignees;
        this.labels = labels;
        this.milestones = milestones;
    }

    public static IssueOptionDto from(IssueOption issueOption) {
        return new IssueOptionDto(export(issueOption.getAssignees()), export(issueOption.getLabels()), exportSummary(issueOption.getMilestones()));
    }

    public List<AssigneeDto> getAssignees() {
        return assignees;
    }

    public List<LabelDto> getLabels() {
        return labels;
    }

    public List<MilestoneSummaryDto> getMilestones() {
        return milestones;
    }
}
