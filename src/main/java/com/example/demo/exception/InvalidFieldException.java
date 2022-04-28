package com.example.demo.exception;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class InvalidFieldException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	
}
