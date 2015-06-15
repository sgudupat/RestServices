package com.psc.exceptions;

public class AuthenticationException extends Exception {

    public AuthenticationException() {
    }

    public AuthenticationException(String message) {
        super(message);
    }

    public AuthenticationException(String errorCode, String exception) {
        super(errorCode + " : " + exception);
    }

    public AuthenticationException(Throwable cause) {
        super(cause);
    }

    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}