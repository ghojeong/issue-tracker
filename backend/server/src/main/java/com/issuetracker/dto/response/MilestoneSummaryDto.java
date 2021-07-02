package com.issuetracker.dto.response;

import java.time.LocalDateTime;

public class MilestoneSummaryDto {

    private final Long id;

    private final MilestoneInfo milestoneInfo;

    public MilestoneSummaryDto(Long id, MilestoneInfo milestoneInfo) {
        this.id = id;
        this.milestoneInfo = milestoneInfo;
    }

    public static MilestoneSummaryDto from(MilestoneDto milestone) {
        return new MilestoneSummaryDto(milestone.getId(), milestone.getMilestoneInfo());
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return milestoneInfo.getTitle();
    }

    public String getDescription() {
        return milestoneInfo.getDescription();
    }

    public LocalDateTime getDueDate() {
        return milestoneInfo.getDueDate();
    }
}
