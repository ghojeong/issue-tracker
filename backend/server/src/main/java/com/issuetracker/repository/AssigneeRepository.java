package com.issuetracker.repository;

import com.issuetracker.domain.Assignee;
import com.issuetracker.domain.Assignees;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.Map;

import static com.issuetracker.repository.sql.AssigneeQueriesKt.FIND_ALL_ASSIGNEE_BY_USER_ID;
import static com.issuetracker.repository.sql.AssigneeQueriesKt.INSERT_ASSIGNEE;

@Repository
public class AssigneeRepository {
    private final NamedParameterJdbcTemplate jdbc;

    public AssigneeRepository(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    //TODO. issueRepository 안에  private Assignees getAssignees(Long issueId)가 있는데 옮겨야 하지 않을까?
    //일단 양쪽에 중복으로 존재하는데, 아래 로직을 사용하는 곳은 없음.
    // IssueRepository에서 Assignee이 필요한대, 어떻게 꺼내올지가 고민이다..서비스를 선언해도 될지..흐음....
    public Assignees getAssignees(Long issueId) {
        Map<String, Long> params = Collections.singletonMap("issueId", issueId);

        return new Assignees(jdbc.query(FIND_ALL_ASSIGNEE_BY_USER_ID, params, (rs, rowNum) -> {
            String id = rs.getString("id");
            String name = rs.getString("name");
            String avatarUrl = rs.getString("avatarUrl");
            return new Assignee(id, name, avatarUrl);
        }));
    }

    //Q. 파라미터로 도메인이 아닌 변수로 받아도 괜찮을까?
    public void save(Long issueId, String assigneeId) {
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue("issueId", issueId)
                .addValue("assigneeId", assigneeId);

        jdbc.update(INSERT_ASSIGNEE, parameter);
    }

}
