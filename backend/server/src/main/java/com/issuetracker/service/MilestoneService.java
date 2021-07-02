package com.issuetracker.service;

import com.issuetracker.dto.response.MilestonesResponse;
import com.issuetracker.repository.MilestoneRepository;
import org.springframework.stereotype.Service;

@Service
public class MilestoneService {

    private final MilestoneRepository milestoneRepository;

    public MilestoneService(MilestoneRepository milestoneRepository) {
        this.milestoneRepository = milestoneRepository;
    }

    public MilestonesResponse findAll() {
        return MilestonesResponse.from(milestoneRepository.findAllMilestoneInfo());
    }

}
