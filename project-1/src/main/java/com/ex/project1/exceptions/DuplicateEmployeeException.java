package com.ex.project1.exceptions;

public class DuplicateEmployeeException extends RuntimeException{
    public DuplicateEmployeeException() {
    }

    public DuplicateEmployeeException(String message) {
        super(message);
    }

    public DuplicateEmployeeException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateEmployeeException(Throwable cause) {
        super(cause);
    }

    public DuplicateEmployeeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
