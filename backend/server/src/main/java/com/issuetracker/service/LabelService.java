package com.issuetracker.service;

import com.issuetracker.dto.response.LabelDto;
import com.issuetracker.dto.response.LabelsDto;
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

    public LabelsDto findAll() {
        List<LabelDto> labels = labelRepository.findAll().stream().map(LabelDto::from).collect(Collectors.toList());
        return new LabelsDto(labels);
    }
}
