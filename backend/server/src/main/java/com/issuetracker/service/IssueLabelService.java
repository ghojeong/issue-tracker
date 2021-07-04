package com.issuetracker.service;

import com.issuetracker.repository.IssueLabelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueLabelService {
    private final IssueLabelRepository issueLabelRepository;

    public IssueLabelService(IssueLabelRepository issueLabelRepository) {
        this.issueLabelRepository = issueLabelRepository;
    }

    public void save(Long issueId, List<Long> labelIds) {

        for (Long labelId : labelIds) {
            issueLabelRepository.save(issueId, labelId);
        }
    }
}
