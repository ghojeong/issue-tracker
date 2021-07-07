package com.issuetracker.repository;

import com.issuetracker.domain.*;
import com.issuetracker.domain.auth.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.issuetracker.repository.sql.AssigneeQueriesKt.*;
import static com.issuetracker.repository.sql.CommentQueriesKt.*;
import static com.issuetracker.repository.sql.IssueLabelQueriesKt.DELETE_ISSUE_LABEL;
import static com.issuetracker.repository.sql.IssueLabelQueriesKt.INSERT_ISSUE_LABEL;
import static com.issuetracker.repository.sql.IssueQueriesKt.*;
import static com.issuetracker.repository.sql.LabelQueriesKt.FIND_ALL_LABEL;
import static com.issuetracker.repository.sql.LabelQueriesKt.FIND_ALL_LABEL_BY_ISSUE_ID;
import static com.issuetracker.repository.sql.MilestoneQueriesKt.FIND_ALL_MILESTONE;
import static com.issuetracker.repository.sql.UserQueriesKt.FIND_ALL_USER;

@Repository
public class IssueRepository {

    private static final String ISSUE_SQL = "SELECT issue.id, issue.title, issue.content, issue.statusId, issue.createdDate, "
            + "user.id, user.avatarUrl, "
            + "milestone.title AS milestoneTitle, milestone.description AS milestoneDescription, milestone.statusId AS milestoneStatus, milestone.dueDate AS milestoneDueDate "
            + "FROM issue "
            + "INNER JOIN user ON issue.writerId = user.id "
            + "LEFT JOIN milestone ON issue.milestoneId = milestone.id ";

    private final NamedParameterJdbcTemplate jdbc;

    public IssueRepository(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Issues getIssues(User _, Status status) {
        if (status == Status.ALL) {
            return getAllIssues();
        }

        String sql = ISSUE_SQL + "WHERE issue.statusId = :statusId ";
        Map<String, String> params = Collections.singletonMap("statusId", status.name());

        return new Issues(jdbc.query(sql, params, issueMapper));
    }

    private Issues getAllIssues() {
        return new Issues(jdbc.query(ISSUE_SQL, Collections.emptyMap(), issueMapper));
    }

    private final RowMapper<Issue> issueMapper = (rs, rowNum) -> {
        Long issueId = rs.getLong("issue.id");

        Assignees assignees = getAssignees(issueId);
        Labels labels = getLabels(issueId);

        String milestoneTitle = rs.getString("milestoneTitle");
        MilestoneInfo milestoneInfo = milestoneTitle != null ? new MilestoneInfo(
                milestoneTitle,
                rs.getString("milestoneDescription"),
                Status.from(rs.getString("milestoneStatus")),
                rs.getTimestamp("milestoneDueDate").toLocalDateTime()
        ) : null;

        Writer writer = new Writer(rs.getString("user.id"), rs.getString("avatarUrl"));

        return new Issue(
                issueId,
                milestoneInfo,
                rs.getString("title"),
                rs.getString("content"),
                Status.from(rs.getString("statusId")),
                writer,
                rs.getTimestamp("createdDate").toLocalDateTime(),
                assignees,
                labels
        );
    };

    private Assignees getAssignees(Long issueId) {
        Map<String, Long> params = Collections.singletonMap("issueId", issueId);

        return new Assignees(jdbc.query(FIND_ALL_ASSIGNEE_BY_USER_ID, params, (rs, rowNum) -> {
            String id = rs.getString("id");
            String name = rs.getString("name");
            String avatarUrl = rs.getString("avatarUrl");
            return new Assignee(id, name, avatarUrl);
        }));
    }

    private Labels getLabels(Long issueId) {

        Map<String, Long> params = Collections.singletonMap("issueId", issueId);

        return new Labels(jdbc.query(FIND_ALL_LABEL_BY_ISSUE_ID, params, (rs, rowNum) -> {
            Long id = rs.getLong("id");
            String title = rs.getString("title");
            String description = rs.getString("description");
            String backgroundColor = rs.getString("backgroundColor");
            String textColor = rs.getString("textColor");
            return new Label(id, title, description, backgroundColor, textColor);
        }));
    }

    // 이슈의 status를 토글하는 기능을 만들고자 했음. on/off
    // DTO 나중에 없애기
    public void toggle(IssuesNumbers issueNumbers) {
    }

    public IssueOption findIssueOption() {

        //INFO. 궁금한 점. IssueRepository인데 Assignee이나 Label 등의 정보를 가져와도 되는지?

        List<Assignee> assigneeList = jdbc.query(FIND_ALL_USER, Collections.emptyMap(), (rs, rowNum) -> new Assignee(
                rs.getString("userId"),
                rs.getString("name"),
                rs.getString("avatarUrl")));

        Assignees assignees = new Assignees(assigneeList);


        List<Label> labelList = jdbc.query(FIND_ALL_LABEL, Collections.emptyMap(), (rs, rowNum) -> new Label(
                rs.getLong("id"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getString("backgroundColor"),
                rs.getString("textColor")
        ));

        Labels labels = new Labels(labelList);

        List<MilestoneInfo> milestoneInfoList = jdbc.query(FIND_ALL_MILESTONE, Collections.emptyMap(), (rs, rowNum) -> {
            Timestamp dueDate = rs.getTimestamp("dueDate");
            return new MilestoneInfo(
                    rs.getString("title"),
                    rs.getString("description"),
                    Status.from(rs.getString("statusId")),
                    dueDate != null ? dueDate.toLocalDateTime() : null
            );
        });


        //TODO. 마일스톤 id,와 issue를 또 한번 마일스톤을 돌아서 구할지?
        long cnt = 0L;

        Milestones milestones = new Milestones(new ArrayList<>());
        for (MilestoneInfo milestoneInfo : milestoneInfoList) {
            milestones.add(new Milestone(++cnt, new Issues(new ArrayList<>()), milestoneInfo));
        }

        return new IssueOption(assignees, labels, milestones);
    }

    public void save(String writerId, InsertIssue issue) {
        //TODO. null 분기처리를 하는게 뭔가 이상함....다른 방안이 필요함.
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue("title", issue.getTitle())
                .addValue("content", issue.getComment())
                .addValue("writerId", writerId)
                .addValue("statusId", "OPEN")
                .addValue("milestoneId", issue.getMilestoneId() != null ? issue.getMilestoneId() : null);
        jdbc.update(INSERT_ISSUE, parameter);

        Long issueId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Collections.emptyMap(), Long.class);
        updateAssigneesOfIssue(issueId, issue.getAssigneeIds());
        updateLabelsOfIssue(issueId, issue.getLabelIds());
    }

    public Issue findIssueById(Long issueId) {
        Map<String, Long> parameter = Collections.singletonMap("issueId", issueId);
        return jdbc.queryForObject(ISSUE_SQL + " WHERE issue.id = :issueId", parameter, issueMapper);
    }

    public Issues findIssuesByMilestone(Long milestoneId) {
        Map<String, Long> parameter = Collections.singletonMap("milestoneId", milestoneId);
        return new Issues(jdbc.query(ISSUE_SQL + " WHERE issue.milestoneId = :milestoneId", parameter, issueMapper));
    }

    public void addComment(String content, String writerId, Long issueId) {
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue("content", content)
                .addValue("writerId", writerId)
                .addValue("issueId", issueId);
        jdbc.update(INSERT_COMMENT, parameter);
    }

    public void updateComment(Long commentId, String content) {
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue("commentId", commentId)
                .addValue("content", content);
        jdbc.update(UPDATE_COMMENT, parameter);
    }

    public Comments findCommentsByIssueId(Long issueId) {

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

    public void updateIssue(UpdateIssue issue, Long issueId) {
        //TODO. null 분기처리를 하는게 뭔가 이상함....다른 방안이 필요함.
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue("title", issue.getTitle())
                .addValue("content", issue.getComment())
                .addValue("milestoneId", issue.getMilestoneId() != null ? issue.getMilestoneId() : null)
                .addValue("issueId", issueId);

        jdbc.update(UPDATE_ISSUE, parameter);
    }

    public void saveIssueLabel(Long issueId, Long labelId) {
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue("issueId", issueId)
                .addValue("labelId", labelId);
        jdbc.update(INSERT_ISSUE_LABEL, parameter);
    }

    public void updateAssigneesOfIssue(Long issueId, List<String> assigneeIds) {
        deleteAssignees(issueId);
        assigneeIds.forEach(assigneeId -> addAssignee(issueId, assigneeId));
    }

    private void deleteAssignees(Long issueId) {
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue("issueId", issueId);
        jdbc.update(DELETE_ASSIGNEE, parameter);
    }

    private void addAssignee(Long issueId, String assigneeId) {
        //TODO. batch insert 못하겠습니다..
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue("issueId", issueId)
                .addValue("assigneeId", assigneeId);
        jdbc.update(INSERT_ASSIGNEE, parameter);
    }

    public void updateLabelsOfIssue(Long issueId, List<Long> labelIds) {
        deleteLabelsOfIssue(issueId);
        labelIds.forEach(labelId -> addLabelOfIssue(issueId, labelId));
    }

    private void deleteLabelsOfIssue(Long issueId) {
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue("issueId", issueId);
        jdbc.update(DELETE_ISSUE_LABEL, parameter);
    }

    private void addLabelOfIssue(Long issueId, Long labelId) {
        //TODO. batch insert 못하겠습니다..
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue("issueId", issueId)
                .addValue("labelId", labelId);
        jdbc.update(INSERT_ISSUE_LABEL, parameter);
    }

    public Comment findCommentById(Long issueId, Long commentId) {
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue("issueId", issueId)
                .addValue("commentId", commentId);

        return jdbc.queryForObject(FIND_COMMENT, parameter, ((rs, rowNum) -> new Comment(
                rs.getLong("id"),
                rs.getLong("issueId"),
                new Writer(rs.getString("writerId"), null), // 댓글 조회에 profileImage는 굳이 필요 없는 거 같아서 null 처리
                rs.getString("content"),
                rs.getTimestamp("dateTime") != null ? rs.getTimestamp("dateTime").toLocalDateTime() : null
        )));
    }

    public void deleteComment(Long issueId, Long commentId) {
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue("issueId", issueId)
                .addValue("commentId", commentId);
        jdbc.update(DELETE_COMMENT, parameter);
    }


    public void deleteMilestoneId(Long milestoneId) {
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue("milestoneId", milestoneId);
        jdbc.update(DELETE_MILESTONE_OF_ISSUE, parameter);

    }
}
