package com.casino.api.exeptions;

public class HttpMethodNotFoundException extends RuntimeException {
    public HttpMethodNotFoundException(String message) {
        super(message);
    }
}
