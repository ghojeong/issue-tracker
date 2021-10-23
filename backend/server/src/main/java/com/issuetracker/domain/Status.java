package com.issuetracker.domain;

public enum Status {
    OPEN,
    CLOSE,
    ALL;

    public static Status from(String status) {
        return status == null ? ALL
                : valueOf(status.toUpperCase());
    }
}
