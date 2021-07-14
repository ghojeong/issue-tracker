package com.issuetracker.intercepter;

import com.issuetracker.annotation.LoginRequired;
import com.issuetracker.exception.AuthenticationException;
import com.issuetracker.util.JwtUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Configuration
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (isLoginRequired(handler)) {
            authenticate(request);
        }
        return true;
    }

    private boolean isLoginRequired(Object handler) {
        return handler instanceof HandlerMethod
                && ((HandlerMethod) handler).hasMethodAnnotation(LoginRequired.class);
    }

    private void authenticate(HttpServletRequest request) {
        String authorization = Optional.ofNullable(request.getHeader(AUTHORIZATION))
                .orElseThrow(() -> new AuthenticationException("인증되지 않은 유저입니다. Authorization 헤더를 포함해주세요."));
        String[] splitAuth = authorization.split(" ");
        String tokenType = splitAuth[0].toLowerCase();
        if (splitAuth.length < 2 || !tokenType.equals("bearer")) {
            throw new AuthenticationException("잘못된 Authorization 타입입니다. 토큰 앞에 Bearer 를 붙여주세요.");
        }
        String userId = JwtUtil.decodeJwt(splitAuth[1]);
        if (userId == null || userId.length() == 0) {
            throw new AuthenticationException("로그인되어 있지 않은 유저입니다. 다시 로그인해주세요.");
        }
        request.setAttribute("userId", userId);
    }
}
