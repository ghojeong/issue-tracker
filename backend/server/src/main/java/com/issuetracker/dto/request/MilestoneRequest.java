package com.issuetracker.dto.request;

import com.issuetracker.domain.MilestoneInfo;
import com.issuetracker.domain.Status;

public class MilestoneRequest {
    private final String title;
    private final String description;

    public MilestoneRequest(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public MilestoneInfo toMilestoneInfo() {
        return new MilestoneInfo(title, description, Status.OPEN, null);
    }
}
