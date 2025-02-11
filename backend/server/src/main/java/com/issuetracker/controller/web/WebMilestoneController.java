package com.issuetracker.controller.web;

import com.issuetracker.dto.request.MilestoneRequest;
import com.issuetracker.dto.response.MilestonesResponse;
import com.issuetracker.service.MilestoneService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public void createMilestone(@Valid @RequestBody MilestoneRequest milestoneRequest) {
        milestoneService.save(milestoneRequest);
    }

    @PutMapping("/{milestoneId}")
    public void updateMilestone(@PathVariable Long milestoneId, @Valid @RequestBody MilestoneRequest milestoneRequest) {
        milestoneService.update(milestoneId, milestoneRequest);
    }

    @DeleteMapping("/{milestoneId}")
    public void deleteMilestone(@PathVariable Long milestoneId) {
        milestoneService.delete(milestoneId);
    }

    @PutMapping("/{milestoneId}/close")
    public void closeMilestone(@PathVariable Long milestoneId) {
        milestoneService.close(milestoneId);
    }

    @PutMapping("/{milestoneId}/open")
    public void openMilestone(@PathVariable Long milestoneId) {
        milestoneService.open(milestoneId);
    }

}
