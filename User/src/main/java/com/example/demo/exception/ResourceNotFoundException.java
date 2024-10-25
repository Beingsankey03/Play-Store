package com.example.demo.exception;

public class ResourceNotFoundException extends RuntimeException {
    /**
     * Author : Sanket Nadargi
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String message) {
        super(message);
    }
}
