package com.issuetracker.dto.response;

import com.issuetracker.domain.Milestone;

import java.util.List;

import static com.issuetracker.dto.response.ResponseMapper.exportSummary;

public class MilestoneDto {
    private final Long id;
    private final List<IssueSummaryDto> issues;
    private final MilestoneInfoDto milestoneInfoDto;

    public MilestoneDto(Long id, List<IssueSummaryDto> issues, MilestoneInfoDto milestoneInfoDto) {
        this.id = id;
        this.issues = issues;
        this.milestoneInfoDto = milestoneInfoDto;
    }

    public static MilestoneDto from(Milestone milestone) {
        return new MilestoneDto(milestone.getId(), exportSummary(milestone.getIssues()), MilestoneInfoDto.from(milestone.getMilestoneInfo()));
    }

    public Long getId() {
        return id;
    }

    public List<IssueSummaryDto> getIssues() {
        return issues;
    }

    public MilestoneInfoDto getMilestoneInfo() {
        return milestoneInfoDto;
    }
}
