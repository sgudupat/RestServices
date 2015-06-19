package com.psc.exceptions;

import org.apache.log4j.Logger;


public class UserException  extends Exception{
	
	static final Logger logger = Logger.getLogger(UserException.class);
	private static final long serialVersionUID = 1997753363232807009L;
	
	public UserException() {
    }

    public UserException(String message) {
        super(message);
    }

    public UserException(String errorCode, String exception) {
        super(errorCode + " : " + exception);
    }

    public UserException(Throwable cause) {
        super(cause);
    }
 


    public UserException(String message, Throwable cause) {
        super(message, cause);
    }

}
