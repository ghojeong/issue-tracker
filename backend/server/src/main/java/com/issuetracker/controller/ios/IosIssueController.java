package com.issuetracker.controller.ios;

import com.issuetracker.annotation.LoginRequired;
import com.issuetracker.dto.auth.UserDto;
import com.issuetracker.dto.request.InsertIssueRequest;
import com.issuetracker.dto.request.IssuesNumbersRequest;
import com.issuetracker.dto.response.CommentsResponse;
import com.issuetracker.dto.response.IssueDetailResponse;
import com.issuetracker.dto.response.IssueOptionResponse;
import com.issuetracker.dto.response.IssuesResponse;
import com.issuetracker.service.AuthService;
import com.issuetracker.service.IssueService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/ios")
public class IosIssueController {

    private final AuthService authService;
    private final IssueService issueService;

    public IosIssueController(AuthService authService, IssueService issueService) {
        this.authService = authService;
        this.issueService = issueService;
    }

    @GetMapping("/issues")
    public IssuesResponse getIssues(UserDto user, @RequestParam(value = "status", required = false) String issueStatus, @RequestParam(required = false) String milestone, @RequestParam(required = false) String writer, @RequestParam(required = false) String created) {
        return issueService.getIssues(user, issueStatus);
    }
    
    @PatchMapping("/issues")
    public void closeIssue(@RequestBody IssuesNumbersRequest issueNumber) {
        issueService.closeIssue(issueNumber); //TODO. toggle 네이밍 변경 필요해보임.
    }

    //INFO. 이슈생성 버튼 클릭시 제공해주는 요소(담당자, 레이블, 마일스톤 리스트..)
    @GetMapping("/issues/form")
    public IssueOptionResponse makeIssuePage() {
        return issueService.findIssueOption();
    }

    @PostMapping("/issues")
    @LoginRequired
    public void createIssue(HttpServletRequest request, @RequestBody InsertIssueRequest issue) {
        String writerId = (String) request.getAttribute("userId");
        issueService.save(writerId, issue);
    }

    @GetMapping("/issues/{issueId}")
    public IssueDetailResponse detailIssue(@PathVariable Long issueId) {
        return issueService.findDetailedIssueId(issueId);
    }

    @GetMapping("/issues/{issueId}/comments")
    public CommentsResponse commentList(@PathVariable Long issueId) {
        return issueService.findCommentsByIssueId(issueId);
    }
}
