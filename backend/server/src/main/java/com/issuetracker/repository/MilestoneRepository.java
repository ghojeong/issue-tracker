package com.issuetracker.repository;

import com.issuetracker.domain.*;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Arrays;

@Repository
public class MilestoneRepository {
    public Milestones findAll() {

        MilestoneInfo milestoneInfo = new MilestoneInfo("마일스톤 제목1", "마일스톤 내용1", Status.OPEN, LocalDateTime.now());
        MilestoneInfo milestoneInfo2 = new MilestoneInfo("마일스톤 제목2", "마일스톤 내용2", Status.CLOSE, LocalDateTime.now());


        Writer writer = new Writer("네오", "http://testProfile.image.url");

        Assignees assignees = new Assignees(Arrays.asList(
                new Assignee("noel", "노을", "http://testProfile.image.url"),
                new Assignee("pyro", "파이로", "http://testProfile.image.url")
        ));

        Labels labels = new Labels();
        labels.add(new Label(1L, "라벨 타이틀4", "라벨 설명1", "#FF0000", "#000000"));
        labels.add(new Label(2L, "라벨 타이틀5", "라벨 설명2", "#FF0000", "#000000"));
        labels.add(new Label(3L, "라벨 타이틀6", "라벨 설명3", "#FF0000", "#000000"));

        Issues issues = new Issues();
        issues.add(new Issue(2L, milestoneInfo, "열린 이슈 타이틀1", "열린 이슈 설명1", Status.from("open"), writer, LocalDateTime.now(), assignees, labels));
        issues.add(new Issue(5L, milestoneInfo, "열린 이슈 타이틀2", "열린 이슈 설명1", Status.from("open"), writer, LocalDateTime.now(), assignees, labels));
        issues.add(new Issue(6L, milestoneInfo, "열린 이슈 타이틀3", "열린 이슈 설명1", Status.from("open"), writer, LocalDateTime.now(), assignees, labels));
        issues.add(new Issue(7L, milestoneInfo2, "열린 이슈 타이틀4", "열린 이슈 설명2", Status.from("open"), writer, LocalDateTime.now(), assignees, labels));

        Milestones milestones = new Milestones();
        milestones.add(new Milestone(1L, issues, milestoneInfo));
        milestones.add(new Milestone(2L, issues, milestoneInfo2));

        return milestones;
    }
}
