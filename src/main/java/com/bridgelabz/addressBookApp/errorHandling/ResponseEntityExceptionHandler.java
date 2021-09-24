package com.bridgelabz.addressBookApp.errorHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@ResponseStatus
public class ResponseEntityExceptionHandler
		extends org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler {
@ExceptionHandler(AddressBookNotFound.class)
	public ResponseEntity<ErrorMessage> AddressBookNotFoundException(AddressBookNotFound exception, WebRequest request) {
	
	ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND , exception.getMessage());
	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
}
	
}
