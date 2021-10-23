package com.issuetracker.controller.web;

import com.issuetracker.dto.request.LabelRequest;
import com.issuetracker.dto.response.LabelsResponse;
import com.issuetracker.service.LabelService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public Long createLabel(@RequestBody LabelRequest labelRequest) {
        return labelService.save(labelRequest);
    }

    @PutMapping("/{labelId}")
    public void updateLabel(@PathVariable Long labelId, @Valid @RequestBody LabelRequest labelRequest) {
        labelService.update(labelId, labelRequest);
    }

    @DeleteMapping("/{labelId}")
    public void deleteLabel(@PathVariable Long labelId) {
        labelService.delete(labelId);
    }
}
