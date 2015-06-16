package com.psc.exceptions;

import org.apache.log4j.Logger;

public class AuthenticationException extends Exception {

	private static final long serialVersionUID = -459041558156832634L;
	static final Logger logger = Logger.getLogger(AuthenticationException.class);
	

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