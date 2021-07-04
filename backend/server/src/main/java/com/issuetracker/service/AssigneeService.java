package com.issuetracker.service;

import com.issuetracker.domain.Assignees;
import com.issuetracker.repository.AssigneeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssigneeService {

    private final AssigneeRepository assigneeRepository;

    public AssigneeService(AssigneeRepository assigneeRepository) {
        this.assigneeRepository = assigneeRepository;
    }

    private Assignees getAssignees(Long issueId) {
        return assigneeRepository.getAssignees(issueId);
    }

    public void save(Long issueId, List<String> assigneesId) {
        for (String assigneeId : assigneesId) {
            assigneeRepository.save(issueId, assigneeId);
        }
    }
}
