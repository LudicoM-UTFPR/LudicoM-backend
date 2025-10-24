package com.ludicom.backend.exception;

/**
 * Exception thrown when trying to create a resource that already exists
 */
public class ResourceAlreadyExistsException extends RuntimeException {
    
    public ResourceAlreadyExistsException(String message) {
        super(message);
    }
    
    public ResourceAlreadyExistsException(String resource, String field, String value) {
        super(String.format("%s já existe com %s: %s", resource, field, value));
    }
}
