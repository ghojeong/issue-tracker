package com.issuetracker.service;

import com.issuetracker.dto.request.MilestoneRequest;
import com.issuetracker.dto.response.MilestonesResponse;
import com.issuetracker.repository.IssueRepository;
import com.issuetracker.repository.MilestoneRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.transaction.annotation.Isolation.REPEATABLE_READ;

@Service
public class MilestoneService {

    private final MilestoneRepository milestoneRepository;
    private final IssueRepository issueRepository;

    public MilestoneService(MilestoneRepository milestoneRepository, IssueRepository issueRepository) {
        this.milestoneRepository = milestoneRepository;
        this.issueRepository = issueRepository;
    }

    public MilestonesResponse findAll() {
        return MilestonesResponse.from(milestoneRepository.findAllMilestoneInfo());
    }

    public Long save(MilestoneRequest newMilestone) {
        return milestoneRepository.save(newMilestone.toMilestoneInfo());
    }

    public void update(Long milestoneId, MilestoneRequest newMilestone) {
        milestoneRepository.update(milestoneId, newMilestone.toMilestoneInfo());
    }

    @Transactional(isolation = REPEATABLE_READ)
    public void delete(Long milestoneId) {
        issueRepository.deleteMilestoneId(milestoneId);
        milestoneRepository.delete(milestoneId);
    }

    public void close(Long milestoneId) {
        milestoneRepository.close(milestoneId);
    }

    public void open(Long milestoneId) {
        milestoneRepository.open(milestoneId);
    }
}
