package com.psc.exceptions;

public class UserValidationException extends Exception {

    public UserValidationException() {
    }

    public UserValidationException(String message) {
        super(message);
    }

    public UserValidationException(String errorCode, String exception) {
        super(errorCode + " : " + exception);
    }

    public UserValidationException(Throwable cause) {
        super(cause);
    }

    public UserValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}