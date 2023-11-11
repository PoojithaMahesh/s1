package com.jsp.studentspringe2.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jsp.studentspringe2.util.ResponseStructure;
@RestControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler {

	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> idnotFoundException(UserIdNOtFoundException ex){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage("Sorry User Id Not Found");
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		List<ObjectError> list=ex.getAllErrors();
		
		Map<String, String> map=new HashMap<String, String>();
		for(ObjectError error:list) {
			String message=error.getDefaultMessage();
			String fieldName=((FieldError)error).getField();
			map.put(fieldName, message);
		}
		return new ResponseEntity<Object>(map,HttpStatus.BAD_REQUEST);
		
	}
	
	
}
