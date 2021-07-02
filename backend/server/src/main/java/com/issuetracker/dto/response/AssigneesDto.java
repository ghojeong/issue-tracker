package com.issuetracker.dto.response;

import com.issuetracker.domain.Assignees;

import java.util.List;
import java.util.stream.Collectors;

public class AssigneesDto {
    private final List<AssigneeDto> assignees;

    public AssigneesDto(List<AssigneeDto> assignees) {
        this.assignees = assignees;
    }

    public static AssigneesDto from(Assignees assignees) {
        return new AssigneesDto(assignees.toList().stream()
                .map(AssigneeDto::from)
                .collect(Collectors.toList()));
    }

    public List<AssigneeDto> toList() {
        return assignees;
    }

    public Assignees toAssignees() {
        return new Assignees(assignees.stream()
                .map(AssigneeDto::toAssignee)
                .collect(Collectors.toList()));
    }
}
