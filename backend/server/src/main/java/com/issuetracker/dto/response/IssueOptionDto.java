package com.issuetracker.dto.response;

import com.issuetracker.domain.IssueOption;

import java.util.List;
import java.util.stream.Collectors;

//INFO, 새로운 이슈 작성할 때, [담당자, 레이블, 마일스톤] 보여주는 건대, 네이밍 변경이 필요해보임.
public class IssueOptionDto {

    private final AssigneesDto assigneesDto;

    private final LabelsDto labelsDto;

    private final MilestonesDto milestonesDto;

    public static IssueOptionDto from(IssueOption issueOption) {
        return new IssueOptionDto(AssigneesDto.from(issueOption.getAssignees()), LabelsDto.from(issueOption.getLabels()), MilestonesDto.from(issueOption.getMilestones()));
    }

    public IssueOptionDto(AssigneesDto assigneesDto, LabelsDto labelsDto, MilestonesDto milestonesDto) {
        this.assigneesDto = assigneesDto;
        this.labelsDto = labelsDto;
        this.milestonesDto = milestonesDto;
    }

    public List<AssigneeDto> getAssignees() {
        return assigneesDto.toList();
    }

    public List<LabelDto> getLabels() {
        return labelsDto.getLabels();
    }

    public List<MilestoneSummaryDto> getMilestones() {
        return milestonesDto.getMilestones()
                .stream().map(MilestoneSummaryDto::from)
                .collect(Collectors.toList());
    }
}
