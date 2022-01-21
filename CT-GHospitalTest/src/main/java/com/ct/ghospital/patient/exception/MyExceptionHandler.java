package com.ct.ghospital.patient.exception;

import org.jboss.resteasy.spi.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	private ResponseEntity<ErrorResponse> handleUserNotFoundException() {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(111, "User not found"));
	}
	

	@ExceptionHandler(WrongCrendentials.class)
	private ResponseEntity<ErrorResponse> WrongCrendentials() {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(111, "Invalid Credentials"));
	}
	
	@ExceptionHandler(StatusCheckException.class)
	private ResponseEntity<ErrorResponse> StatusCheckException() {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(111, "User is not Active.Please Contact Administrator"));
	}
	
	@ExceptionHandler(UnauthorizedcheckException.class)
	private ResponseEntity<ErrorResponse> UnauthorizedcheckException() {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponse(111, "Invalid Credentials"));
	}



}
