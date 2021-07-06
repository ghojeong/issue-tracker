package com.issuetracker.controller;

public class FailedResultApi<T> {

    private final String errorMessage;

    private FailedResultApi(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public static FailedResultApi<?> failed(Throwable throwable) {
        return failed(throwable.getMessage());
    }

    public static FailedResultApi<?> failed(String message) {
        return new FailedResultApi<>(message);
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
