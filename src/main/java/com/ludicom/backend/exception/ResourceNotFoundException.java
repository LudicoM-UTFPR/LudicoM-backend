package com.ludicom.backend.exception;

/**
 * Exception thrown when a requested resource is not found
 */
public class ResourceNotFoundException extends RuntimeException {
    
    public ResourceNotFoundException(String message) {
        super(message);
    }
    
    public ResourceNotFoundException(String resource, String field, String value) {
        super(String.format("%s não encontrado com %s: %s", resource, field, value));
    }
}
