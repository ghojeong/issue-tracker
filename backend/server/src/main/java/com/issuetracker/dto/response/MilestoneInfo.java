package com.issuetracker.dto.response;

import java.time.LocalDateTime;

public class MilestoneInfo {

    private String title;

    private String description;

    private String status;

    private LocalDateTime dueDate;

    public MilestoneInfo(String title, String description, String status, LocalDateTime dueDate) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.dueDate = dueDate;
    }

    public static MilestoneInfo from(com.issuetracker.domain.MilestoneInfo milestoneInfo) {
        return new MilestoneInfo(milestoneInfo.getTitle(), milestoneInfo.getDescription(), milestoneInfo.getStatus().name(), milestoneInfo.getDueDate());
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
