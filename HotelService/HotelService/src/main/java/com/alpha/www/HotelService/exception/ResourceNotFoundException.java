package com.alpha.www.HotelService.exception;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException() {
		super("resource not found on server");
	}

	public ResourceNotFoundException(String message) {
		super(message);
	}

	
}
