package com.example.demo.exception;

public class InvalidRequestException extends RuntimeException {
    /**
     * Author : Sanket Nadargi
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidRequestException(String message) {
        super(message);
    }
}
