package com.issuetracker.controller.web;

import com.issuetracker.dto.response.AssigneesResponse;
import com.issuetracker.service.AssigneeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/web/assignees")
public class WebAssigneeController {

    private final AssigneeService assigneeService;

    public WebAssigneeController(AssigneeService assigneeService) {
        this.assigneeService = assigneeService;
    }

    @GetMapping
    public AssigneesResponse getAllIssues() {
        return assigneeService.getAllIssues();
    }

}
