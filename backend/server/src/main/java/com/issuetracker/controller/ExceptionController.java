package com.issuetracker.controller;

import com.issuetracker.dto.response.MessagesResponse;
import com.issuetracker.exception.AuthenticationException;
import com.issuetracker.exception.JwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataAccessException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Collections;
import java.util.stream.Collectors;

import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;
import static org.springframework.http.HttpStatus.*;

@Order(HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ExceptionController {
    private final Logger logger = LoggerFactory.getLogger(ExceptionController.class);

    @ResponseStatus(UNAUTHORIZED)
    @ResponseBody
    @ExceptionHandler(JwtException.class)
    public MessagesResponse handleJwtException(JwtException e) {
        String message = e.getMessage();
        logger.error(message);
        return new MessagesResponse(Collections.singletonList(message));
    }

    @ResponseStatus(UNAUTHORIZED)
    @ResponseBody
    @ExceptionHandler(AuthenticationException.class)
    public MessagesResponse handleAuthenticationException(AuthenticationException e) {
        String message = e.getMessage();
        logger.error(message);
        return new MessagesResponse(Collections.singletonList(message));
    }

    @ResponseStatus(BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public MessagesResponse handleBadRequestException(MethodArgumentNotValidException e) {
        return new MessagesResponse(e.getBindingResult().getFieldErrors()
                .stream().map(FieldError::getDefaultMessage)
                .collect(Collectors.toList()));
    }

    @ResponseStatus(NOT_FOUND)
    @ResponseBody
    @ExceptionHandler(DataAccessException.class)
    public MessagesResponse handleDataAccessException(DataAccessException e) {
        return new MessagesResponse(Collections.singletonList(e.getMessage()));
    }
}
