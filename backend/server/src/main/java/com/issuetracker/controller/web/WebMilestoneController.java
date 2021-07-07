package com.issuetracker.controller.web;

import com.issuetracker.dto.request.MilestoneRequest;
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
    public void createMilestone(@RequestBody MilestoneRequest milestoneRequest) {
        milestoneService.save(milestoneRequest);
    }

    @PutMapping("/{milestoneId}")
    public void updateMilestone(@PathVariable Long milestoneId, @RequestBody MilestoneRequest milestoneRequest) {
        milestoneService.update(milestoneId, milestoneRequest);
    }

    @DeleteMapping("/{milestoneId}")
    public void deleteMilestone(@PathVariable Long milestoneId) {
        milestoneService.delete(milestoneId);
    }

}
