package com.issuetracker.service;

import com.issuetracker.domain.Comments;
import com.issuetracker.domain.Issue;
import com.issuetracker.domain.Status;
import com.issuetracker.dto.auth.UserDto;
import com.issuetracker.dto.request.*;
import com.issuetracker.dto.response.CommentsResponse;
import com.issuetracker.dto.response.IssueDetailResponse;
import com.issuetracker.dto.response.IssueOptionResponse;
import com.issuetracker.dto.response.IssuesResponse;
import com.issuetracker.exception.AuthenticationException;
import com.issuetracker.repository.IssueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueService {
    private final IssueRepository issueRepository;

    public IssueService(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    public IssuesResponse getIssues(UserDto userDto, String status) {
        return IssuesResponse.from(issueRepository.getIssues(userDto.toUser(), Status.from(status)));
    }

    //INFO.  "issueNumbers": [1, 2, 3] 이 들어오면, 해당 번호의 이슈의 상태를 반전
    //INFO. 아직 repository 완성되지 않음.
    public void toggleIssue(IssuesNumbersRequest issueNumber) {
        issueRepository.toggle(issueNumber.toIssueNumber()); //TODO. toggle 네이밍 변경 필요해보임.
    }

    public IssueOptionResponse findIssueOption() {
        return IssueOptionResponse.from(issueRepository.findIssueOption());
    }

    public void save(UserDto userDto, IssueRequest issueDto) {
        issueRepository.save(userDto.toUser(), issueDto.toNewIssue());
    }

    public IssueDetailResponse findDetailedIssueId(Long issueId) {
        Issue issue = issueRepository.findIssueById(issueId);
        Comments comments = issueRepository.findCommentsByIssueId(issueId);

        return IssueDetailResponse.from(issue, comments);
    }

    public CommentsResponse findCommentsByIssueId(Long issueId) {
        return CommentsResponse.from(issueRepository.findCommentsByIssueId(issueId));
    }

    public void addComment(CommentRequest commentRequest, String writerId, Long issueId) {
        issueRepository.addComment(commentRequest.getContent(), writerId, issueId);
    }

    public void updateComment(Long commentId, CommentRequest commentRequest) {
        issueRepository.updateComment(commentId, commentRequest.getContent());
    }

    public void saveIssueLabel(Long issueId, List<Long> labelIds) {
        for (Long labelId : labelIds) {
            issueRepository.saveIssueLabel(issueId, labelId);
        }
    }

    public void updateIssue(String loginUserId, IssueRequest updateIssue, Long issueId) {
        Issue findIssue = issueRepository.findIssueById(issueId);

        if (!findIssue.getWriter().getId().equals(loginUserId)) {
            throw new AuthenticationException("인증되지 않은 유저입니다.");
        }

        issueRepository.updateIssue(updateIssue.toNewIssue(), issueId);

    }

    public void addAssignees(AssigneesRequest assigneeRequest, String writerId, Long issueId) {
        Issue findIssue = issueRepository.findIssueById(issueId);
        if (!findIssue.getWriter().getId().equals(writerId)) {
            throw new AuthenticationException("인증되지 않은 유저입니다.");
        }
        issueRepository.deleteAssignees(issueId);


        for (String assignee : assigneeRequest.getAssigneeIds()) {
            issueRepository.addAssignees(issueId, assignee);
        }

    }

    public void addLabels(LabelNumbersRequest labels, String writerId, Long issueId) {
        Issue findIssue = issueRepository.findIssueById(issueId);
        if (!findIssue.getWriter().getId().equals(writerId)) {
            throw new AuthenticationException("인증되지 않은 유저입니다.");
        }
        issueRepository.deleteLabelsOfIssue(issueId);

        for (Long labelId : labels.getLabelIds()) {
            issueRepository.addLabelOfIssue(issueId, labelId);
        }

    }
}
