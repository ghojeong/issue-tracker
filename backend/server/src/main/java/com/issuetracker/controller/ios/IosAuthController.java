package com.issuetracker.controller.ios;

import com.issuetracker.annotation.LoginRequired;
import com.issuetracker.dto.auth.AccessTokenResponse;
import com.issuetracker.dto.auth.AuthRequest;
import com.issuetracker.dto.auth.AuthResponse;
import com.issuetracker.dto.auth.UserDto;
import com.issuetracker.service.AuthService;
import com.issuetracker.service.UserService;
import com.issuetracker.service.github.GitHubIosService;
import com.issuetracker.service.github.GitHubService;
import com.issuetracker.util.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/ios")
public class IosAuthController {
    private final GitHubService gitHubService;
    private final UserService userService;
    private final AuthService authService;

    public IosAuthController(GitHubIosService gitHubService, UserService userService, AuthService authService) {
        this.gitHubService = gitHubService;
        this.userService = userService;
        this.authService = authService;
    }

    @GetMapping("/userInfo")
    @LoginRequired
    public UserDto getUser(HttpServletRequest request) {
        String userId = (String) request.getAttribute("userId");
        return authService.getUser(userId);
    }

    @PostMapping("/auth")
    public ResponseEntity<AuthResponse> auth(@RequestBody AuthRequest authRequest) {
        String code = authRequest.getCode();
        AccessTokenResponse accessTokenResponse = gitHubService.getAccessToken(code);
        String accessToken = accessTokenResponse.getAccessToken();
        UserDto userDto = gitHubService.getUser(accessToken);

        userService.save(userDto);
        authService.save(userDto, accessTokenResponse);

        return ResponseEntity.status(CREATED)
                .body(new AuthResponse(
                        JwtUtil.createJwt(userDto),
                        userDto.getName(),
                        userDto.getAvatarUrl()));
    }
}
