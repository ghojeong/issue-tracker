package com.issuetracker.service;

import com.issuetracker.dto.response.MilestonesDto;
import com.issuetracker.repository.MilestoneRepository;
import org.springframework.stereotype.Service;

@Service
public class MilestoneService {

    private final MilestoneRepository milestoneRepository;

    public MilestoneService(MilestoneRepository milestoneRepository) {
        this.milestoneRepository = milestoneRepository;
    }

    public MilestonesDto findAll() {
        return MilestonesDto.from(milestoneRepository.findAllMilestoneInfo());
    }

}
