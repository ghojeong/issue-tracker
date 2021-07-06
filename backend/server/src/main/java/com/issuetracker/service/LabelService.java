package com.issuetracker.service;

import com.issuetracker.dto.request.LabelRequest;
import com.issuetracker.dto.response.LabelResponse;
import com.issuetracker.dto.response.LabelsResponse;
import com.issuetracker.exception.MaxLengthException;
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

    public void save(LabelRequest labelRequest) {
        if (labelRequest.getBackgroundColor().length() > 8 || labelRequest.getTextColor().length() > 8) {
            throw new MaxLengthException("Hex color codes 길이를 초과했습니다. (#000000 ~ #FFFFFF)");
        }
        labelRepository.save(labelRequest.toLabel());
    }

    public void update(Long labelId, LabelRequest labelRequest) {
        labelRepository.update(labelId, labelRequest.toLabel());
    }
}
