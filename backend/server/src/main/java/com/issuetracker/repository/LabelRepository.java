package com.issuetracker.repository;

import com.issuetracker.domain.Label;
import com.issuetracker.repository.mapper.LabelMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.issuetracker.repository.sql.LabelQueriesKt.*;

@Repository
public class LabelRepository {

    private NamedParameterJdbcTemplate jdbc;

    public LabelRepository(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Label> findAllByIssueId(Long issueId) {
        Map<String, Long> parameter = Collections.singletonMap("issueId", issueId);

        return jdbc.query(FIND_ALL_LABEL_BY_ISSUE_ID, parameter, new LabelMapper());
    }

    public List<Label> findAll() {
        return jdbc.query(FIND_ALL_LABEL, Collections.emptyMap(), new LabelMapper());
    }

    public void save(Label label) {
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue("title", label.getTitle())
                .addValue("description", label.getDescription())
                .addValue("backgroundColor", label.getBackgroundColor())
                .addValue("textColor", label.getTextColor());
        jdbc.update(INSERT_LABEL, parameter);
    }
}
