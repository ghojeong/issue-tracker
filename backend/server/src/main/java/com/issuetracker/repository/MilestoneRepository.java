package com.issuetracker.repository;

import com.issuetracker.domain.*;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Collections;

import static com.issuetracker.repository.sql.MilestoneQueriesKt.*;

@Repository
public class MilestoneRepository {

    private final NamedParameterJdbcTemplate jdbc;
    private final IssueRepository issueRepository;

    public MilestoneRepository(NamedParameterJdbcTemplate jdbc, IssueRepository issueRepository) {
        this.jdbc = jdbc;
        this.issueRepository = issueRepository;
    }

    public Milestones findAllMilestoneInfo() {
        return new Milestones(jdbc.query(FIND_ALL_MILESTONE, Collections.emptyMap(), (rs, rowNum) -> {
            Timestamp dueDate = rs.getTimestamp("dueDate");
            MilestoneInfo milestoneInfo = new MilestoneInfo(
                    rs.getString("title"),
                    rs.getString("description"),
                    Status.from(rs.getString("statusId")),
                    dueDate != null ? dueDate.toLocalDateTime() : null);
            Long milestoneId = rs.getLong("id");
            Issues issues = issueRepository.findIssuesByMilestone(milestoneId);
            return new Milestone(milestoneId, issues, milestoneInfo);
        }));
    }

    public void save(MilestoneInfo milestoneInfo) {
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue("title", milestoneInfo.getTitle())
                .addValue("description", milestoneInfo.getDescription())
                .addValue("statusId", milestoneInfo.getStatus().name())
                .addValue("dueDate", milestoneInfo.getDueDate());
        jdbc.update(INSERT_MILESTONE, parameter);
    }

    public void update(Long milestoneId, MilestoneInfo milestoneInfo) {
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue("milestoneId", milestoneId)
                .addValue("title", milestoneInfo.getTitle())
                .addValue("description", milestoneInfo.getDescription());
        jdbc.update(UPDATE_MILESTONE, parameter);
    }

    public void delete(Long milestoneId) {
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue("milestoneId", milestoneId);
        jdbc.update(DELETE_MILESTONE, parameter);
    }
}
