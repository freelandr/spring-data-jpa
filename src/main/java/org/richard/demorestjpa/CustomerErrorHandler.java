package org.richard.demorestjpa;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class CustomerErrorHandler {
	
	@ResponseBody
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<Object> customerNotFoundHandler(CustomerNotFoundException ex) {
		return generateErrorResponse(HttpStatus.NOT_FOUND, ErrorCode.CUSTOMER_NOT_FOUND, ex);
	}
	
	@ResponseBody
	@ExceptionHandler(CustomerAlreadyExistsException.class)
	public ResponseEntity<Object> customerAlreadyExistsHandler(CustomerAlreadyExistsException ex) {
		return generateErrorResponse(HttpStatus.BAD_REQUEST, ErrorCode.CUSTOMER_ALREADY_EXISTS, ex);
	}
	
	@ResponseBody
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> generalErrorHandler(Exception ex) {
		return generateErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ErrorCode.INTERNAL_ERROR, ex);
	}

	private ResponseEntity<Object> generateErrorResponse(HttpStatus status, ErrorCode errorCode, Exception exception) {
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("time", Instant.now());
		body.put("code", errorCode.toString());
		body.put("type", exception.getClass().getSimpleName());
		body.put("message", exception.getMessage());
		return new ResponseEntity<>(body, status);		
	}
}
