package com.issuetracker.controller.web;

import com.issuetracker.annotation.LoginRequired;
import com.issuetracker.dto.auth.UserDto;
import com.issuetracker.dto.request.*;
import com.issuetracker.dto.response.CommentsResponse;
import com.issuetracker.dto.response.IssueDetailResponse;
import com.issuetracker.dto.response.IssueOptionResponse;
import com.issuetracker.dto.response.IssuesResponse;
import com.issuetracker.service.IssueService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/web/issues")
public class WebIssueController {

    private final IssueService issueService;

    public WebIssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    @GetMapping
    public IssuesResponse getIssues(UserDto user, @RequestParam(value = "status", required = false) String issueStatus, @RequestParam(required = false) String milestone, @RequestParam(required = false) String writer, @RequestParam(required = false) String created) {
        return issueService.getIssues(user, issueStatus);
    }

    @PutMapping("close")
    public void closeIssue(@RequestBody IssuesNumbersRequest issueNumber) {
        issueService.closeIssue(issueNumber); //TODO. toggle 네이밍 변경 필요해보임.
    }

    @PutMapping("open")
    public void openIssue(@RequestBody IssuesNumbersRequest issueNumber) {
        issueService.openIssue(issueNumber); //TODO. toggle 네이밍 변경 필요해보임.
    }

    //INFO. 이슈생성 버튼 클릭시 제공해주는 요소(담당자, 레이블, 마일스톤 리스트..)
    @GetMapping("/form")
    public IssueOptionResponse makeIssuePage() {
        return issueService.findIssueOption();
    }

    @PostMapping
    @LoginRequired
    public Long createIssue(HttpServletRequest request, @Valid @RequestBody InsertIssueRequest issue) {
        String writerId = (String) request.getAttribute("userId");
        return issueService.save(writerId, issue);
    }

    @GetMapping("/{issueId}")
    public IssueDetailResponse detailIssue(@PathVariable Long issueId) {
        return issueService.findDetailedIssueId(issueId);
    }

    @PutMapping("/{issueId}")
    @LoginRequired
    public void updateIssue(HttpServletRequest request, @Valid @RequestBody UpdateIssueRequest issue, @PathVariable Long issueId) {
        String loginUserId = (String) request.getAttribute("userId");
        issueService.updateIssue(loginUserId, issue, issueId);
    }

    @PutMapping("/{issueId}/milestones")
    public void updateIssueMilestone(@Valid @RequestBody UpdateIssueMilestoneRequest milestoneRequest, @PathVariable Long issueId) {
        issueService.updateIssue(milestoneRequest, issueId);
    }

    @PutMapping("/{issueId}/assignees")
    @LoginRequired
    public void updateIssue(HttpServletRequest request, @RequestBody AssigneesRequest assignees, @PathVariable Long issueId) {
        String loginUserId = (String) request.getAttribute("userId");
        issueService.addAssignees(assignees, loginUserId, issueId);
    }

    @PutMapping("/{issueId}/labels")
    @LoginRequired
    public void updateIssue(HttpServletRequest request, @RequestBody LabelNumbersRequest labels, @PathVariable Long issueId) {
        String loginUserId = (String) request.getAttribute("userId");
        issueService.addLabels(labels, loginUserId, issueId);
    }

    @GetMapping("/{issueId}/comments")
    public CommentsResponse commentList(@PathVariable Long issueId) {
        return issueService.findCommentsByIssueId(issueId);
    }

    @PostMapping("/{issueId}/comments")
    @LoginRequired
    public Long createComment(@PathVariable Long issueId, @Valid @RequestBody CommentRequest commentRequest, HttpServletRequest request) {
        String writerId = (String) request.getAttribute("userId");
        return issueService.addComment(commentRequest, writerId, issueId);
    }

    @PutMapping("/{issueId}/comments/{commentId}")
    public void updateComment(@PathVariable Long commentId, @Valid @RequestBody CommentRequest commentRequest) {
        issueService.updateComment(commentId, commentRequest);
    }

    @DeleteMapping("/{issueId}/comments/{commentId}")
    @LoginRequired
    public void deleteComments(@PathVariable Long issueId, @PathVariable Long commentId, HttpServletRequest request) {
        String writerId = (String) request.getAttribute("userId");
        issueService.deleteComment(writerId, issueId, commentId);
    }

    @DeleteMapping("/{issueId}")
    @LoginRequired
    public void deleteIssue(@PathVariable Long issueId, HttpServletRequest request) {
        String writerId = (String) request.getAttribute("userId");
        issueService.deleteIssue(writerId, issueId);
    }
}
