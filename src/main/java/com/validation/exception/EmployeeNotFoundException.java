package com.validation.exception;

public class EmployeeNotFoundException extends RuntimeException {
	

	

	public EmployeeNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeNotFoundException(String message1, String message2, Long id) {
	    super(String.format("%s with %s %d not found", message1, message2, id));
	    // TODO Auto-generated constructor stub
	}


	
}
