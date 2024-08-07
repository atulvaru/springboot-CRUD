package com.example.exception;

public class UserIdNotFoundException extends RuntimeException {
	private String message;
	
	public UserIdNotFoundException(String message) {
		super(message);
		this.message=message;
	}
}

