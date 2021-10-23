package com.issuetracker.service;

import com.issuetracker.domain.auth.Auth;
import com.issuetracker.dto.auth.AccessTokenResponse;
import com.issuetracker.dto.auth.UserDto;
import com.issuetracker.exception.AuthenticationException;
import com.issuetracker.repository.AuthRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final AuthRepository authRepository;

    public AuthService(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public void save(UserDto userDto, AccessTokenResponse accessTokenResponse) {
        Auth auth = Auth.from(userDto.toUser(), accessTokenResponse.toToken());
        authRepository.save(auth);
    }

    public UserDto getUser(String userId) {
        return UserDto.from(authRepository.findById(userId)
                .orElseThrow(() -> new AuthenticationException("로그인하지 않은 유저입니다."))
                .getUser());
    }
}
