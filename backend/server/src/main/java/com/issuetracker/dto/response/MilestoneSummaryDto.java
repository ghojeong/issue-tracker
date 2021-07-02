package com.issuetracker.dto.response;

import com.issuetracker.domain.Milestone;

import java.time.LocalDateTime;

public class MilestoneSummaryDto {
    private final Long id;
    private final MilestoneInfoDto milestoneInfoDto;

    public MilestoneSummaryDto(Long id, MilestoneInfoDto milestoneInfoDto) {
        this.id = id;
        this.milestoneInfoDto = milestoneInfoDto;
    }

    public static MilestoneSummaryDto from(Milestone milestone) {
        return new MilestoneSummaryDto(milestone.getId(), MilestoneInfoDto.from(milestone.getMilestoneInfo()));
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return milestoneInfoDto.getTitle();
    }

    public String getDescription() {
        return milestoneInfoDto.getDescription();
    }

    public LocalDateTime getDueDate() {
        return milestoneInfoDto.getDueDate();
    }
}
