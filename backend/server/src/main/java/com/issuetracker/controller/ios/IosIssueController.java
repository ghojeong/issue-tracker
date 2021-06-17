package com.issuetracker.controller.ios;

import com.issuetracker.dto.auth.UserDto;
import com.issuetracker.dto.ios.IosIssueOptionDto;
import com.issuetracker.dto.ios.IosIssuesDto;
import com.issuetracker.service.AuthService;
import com.issuetracker.service.ios.IosIssueService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ios")
public class IosIssueController {

    private final AuthService authService;
    private final IosIssueService iosIssueService;

    public IosIssueController(AuthService authService, IosIssueService iosIssueService) {
        this.authService = authService;
        this.iosIssueService = iosIssueService;
    }

    @GetMapping("/issues")
    public IosIssuesDto getIssues(UserDto user, @RequestParam("status") String issueStatus) {
        return iosIssueService.getIssues(user, issueStatus);
    }

    //로직 미구현
    @PatchMapping("/issues")
    public void closeIssue(@RequestBody Integer[] issueNumber) {
        iosIssueService.toggleIssue(issueNumber); //TODO. toggle 네이밍 변경 필요해보임.
    }

    //INFO. 마일스톤 옵션 추가해야함.
    @GetMapping("/issues/form")
    public IosIssueOptionDto makeIssuePage() {
        return iosIssueService.findIssueOption();
    }
    
}
