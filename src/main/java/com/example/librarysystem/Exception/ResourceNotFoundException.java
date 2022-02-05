package com.example.librarysystem.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private final String resourceName;
    private final String fieldName;
    private final Object fieldVal;

    public ResourceNotFoundException(String message, String resourceName, String fieldName, Object fieldVal) {
        super(String.format("%s not found with %s: %s",resourceName,fieldName,fieldVal));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldVal = fieldVal;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldVal() {
        return fieldVal;
    }
}
