package com.issuetracker.dto.request;

import com.issuetracker.domain.MilestoneInfo;
import com.issuetracker.domain.Status;

import java.time.LocalDateTime;

public class MilestoneRequest {
    private final String title;
    private final String description;
    private final LocalDateTime dueDate;

    public MilestoneRequest(String title, String description, LocalDateTime dueDate) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public MilestoneInfo toMilestoneInfo() {
        return new MilestoneInfo(title, description, Status.OPEN, dueDate);
    }
}
