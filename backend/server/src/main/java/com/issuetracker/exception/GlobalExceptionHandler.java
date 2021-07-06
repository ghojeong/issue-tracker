package com.issuetracker.exception;

import com.issuetracker.controller.FailedResultApi;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({
            RuntimeException.class
    })
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public FailedResultApi<?> notAuthorizedException(RuntimeException exception) {
        return FailedResultApi.failed(exception);
    }
}
