package com.issuetracker.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class LabelNumbersRequest {

    @JsonProperty("labelIds")
    private List<Long> labelIds;

    public LabelNumbersRequest() {
    }

    public LabelNumbersRequest(List<Long> labelIds) {
        this.labelIds = labelIds;
    }

    public List<Long> getLabelIds() {
        return labelIds;
    }
}
