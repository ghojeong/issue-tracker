package com.issuetracker.dto.response;

import com.issuetracker.domain.MilestoneInfo;

import java.time.LocalDateTime;

public class MilestoneInfoResponse {
    private final String title;
    private final String description;
    private final String status;
    private final LocalDateTime dueDate;

    public MilestoneInfoResponse(String title, String description, String status, LocalDateTime dueDate) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.dueDate = dueDate;
    }

    public static MilestoneInfoResponse from(MilestoneInfo milestoneInfo) {
        if (milestoneInfo == null) {
            return null;
        }
        return new MilestoneInfoResponse(milestoneInfo.getTitle(), milestoneInfo.getDescription(), milestoneInfo.getStatus().name(), milestoneInfo.getDueDate());
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }
}
