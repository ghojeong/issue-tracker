package com.issuetracker.controller.web;

import com.issuetracker.dto.response.LabelsResponse;
import com.issuetracker.service.LabelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/web")
public class WebLabelController {

    private final LabelService labelService;

    public WebLabelController(LabelService labelService) {
        this.labelService = labelService;
    }

    @GetMapping("/labels")
    public LabelsResponse findLabels() {
        return labelService.findAll();
    }

}
