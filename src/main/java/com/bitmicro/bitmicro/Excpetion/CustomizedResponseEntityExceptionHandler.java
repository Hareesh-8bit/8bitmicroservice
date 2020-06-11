package com.bitmicro.bitmicro.Excpetion;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bitmicro.bitmicro.user.UserNotFoundException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) throws Exception{
		
		ExceptionResponse expectionResonse=new ExceptionResponse(new Date(),ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(expectionResonse,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception{
		
		ExceptionResponse expectionResonse=new ExceptionResponse(new Date(),ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(expectionResonse,HttpStatus.NOT_FOUND);
		}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		ExceptionResponse expectionResponse = new ExceptionResponse(new Date(),ex.getMessage(),ex.getBindingResult().toString());
		return new ResponseEntity(expectionResponse, HttpStatus.BAD_REQUEST);
	}

}
