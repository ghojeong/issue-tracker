package com.issuetracker.domain;

import java.util.List;

public class Milestones {
    private final List<Milestone> milestones;

    public Milestones(List<Milestone> milestones) {
        this.milestones = milestones;
    }

    public void add(Milestone milestone) {
        milestones.add(milestone);
    }

    public List<Milestone> toList() {
        return milestones;
    }

}
