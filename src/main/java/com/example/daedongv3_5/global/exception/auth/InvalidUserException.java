package com.example.daedongv3_5.global.exception.auth;


import com.example.daedongv3_5.global.error.exception.DaedongException;
import com.example.daedongv3_5.global.error.exception.ErrorCode;

public class InvalidUserException extends DaedongException {

    public static final DaedongException EXCEPTION = new InvalidUserException();

    public InvalidUserException() {
        super(ErrorCode.INVALID_USER);
    }
}
