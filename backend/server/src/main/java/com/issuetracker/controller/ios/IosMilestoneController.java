package com.issuetracker.controller.ios;

import com.issuetracker.dto.response.MilestonesResponse;
import com.issuetracker.service.MilestoneService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ios")
public class IosMilestoneController {

    private final MilestoneService milestoneService;

    public IosMilestoneController(MilestoneService milestoneService) {
        this.milestoneService = milestoneService;
    }

    @GetMapping("/milestones")
    public MilestonesResponse getMilestoneList() {
        return milestoneService.findAll();
    }

}
