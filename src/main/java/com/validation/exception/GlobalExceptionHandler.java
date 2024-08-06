package com.validation.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleEmployeeNotFoundException(Throwable e)
	{
		String message=e.getMessage();
				
		ErrorResponse response= new ErrorResponse();
		response.setMessage(message);
		response.setStatusCode(404);
		response.setFlag(false);
		return new ResponseEntity<ErrorResponse>(response,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(InvalidEmployeeexception.class)
	public ResponseEntity<ErrorResponse> handleInvalidEmployeeException(Throwable e)
	{
		String message=e.getMessage();
		
		ErrorResponse response= new ErrorResponse();
		response.setMessage(message);
		response.setStatusCode(404);
		response.setFlag(false);
		return new ResponseEntity<ErrorResponse>(response,HttpStatus.BAD_REQUEST);
	}
	
//	 @ExceptionHandler(MethodArgumentNotValidException.class)
//	    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
//	        HashMap<String, String> errors = new HashMap<>();
//
//	        e.getBindingResult().getAllErrors().forEach((error) -> {
//	            String fieldName = ((FieldError) error).getField();
//	            String errorMessage = error.getDefaultMessage();
//	            errors.put(fieldName, errorMessage);
//	        });

	   //     return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	   // }
	  @ExceptionHandler(ConstraintViolationException.class)
	    public ResponseEntity<Map<String, String>> handleConstraintViolationException(ConstraintViolationException e) {
	        HashMap<String, String> errors = new HashMap<>();

	        for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
	            String fieldName = violation.getPropertyPath().toString();
	            String errorMessage = violation.getMessage();
	            errors.put(fieldName, errorMessage);
	        }

	        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	    }
}