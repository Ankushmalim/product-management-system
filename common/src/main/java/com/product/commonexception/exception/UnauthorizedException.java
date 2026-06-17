package com.product.commonexception.exception;

public class UnauthorizedException
        extends RuntimeException {

    public UnauthorizedException(String message) {
        super(message);
    }
}