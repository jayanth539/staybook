package com.staybook.exception;

import java.time.LocalDateTime;

public record ApiError(
        String message,
        String details,
        LocalDateTime timestamp
) {
    public static ApiError of(String message, String details) {
        return new ApiError(message, details, LocalDateTime.now());
    }
}
