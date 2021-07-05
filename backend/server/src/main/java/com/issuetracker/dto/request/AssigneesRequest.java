package com.issuetracker.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AssigneesRequest {

    @JsonProperty("assigneeIds")
    private List<String> assigneeIds;

    protected AssigneesRequest() {
    }

    public AssigneesRequest(List<String> assigneeIds) {
        this.assigneeIds = assigneeIds;
    }

    public List<String> getAssigneeIds() {
        return assigneeIds;
    }
}
