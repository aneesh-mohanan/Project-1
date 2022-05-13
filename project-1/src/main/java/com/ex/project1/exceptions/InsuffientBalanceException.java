package com.ex.project1.exceptions;

public class InsuffientBalanceException extends RuntimeException{
    public InsuffientBalanceException() {
    }

    public InsuffientBalanceException(String message) {
        super(message);
    }

    public InsuffientBalanceException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsuffientBalanceException(Throwable cause) {
        super(cause);
    }

    public InsuffientBalanceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
