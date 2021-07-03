package com.issuetracker.repository;

import com.issuetracker.domain.Comment;
import com.issuetracker.domain.Comments;
import com.issuetracker.domain.Writer;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.issuetracker.repository.sql.CommentQueriesKt.FIND_ALL_COMMENT_BY_ISSUE_ID;

@Repository
public class CommentRepository {
    private final NamedParameterJdbcTemplate jdbc;

    public CommentRepository(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Comments findByIssueId(Long issueId) {

        Map<String, Long> params = Collections.singletonMap("issueId", issueId);

        List<Comment> commentList = jdbc.query(FIND_ALL_COMMENT_BY_ISSUE_ID, params, (rs, rowNum) -> {
            Writer writer = new Writer(rs.getString("name"), rs.getString("avatarUrl"));

            return new Comment(rs.getLong("id"),
                    rs.getLong("issueId"),
                    writer,
                    rs.getString("content"),
                    rs.getTimestamp("datetime").toLocalDateTime());
        });

        return new Comments(commentList);
    }
}
