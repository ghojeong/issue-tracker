package com.issuetracker.dto.request;

import com.issuetracker.domain.MilestoneInfo;
import com.issuetracker.domain.Status;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class MilestoneRequest {

    @NotNull(message = "title이 NULL일 수 없습니다.")
    @NotBlank(message = "title이 공백일 수 없습니다.")
    private final String title;

    @NotNull(message = "description이 NULL일 수 없습니다.")
    @NotBlank(message = "description이 공백일 수 없습니다.")
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
