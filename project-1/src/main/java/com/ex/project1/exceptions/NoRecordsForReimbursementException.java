package com.ex.project1.exceptions;

public class NoRecordsForReimbursementException extends RuntimeException{
    public NoRecordsForReimbursementException() {
    }

    public NoRecordsForReimbursementException(String message) {
        super(message);
    }

    public NoRecordsForReimbursementException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoRecordsForReimbursementException(Throwable cause) {
        super(cause);
    }

    public NoRecordsForReimbursementException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
