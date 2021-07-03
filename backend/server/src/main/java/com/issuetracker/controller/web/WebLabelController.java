package com.issuetracker.controller.web;

import com.issuetracker.dto.request.LabelRequest;
import com.issuetracker.dto.response.LabelsResponse;
import com.issuetracker.service.LabelService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/web/labels")
public class WebLabelController {

    private final LabelService labelService;

    public WebLabelController(LabelService labelService) {
        this.labelService = labelService;
    }

    @GetMapping
    public LabelsResponse findLabels() {
        return labelService.findAll();
    }

    @PostMapping
    public void createLabel(@RequestBody LabelRequest labelRequest) {
        labelService.save(labelRequest);
    }
}
