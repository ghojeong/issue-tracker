package com.issuetracker.controller;

import com.issuetracker.dto.response.MessageResponse;
import com.issuetracker.exception.AuthenticationException;
import com.issuetracker.exception.JwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@ControllerAdvice
public class ExceptionController {
    private final Logger logger = LoggerFactory.getLogger(ExceptionController.class);

    @ExceptionHandler(JwtException.class)
    public ResponseEntity<MessageResponse> handleJwtException(JwtException e) {
        String message = e.getMessage();
        logger.error(message);
        return ResponseEntity.status(UNAUTHORIZED).body(new MessageResponse(message));
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<MessageResponse> handleAuthenticationException(AuthenticationException e) {
        String message = e.getMessage();
        logger.error(message);
        return ResponseEntity.status(UNAUTHORIZED).body(new MessageResponse(message));
    }
}
