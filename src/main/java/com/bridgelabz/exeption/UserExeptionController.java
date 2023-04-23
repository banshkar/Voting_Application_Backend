package com.bridgelabz.exeption;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExeptionController {
	
	@ExceptionHandler(UserExeption.class)
	public ResponseEntity<Object> handler(UserExeption ex){
		String message =ex.getMessage();
		return new ResponseEntity<Object>(message,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> methodArcHandle(MethodArgumentNotValidException exz){
		Map<String,String>map =new HashMap<>();
		exz.getBindingResult().getAllErrors().forEach((error)->{
			String fieldName=((FieldError)error).getField();
			String errorMessage=error.getDefaultMessage();
			map.put(fieldName, errorMessage);
		});
		return new ResponseEntity<Map<String,String>>(map,HttpStatus.BAD_REQUEST);
	}

}
