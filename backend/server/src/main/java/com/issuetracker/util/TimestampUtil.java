package com.issuetracker.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class TimestampUtil {
    private TimestampUtil() {}

    public static LocalDateTime toLocalDateTime(Timestamp timestamp) {
        return timestamp != null ? timestamp.toLocalDateTime() : null;
    }
}
