package com.issuetracker.dto.response;

import com.issuetracker.domain.Assignees;

import java.util.List;

import static com.issuetracker.dto.response.ResponseMapper.export;

public class AssigneesResponse {
    private final List<AssigneeResponse> assinees;

    public AssigneesResponse(List<AssigneeResponse> assinees) {
        this.assinees = assinees;
    }

    public static AssigneesResponse from(Assignees assignees) {
        return new AssigneesResponse(export(assignees));
    }

    public List<AssigneeResponse> getAssinees() {
        return assinees;
    }
}
