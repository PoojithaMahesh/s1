package com.jsp.studentspringe2.exception;

import lombok.Getter;
@Getter
public class UserIdNOtFoundException extends RuntimeException {
	
	private String message;

	public UserIdNOtFoundException(String message) {
		super();
		this.message = message;
	}
	
}
