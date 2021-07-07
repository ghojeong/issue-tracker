package com.issuetracker.service;

import com.issuetracker.dto.request.LabelRequest;
import com.issuetracker.dto.response.LabelResponse;
import com.issuetracker.dto.response.LabelsResponse;
import com.issuetracker.repository.IssueLabelRepository;
import com.issuetracker.repository.LabelRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.transaction.annotation.Isolation.REPEATABLE_READ;

@Service
public class LabelService {
    private final LabelRepository labelRepository;
    private final IssueLabelRepository issueLabelRepository;

    public LabelService(LabelRepository labelRepository, IssueLabelRepository issueLabelRepository) {
        this.labelRepository = labelRepository;
        this.issueLabelRepository = issueLabelRepository;
    }

    public LabelsResponse findAll() {
        List<LabelResponse> labels = labelRepository.findAll().stream().map(LabelResponse::from).collect(Collectors.toList());
        return new LabelsResponse(labels);
    }

    public void save(LabelRequest labelRequest) {
        labelRepository.save(labelRequest.toLabel());
    }

    public void update(Long labelId, LabelRequest labelRequest) {
        labelRepository.update(labelId, labelRequest.toLabel());
    }

    @Transactional(isolation = REPEATABLE_READ)
    public void delete(Long labelId) {
        issueLabelRepository.delete(labelId);
        labelRepository.delete(labelId);
    }
}
