package com.example.cafeaoponto.exception.handler;

import java.util.Date;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.cafeaoponto.exception.ExceptionResponse;
import com.example.cafeaoponto.exception.InvalidJWTAuthenticationException;

@RestController
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request){
		ExceptionResponse exceptionRresponse = 
				new ExceptionResponse(
						new Date(), 
						ex.getMessage(), 
						request.getDescription(false));
		return new ResponseEntity<>(exceptionRresponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleBadRequestExceptions(Exception ex, WebRequest request){
		ExceptionResponse exceptionRresponse = 
				new ExceptionResponse(
						new Date(), 
						ex.getMessage(), 
						request.getDescription(false));
		return new ResponseEntity<>(exceptionRresponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidJWTAuthenticationException.class)
	public final ResponseEntity<ExceptionResponse> invalidJWTAuthenticationException(Exception ex, WebRequest request){
		ExceptionResponse exceptionRresponse = 
				new ExceptionResponse(
						new Date(), 
						ex.getMessage(), 
						request.getDescription(false));
		return new ResponseEntity<>(exceptionRresponse, HttpStatus.BAD_REQUEST);
	}
}
