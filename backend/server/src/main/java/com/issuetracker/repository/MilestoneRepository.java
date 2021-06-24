package com.issuetracker.repository;

import com.issuetracker.domain.*;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.issuetracker.repository.sql.MilestoneQueriesKt.FIND_ALL_MILESTONE;

@Repository
public class MilestoneRepository {

    private final NamedParameterJdbcTemplate jdbc;

    public MilestoneRepository(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Milestones findAllMilestoneInfo() {

        List<MilestoneInfo> milestonesInfo = jdbc.query(FIND_ALL_MILESTONE, Collections.emptyMap(), (rs, rowNum) -> new MilestoneInfo(
                rs.getString("title"),
                rs.getString("description"),
                Status.from(rs.getString("statusId")),
                rs.getTimestamp("dueDate").toLocalDateTime())
        );

        List<Milestone> milestoneList = new ArrayList<>();

        for (MilestoneInfo milestoneInfo : milestonesInfo) {
            milestoneList = jdbc.query(FIND_ALL_MILESTONE, Collections.emptyMap(), (rs, rowNum) -> new Milestone(
                    rs.getLong("id"),
                    new Issues(new ArrayList<>()),
                    milestoneInfo));
        }


        return new Milestones(milestoneList);
    }
}
