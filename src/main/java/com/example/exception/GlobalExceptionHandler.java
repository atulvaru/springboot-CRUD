package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(UserIdNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleUserIdNotFoundException(UserIdNotFoundException exception) {
		ErrorMessage errorMessage = new ErrorMessage("User_Id_Not_Found", exception.getMessage());
		return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> handleGlobalException(Exception exception) {
		ErrorMessage errorMessage = new ErrorMessage("Internal Server Error", exception.getMessage());
		return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
	}
}
