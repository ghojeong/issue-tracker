package com.issuetracker.dto.response;

import com.issuetracker.domain.Labels;

import java.util.List;
import java.util.stream.Collectors;

public class LabelsResponse {
    private final List<LabelResponse> labels;

    public LabelsResponse(List<LabelResponse> labels) {
        this.labels = labels;
    }

    public static LabelsResponse from(Labels labels) {
        return new LabelsResponse(labels.toList().stream().map(LabelResponse::from).collect(Collectors.toList()));
    }

    public List<LabelResponse> toList() {
        return labels;
    }

    public Labels toLabels() {
        return new Labels(labels.stream()
                .map(LabelResponse::toLabel)
                .collect(Collectors.toList()));
    }

    public List<LabelResponse> getLabels() {
        return labels;
    }
}
