package com.product.commonexception.exception;

public class ValidationException
        extends RuntimeException {

    public ValidationException(String message) {
        super(message);
    }
}
