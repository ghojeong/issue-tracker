package com.issuetracker.intercepter;

import com.issuetracker.annotation.LoginRequired;
import com.issuetracker.dto.auth.UserDto;
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
                .orElseThrow(() -> new AuthenticationException("인증되지 않은 유저입니다."));
        String[] splitAuth = authorization.split(" ");
        String tokenType = splitAuth[0].toLowerCase();
        if (splitAuth.length < 1 || !tokenType.equals("bearer")) {
            throw new AuthenticationException("잘못된 Authorization 타입입니다.");
        }
        UserDto userDto = JwtUtil.decodeJwt(splitAuth[1]);
        request.setAttribute("user", userDto);
    }
}
