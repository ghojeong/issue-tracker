package com.issuetracker.dto.response;

import com.issuetracker.domain.Milestones;

import java.util.List;
import java.util.stream.Collectors;

public class MilestonesResponse {
    private final List<MilestoneResponse> milestones;

    public MilestonesResponse(List<MilestoneResponse> milestones) {
        this.milestones = milestones;
    }

    public static MilestonesResponse from(Milestones milestones) {
        return new MilestonesResponse(milestones.toList().stream().map(MilestoneResponse::from).collect(Collectors.toList()));
    }

    public List<MilestoneResponse> getMilestones() {
        return milestones;
    }
}
