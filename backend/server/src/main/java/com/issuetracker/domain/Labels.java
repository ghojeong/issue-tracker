package com.issuetracker.domain;

import java.util.ArrayList;
import java.util.List;

public class Labels {

    private final List<Label> labels;

    public Labels() {
        this(new ArrayList<>());
    }

    public Labels(List<Label> labels) {
        this.labels = labels;
    }

    public void add(Label label) {
        labels.add(label);
    }

    public List<Label> toList() {
        return labels;
    }

}
