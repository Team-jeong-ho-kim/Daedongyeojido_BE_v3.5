package com.example.daedongv3_5.global.exception.auth;


public class NotAuthenticatedException extends RuntimeException {

    public NotAuthenticatedException(String message) {
        super(message);
    }
}
