package com.example.demo.globalException;

public class ResourceNotFoundException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    // Constructor that accepts the exception message
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
