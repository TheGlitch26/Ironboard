package com.ironhack.IronBoard.exception;

import java.time.LocalDateTime;
import java.util.List;

public class ValidationErrorResponse {

    private int status;
    private String error;
    private List<String> fieldErrors;
    private LocalDateTime timestamp;

    public ValidationErrorResponse(int status, String error, List<String> fieldErrors) {
        this.status = status;
        this.fieldErrors = fieldErrors;
        this.error = error;
        this.timestamp = LocalDateTime.now();
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public List<String> getFieldErrors() {
        return fieldErrors;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
