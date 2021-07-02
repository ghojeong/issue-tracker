package com.issuetracker.dto.response;

import com.issuetracker.domain.MilestoneInfo;

import java.time.LocalDateTime;

public class MilestoneInfoDto {
    private String title;
    private String description;
    private String status;
    private LocalDateTime dueDate;

    public MilestoneInfoDto(String title, String description, String status, LocalDateTime dueDate) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.dueDate = dueDate;
    }

    public static MilestoneInfoDto from(MilestoneInfo milestoneInfo) {
        return new MilestoneInfoDto(milestoneInfo.getTitle(), milestoneInfo.getDescription(), milestoneInfo.getStatus().name(), milestoneInfo.getDueDate());
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
