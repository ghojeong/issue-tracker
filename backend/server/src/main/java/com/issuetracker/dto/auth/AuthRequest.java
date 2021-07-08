package com.issuetracker.dto.auth;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AuthRequest {

    @NotNull(message = "code는 NULL일 수 없습니다.")
    @NotBlank(message = "code는 공백일 수 없습니다.")
    private String code;

    protected AuthRequest() {
    }

    public AuthRequest(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
