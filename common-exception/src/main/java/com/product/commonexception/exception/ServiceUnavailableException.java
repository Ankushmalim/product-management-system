package com.product.commonexception.exception;

public class ServiceUnavailableException
        extends RuntimeException {

    public ServiceUnavailableException(String message) {
        super(message);
    }
}