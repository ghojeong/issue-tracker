package com.issuetracker.repository;

import com.issuetracker.domain.*;
import com.issuetracker.domain.auth.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.*;

import static com.issuetracker.repository.sql.AssigneeQueriesKt.*;
import static com.issuetracker.repository.sql.CommentQueriesKt.*;
import static com.issuetracker.repository.sql.IssueLabelQueriesKt.DELETE_ISSUE_LABEL_BY_ISSUE_ID;
import static com.issuetracker.repository.sql.IssueLabelQueriesKt.INSERT_ISSUE_LABEL;
import static com.issuetracker.repository.sql.IssueQueriesKt.*;
import static com.issuetracker.repository.sql.LabelQueriesKt.FIND_ALL_LABEL;
import static com.issuetracker.repository.sql.LabelQueriesKt.FIND_ALL_LABEL_BY_ISSUE_ID;
import static com.issuetracker.repository.sql.MilestoneQueriesKt.FIND_ALL_MILESTONE;
import static com.issuetracker.repository.sql.UserQueriesKt.FIND_ALL_USER;
import static com.issuetracker.util.TimestampUtil.toLocalDateTime;

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
                toLocalDateTime(rs.getTimestamp("milestoneDueDate"))
        ) : null;

        Writer writer = new Writer(rs.getString("user.id"), rs.getString("avatarUrl"));
        return new Issue(
                issueId,
                milestoneInfo,
                rs.getString("title"),
                rs.getString("content"),
                Status.from(rs.getString("statusId")),
                writer,
                toLocalDateTime(rs.getTimestamp("createdDate")),
                assignees,
                labels
        );
    };

    private Assignees getAssignees(Long issueId) {
        Map<String, Long> params = Collections.singletonMap("issueId", issueId);
        return new Assignees(jdbc.query(FIND_ALL_ASSIGNEE_BY_USER_ID, params, (rs, rowNum) -> new Assignee(
                rs.getString("id"),
                rs.getString("name"),
                rs.getString("avatarUrl"))));
    }

    private Labels getLabels(Long issueId) {
        Map<String, Long> params = Collections.singletonMap("issueId", issueId);
        return new Labels(jdbc.query(FIND_ALL_LABEL_BY_ISSUE_ID, params, (rs, rowNum) -> new Label(
                rs.getLong("id"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getString("backgroundColor"),
                rs.getString("textColor"))));
    }

    public void closeIssue(IssuesNumbers issueNumbers) {
        for (Long issueId : issueNumbers.toList()) {
            Map<String, Long> parameter = Collections.singletonMap("issueId", issueId);
            Issue issue = jdbc.queryForObject(ISSUE_SQL + " WHERE issue.id = :issueId", parameter, issueMapper);
            String issueStatus = Objects.requireNonNull(issue).getStatus().name();

            if (issueStatus.equals("OPEN")) {
                SqlParameterSource param = new MapSqlParameterSource()
                        .addValue("status", "CLOSE")
                        .addValue("issueId", issue.getIssueId());
                jdbc.update(UPDATE_ISSUE_BY_ID, param);
            }
        }
    }

    public void openIssue(IssuesNumbers issueNumbers) {
        for (Long issueId : issueNumbers.toList()) {
            Map<String, Long> parameter = Collections.singletonMap("issueId", issueId);
            Issue issue = jdbc.queryForObject(ISSUE_SQL + " WHERE issue.id = :issueId", parameter, issueMapper);
            String issueStatus = Objects.requireNonNull(issue).getStatus().name();

            if (issueStatus.equals("CLOSE")) {
                SqlParameterSource param = new MapSqlParameterSource()
                        .addValue("status", "OPEN")
                        .addValue("issueId", issue.getIssueId());
                jdbc.update(UPDATE_ISSUE_BY_ID, param);
            }
        }
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

        List<MilestoneInfo> milestoneInfoList = jdbc.query(FIND_ALL_MILESTONE, Collections.emptyMap(), (rs, rowNum) -> new MilestoneInfo(
                rs.getString("title"),
                rs.getString("description"),
                Status.from(rs.getString("statusId")),
                toLocalDateTime(rs.getTimestamp("dueDate"))
        ));


        //TODO. 마일스톤 id,와 issue를 또 한번 마일스톤을 돌아서 구할지?
        Long cnt = 0L;

        Milestones milestones = new Milestones(new ArrayList<>());
        for (MilestoneInfo milestoneInfo : milestoneInfoList) {
            milestones.add(new Milestone(++cnt, new Issues(new ArrayList<>()), milestoneInfo));
        }

        return new IssueOption(assignees, labels, milestones);
    }

    public Long save(String writerId, InsertIssue issue) {

        KeyHolder keyHolder = new GeneratedKeyHolder();

        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue("title", issue.getTitle())
                .addValue("content", issue.getComment())
                .addValue("writerId", writerId)
                .addValue("statusId", "OPEN")
                .addValue("milestoneId", issue.getMilestoneId() != null ? issue.getMilestoneId() : null);
        jdbc.update(INSERT_ISSUE, parameter, keyHolder);

        Long issueId = Objects.requireNonNull(keyHolder.getKey()).longValue();
        updateAssigneesOfIssue(issueId, issue.getAssigneeIds());
        updateLabelsOfIssue(issueId, issue.getLabelIds());

        return issueId;
    }

    public Issue findIssueById(Long issueId) {
        Map<String, Long> parameter = Collections.singletonMap("issueId", issueId);
        return jdbc.queryForObject(ISSUE_SQL + " WHERE issue.id = :issueId", parameter, issueMapper);
    }

    public Issues findIssuesByMilestone(Long milestoneId) {
        Map<String, Long> parameter = Collections.singletonMap("milestoneId", milestoneId);
        return new Issues(jdbc.query(ISSUE_SQL + " WHERE issue.milestoneId = :milestoneId", parameter, issueMapper));
    }

    public Long addComment(String content, String writerId, Long issueId) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue("content", content)
                .addValue("writerId", writerId)
                .addValue("issueId", issueId);
        jdbc.update(INSERT_COMMENT, parameter, keyHolder);

        return Objects.requireNonNull(keyHolder.getKey()).longValue();
    }

    public void updateComment(Long commentId, String content) {
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue("commentId", commentId)
                .addValue("content", content);
        jdbc.update(UPDATE_COMMENT, parameter);
    }

    public Comments findCommentsByIssueId(Long issueId) {
        Map<String, Long> params = Collections.singletonMap("issueId", issueId);
        return new Comments(jdbc.query(FIND_ALL_COMMENT_BY_ISSUE_ID, params, (rs, rowNum) -> new Comment(
                rs.getLong("id"),
                rs.getLong("issueId"),
                new Writer(rs.getString("name"), rs.getString("avatarUrl")),
                rs.getString("content"),
                toLocalDateTime(rs.getTimestamp("datetime")))));
    }

    public void updateIssue(UpdateIssue issue, Long issueId) {
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue("title", issue.getTitle())
                .addValue("content", issue.getComment())
                .addValue("issueId", issueId);
        jdbc.update(UPDATE_ISSUE, parameter);
    }

    public void updateIssue(Long milestoneId, Long issueId) {
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue("milestoneId", milestoneId)
                .addValue("issueId", issueId);
        jdbc.update(UPDATE_ISSUE_MILESTONE, parameter);
    }

    public void updateAssigneesOfIssue(Long issueId, List<String> assigneeIds) {
        deleteAssignees(issueId);
        assigneeIds.forEach(assigneeId -> addAssignee(issueId, assigneeId));
    }

    public void deleteAssignees(Long issueId) {
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
        jdbc.update(DELETE_ISSUE_LABEL_BY_ISSUE_ID, parameter);
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
                toLocalDateTime(rs.getTimestamp("dateTime")))));
    }

    public void deleteCommentByIssueIdAndCommentId(Long issueId, Long commentId) {
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue("issueId", issueId)
                .addValue("commentId", commentId);
        jdbc.update(DELETE_COMMENT_BY_ISSUE_AND_COMMENT, parameter);
    }


    public void deleteMilestoneId(Long milestoneId) {
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue("milestoneId", milestoneId);
        jdbc.update(DELETE_MILESTONE_OF_ISSUE, parameter);

    }

    public void deleteCommentByIssueId(Long issueId) {
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue("issueId", issueId);
        jdbc.update(DELETE_COMMENT_BY_ISSUE, parameter);
    }

    public void deleteIssueById(Long issueId) {
        SqlParameterSource parameter = new MapSqlParameterSource()
                .addValue("issueId", issueId);
        jdbc.update(DELETE_ISSUE_BY_ID, parameter);
    }

}
