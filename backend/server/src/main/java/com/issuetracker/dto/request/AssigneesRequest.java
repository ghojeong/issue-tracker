package com.issuetracker.dto.request;

import java.util.List;

public class AssigneesRequest {
    private List<String> assigneeIds;

    protected AssigneesRequest() {}

    public AssigneesRequest(List<String> assigneeIds) {
        this.assigneeIds = assigneeIds;
    }

    public List<String> getAssigneeIds() {
        return assigneeIds;
    }
}
