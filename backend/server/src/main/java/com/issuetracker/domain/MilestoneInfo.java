package com.issuetracker.domain;

import java.time.LocalDateTime;

public class MilestoneInfo {

    private final String title;

    private final String description;

    private final Status status;

    private final LocalDateTime dueDate;

    public MilestoneInfo(String title, String description, Status status, LocalDateTime dueDate) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.dueDate = dueDate;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }
}
