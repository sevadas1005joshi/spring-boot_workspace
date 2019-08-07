package com.jpa.employeeservice.exeptionHandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

@ControllerAdvice
public class CommonExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiError> handleInternalServerExp(Exception ex, WebRequest request){
		ApiError errorResponse=new ApiError(ex.getMessage(),request.getDescription(false),LocalDateTime.now());
		return new ResponseEntity<ApiError>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ApiError> handleEmployeeNotFoundException(Exception ex, WebRequest request){
		ApiError errorResponse=new ApiError(ex.getMessage(),request.getDescription(false),LocalDateTime.now());
		return new ResponseEntity<ApiError>(errorResponse, HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ApiError> handleInvalidFormatExc(Exception ex, WebRequest request){
		ApiError errorResponse=new ApiError(ex.getMessage(),request.getDescription(false),LocalDateTime.now());
		
		return new ResponseEntity<ApiError>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	

}
