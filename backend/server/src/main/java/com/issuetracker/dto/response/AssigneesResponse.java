package com.issuetracker.dto.response;

import com.issuetracker.domain.Assignees;

import java.util.List;
import java.util.stream.Collectors;

public class AssigneesResponse {
    private final List<AssigneeResponse> assinees;

    public AssigneesResponse(List<AssigneeResponse> assinees) {
        this.assinees = assinees;
    }

    public static AssigneesResponse from(Assignees assignees) {
        return new AssigneesResponse(assignees.toList().stream().map(AssigneeResponse::from).collect(Collectors.toList()));
    }

    public List<AssigneeResponse> getAssinees() {
        return assinees;
    }
}
