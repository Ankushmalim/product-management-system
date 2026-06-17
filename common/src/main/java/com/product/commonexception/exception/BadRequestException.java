package com.product.commonexception.exception;

public class BadRequestException
        extends RuntimeException {

    public BadRequestException(String message) {
        super(message);
    }
}