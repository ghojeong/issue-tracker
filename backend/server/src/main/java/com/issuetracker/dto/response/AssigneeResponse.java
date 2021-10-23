package com.issuetracker.dto.response;

import com.issuetracker.domain.Assignee;

public class AssigneeResponse {
    private final String id;
    private final String name;
    private final String avatarUrl;

    public AssigneeResponse(String id, String name, String avatarUrl) {
        this.id = id;
        this.name = name;
        this.avatarUrl = avatarUrl;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public static AssigneeResponse from(Assignee assignee) {
        return new AssigneeResponse(assignee.getId(), assignee.getName(), assignee.getAvatarUrl());
    }

    public Assignee toAssignee() {
        return new Assignee(id, name, avatarUrl);
    }
}
