package com.issuetracker.dto.response;

import com.issuetracker.domain.Labels;

import java.util.List;
import java.util.stream.Collectors;

public class LabelsDto {

    private final List<LabelDto> labels;

    public LabelsDto(List<LabelDto> labels) {
        this.labels = labels;
    }

    public static LabelsDto from(Labels labels) {
        return new LabelsDto(labels.toList().stream().map(LabelDto::from).collect(Collectors.toList()));
    }

    public List<LabelDto> toList() {
        return labels;
    }

    public Labels toLabels() {
        return new Labels(labels.stream()
                .map(LabelDto::toLabel)
                .collect(Collectors.toList()));
    }

    public List<LabelDto> getLabels() {
        return labels;
    }
}
