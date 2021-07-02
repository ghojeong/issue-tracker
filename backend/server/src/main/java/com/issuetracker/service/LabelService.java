package com.issuetracker.service;

import com.issuetracker.dto.response.LabelResponse;
import com.issuetracker.dto.response.LabelsResponse;
import com.issuetracker.repository.LabelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LabelService {
    private final LabelRepository labelRepository;

    public LabelService(LabelRepository labelRepository) {
        this.labelRepository = labelRepository;
    }

    public LabelsResponse findAll() {
        List<LabelResponse> labels = labelRepository.findAll().stream().map(LabelResponse::from).collect(Collectors.toList());
        return new LabelsResponse(labels);
    }
}
