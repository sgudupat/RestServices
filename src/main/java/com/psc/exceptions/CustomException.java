package com.psc.exceptions;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class CustomException extends RuntimeException {
	static final Logger logger = Logger.getLogger(CustomException.class);
	private static final long serialVersionUID = 1997753363232807009L;

	public CustomException() {
	}

	public CustomException(String message) {
		super(message);
	}

	public CustomException(Throwable cause) {
		super(cause);
	}

	public CustomException(String message, Throwable cause) {
		super(message, cause);
	}

	public CustomException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super();
	}
}