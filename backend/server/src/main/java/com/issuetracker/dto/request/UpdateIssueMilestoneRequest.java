package com.issuetracker.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class UpdateIssueMilestoneRequest {

    @PositiveOrZero(message = "milestoneId는 양수만 입력이 가능합니다.")
    @NotNull(message = "milestoneId은 null일 수 없습니다.")
    private Long milestoneId;

    protected UpdateIssueMilestoneRequest() {}

    public UpdateIssueMilestoneRequest(Long milestoneId) {
        this.milestoneId = milestoneId;
    }

    public Long getMilestoneId() {
        return milestoneId;
    }
}
