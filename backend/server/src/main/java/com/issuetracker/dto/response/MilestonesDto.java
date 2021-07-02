package com.issuetracker.dto.response;

import com.issuetracker.domain.Milestones;

import java.util.List;
import java.util.stream.Collectors;

public class MilestonesDto {

    private final List<MilestoneDto> milestones;

    public MilestonesDto(List<MilestoneDto> milestones) {
        this.milestones = milestones;
    }

    public static MilestonesDto from(Milestones milestones) {
        return new MilestonesDto(milestones.toList().stream().map(MilestoneDto::from).collect(Collectors.toList()));
    }

    public List<MilestoneDto> getMilestones() {
        return milestones;
    }
}
