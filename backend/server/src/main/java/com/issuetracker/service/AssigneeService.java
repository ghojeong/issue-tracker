package com.issuetracker.service;

import com.issuetracker.dto.response.AssigneesResponse;
import com.issuetracker.repository.AssigneeRepository;
import org.springframework.stereotype.Service;

@Service
public class AssigneeService {
    private final AssigneeRepository assigneeRepository;

    public AssigneeService(AssigneeRepository assigneeRepository) {
        this.assigneeRepository = assigneeRepository;
    }

    public AssigneesResponse getAllIssues() {
        return AssigneesResponse.from(assigneeRepository.getAllIssues());
    }
}
