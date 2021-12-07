package com.issuetracker.repository;

import com.issuetracker.domain.Assignee;
import com.issuetracker.domain.Assignees;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;

import static com.issuetracker.repository.sql.UserQueriesKt.FIND_ALL_USER;

@Repository
public class AssigneeRepository {

    private final NamedParameterJdbcTemplate jdbc;

    public AssigneeRepository(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Assignees getAllAssignees() {
        return new Assignees(jdbc.query(FIND_ALL_USER, Collections.emptyMap(), (rs, rowNum) -> new Assignee(
                rs.getString("userId"),
                rs.getString("name"),
                rs.getString("avatarUrl")
        )));
    }
}
