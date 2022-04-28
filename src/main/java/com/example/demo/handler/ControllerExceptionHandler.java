package com.example.demo.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exception.InvalidFieldException;

@RestControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(InvalidFieldException.class)
	public ResponseEntity<String> haldelInvalidObjectException(InvalidFieldException invalidObjectException){
		return new ResponseEntity<String>(invalidObjectException.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> haldelNoArgsException(MethodArgumentNotValidException exception){
		return new ResponseEntity<String>(exception.getBindingResult().getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> globalException(Exception exception){
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
