package com.psc.exceptions;

import org.apache.log4j.Logger;

public class LoginException  extends Exception{
	
	 static final Logger logger = Logger.getLogger(LoginException.class);
	 private static final long serialVersionUID = 1997753363232807009L;
	 public LoginException() {
	  
	 }
	 public LoginException(String message){
	  super(message);
	 }
	 public LoginException(String errorCode, String exception){
	  super(errorCode+  " : " +exception);
	 }
	 public LoginException(Throwable cause){
	  super(cause);
	 }
	 public LoginException(String message, Throwable cause){
	  super(message, cause);
	 }

}
