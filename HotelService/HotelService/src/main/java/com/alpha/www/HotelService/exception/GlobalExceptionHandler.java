package com.alpha.www.HotelService.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.alpha.www.HotelService.payload.ApiResponse;


@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String, Object>> handleResourceNotFoundException(ResourceNotFoundException e){
		Map<String, Object> map=new HashMap<>();
		map.put("message", e.getMessage());
		map.put("success", true);
		map.put("status", HttpStatus.NOT_FOUND);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
	}
	
//	@ExceptionHandler(ResourceNotFoundException.class)
//	public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException exception){
//		String message = exception.getMessage();
//		ApiResponse response = ApiResponse.builder()
//				.message(message)
//				.success(true)
//				.status(HttpStatus.NOT_FOUND)
//				.build();
//		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
//	}
}
