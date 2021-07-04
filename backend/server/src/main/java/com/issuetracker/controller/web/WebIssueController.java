package com.issuetracker.controller.web;

import com.issuetracker.annotation.LoginRequired;
import com.issuetracker.dto.auth.UserDto;
import com.issuetracker.dto.request.CommentRequest;
import com.issuetracker.dto.request.IssueRequest;
import com.issuetracker.dto.request.IssuesNumbersRequest;
import com.issuetracker.dto.response.*;
import com.issuetracker.service.AssigneeService;
import com.issuetracker.service.AuthService;
import com.issuetracker.service.IssueLabelService;
import com.issuetracker.service.IssueService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/web/issues")
public class WebIssueController {

    private final AuthService authService;
    private final IssueService issueService;
    private final AssigneeService assigneeService;
    private final IssueLabelService issueLabelService;

    public WebIssueController(AuthService authService, IssueService issueService, AssigneeService assigneeService, IssueLabelService issueLabelService) {
        this.authService = authService;
        this.issueService = issueService;
        this.assigneeService = assigneeService;
        this.issueLabelService = issueLabelService;
    }

    @GetMapping
    public IssuesResponse getIssues(UserDto user, @RequestParam(value = "status", required = false) String issueStatus, @RequestParam(required = false) String milestone, @RequestParam(required = false) String writer, @RequestParam(required = false) String created) {
        return issueService.getIssues(user, issueStatus);
    }


    //TODO. 로직 미구현
    @PatchMapping
    public void closeIssue(@RequestBody IssuesNumbersRequest issueNumber) {
        issueService.toggleIssue(issueNumber); //TODO. toggle 네이밍 변경 필요해보임.
    }

    //INFO. 이슈생성 버튼 클릭시 제공해주는 요소(담당자, 레이블, 마일스톤 리스트..)
    @GetMapping("/form")
    public IssueOptionResponse makeIssuePage() {
        return issueService.findIssueOption();
    }

    @PostMapping
    public void createIssue(HttpServletRequest request, @RequestBody IssueRequest issue) {
        //String userId = (String) request.getAttribute("userId");
        //UserDto loginUser = authService.getUser(userId);
        UserDto loginUser = new UserDto("neo", "네오", null, null);
        issueService.save(loginUser, issue);

        //TODO. save를 하면서 바로 이슈 아이디를 리턴해주면 아래 로직이 불필요할 텐데...아직 방법을 모르겠다 ㅠ
        //TODO. 아래 로직은 이슈를 작성한 유저와 글 제목, 내용 비교를 통해서 이슈 아이디를 탐색하는데
        // 위 3가지 조건이 모두 동일한 이슈가 중복해서 존재할 경우 이슈를 탐색할 수 없는 **문제점**이 있다.
        //TODO. 파라미터로 도메인이 아닌 변수로 받아도 괜찮을까? 아직 객체로 래핑할 생각을 못함.
        //TODO. JSON에서 null value를 JAVA에서 어떻게 처리할 지 모르겠음.
        //json null value를 받으면 size 1의 null을 가지게 돼서.. 아래와 같이 null 체크를 했는데
        // 옳은 방법은 아닌 것 같음.
        IssueSummaryResponse findIssue = issueService.findIssue(loginUser, issue);
        if (issue.getAssigneeIds().get(0) != null) {
            assigneeService.save(findIssue.getIssueId(), issue.getAssigneeIds());
        }
        if (issue.getLabelIds().get(0) != null) {
            issueLabelService.save(findIssue.getIssueId(), issue.getLabelIds());
        }
    }

    @GetMapping("/{issueId}")
    public IssueDetailResponse detailIssue(@PathVariable Long issueId) {
        return issueService.findDetailedIssueId(issueId);
    }

    @GetMapping("/{issueId}/comments")
    public CommentsResponse commentList(@PathVariable Long issueId) {
        return issueService.findCommentsByIssueId(issueId);
    }

    @PostMapping("/{issueId}/comments")
    @LoginRequired
    public void createComment(@PathVariable Long issueId, @RequestBody CommentRequest commentRequest, HttpServletRequest request) {
        String writerId = (String) request.getAttribute("userId");
        issueService.addComment(commentRequest, writerId, issueId);
    }

    @PutMapping("/{issueId}/comments/{commentId}")
    public void updateMilestone(@PathVariable Long commentId, @RequestBody CommentRequest commentRequest) {
        issueService.updateComment(commentId, commentRequest);
    }
}
