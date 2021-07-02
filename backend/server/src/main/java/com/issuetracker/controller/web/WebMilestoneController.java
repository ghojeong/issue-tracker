package com.issuetracker.controller.web;

import com.issuetracker.dto.response.MilestonesDto;
import com.issuetracker.service.MilestoneService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/web")
public class WebMilestoneController {

    private final MilestoneService milestoneService;

    public WebMilestoneController(MilestoneService milestoneService) {
        this.milestoneService = milestoneService;
    }

    @GetMapping("/milestones")
    public MilestonesDto getMilestoneList() {
        return milestoneService.findAll();
    }

}
