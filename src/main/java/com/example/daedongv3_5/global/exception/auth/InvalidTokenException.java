package com.example.daedongv3_5.global.exception.auth;

import com.example.daedongv3_5.global.error.exception.DaedongException;
import com.example.daedongv3_5.global.error.exception.ErrorCode;

public class InvalidTokenException extends DaedongException {

    public static final DaedongException EXCEPTION = new InvalidTokenException();

    public InvalidTokenException() {
        super(ErrorCode.INVALID_TOKEN);
    }
}