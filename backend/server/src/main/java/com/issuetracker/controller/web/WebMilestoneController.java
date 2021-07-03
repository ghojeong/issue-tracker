package com.issuetracker.controller.web;

import com.issuetracker.dto.request.NewMilestoneRequest;
import com.issuetracker.dto.response.MilestonesResponse;
import com.issuetracker.service.MilestoneService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/web/milestones")
public class WebMilestoneController {
    private final MilestoneService milestoneService;

    public WebMilestoneController(MilestoneService milestoneService) {
        this.milestoneService = milestoneService;
    }

    @GetMapping
    public MilestonesResponse getMilestoneList() {
        return milestoneService.findAll();
    }

    @PostMapping
    public void createMilestone(@RequestBody NewMilestoneRequest newMilestoneRequest) {
        milestoneService.save(newMilestoneRequest);
    }
}
