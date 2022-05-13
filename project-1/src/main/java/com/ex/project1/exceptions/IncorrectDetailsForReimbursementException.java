package com.ex.project1.exceptions;

public class IncorrectDetailsForReimbursementException extends RuntimeException{
    public IncorrectDetailsForReimbursementException() {
    }

    public IncorrectDetailsForReimbursementException(String message) {
        super(message);
    }

    public IncorrectDetailsForReimbursementException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectDetailsForReimbursementException(Throwable cause) {
        super(cause);
    }

    public IncorrectDetailsForReimbursementException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
