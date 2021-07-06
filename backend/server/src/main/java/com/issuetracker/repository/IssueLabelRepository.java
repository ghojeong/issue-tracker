package com.issuetracker.repository;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import static com.issuetracker.repository.sql.IssueLabelQueriesKt.DELETE_ISSUE_LABEL;
import static com.issuetracker.repository.sql.IssueLabelQueriesKt.INSERT_ISSUE_LABEL;

@Repository
public class IssueLabelRepository {
    private final NamedParameterJdbcTemplate jdbc;

    public IssueLabelRepository(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    //Q. 파라미터로 도메인이 아닌 변수로 받아도 괜찮을까?
    public void save(Long issueId, Long labelId) {
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue("issueId", issueId)
                .addValue("labelId", labelId);
        jdbc.update(INSERT_ISSUE_LABEL, parameter);
    }

    public void delete(Long labelId) {
        SqlParameterSource parameter = new MapSqlParameterSource().addValue("labelId", labelId);
        jdbc.update(DELETE_ISSUE_LABEL, parameter);
    }
}
