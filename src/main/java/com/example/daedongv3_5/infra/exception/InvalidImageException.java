package com.example.daedongv3_5.infra.exception;

import com.example.daedongv3_5.global.error.exception.DaedongException;
import com.example.daedongv3_5.global.error.exception.ErrorCode;

public class InvalidImageException extends DaedongException {

    public static final DaedongException EXCEPTION = new InvalidImageException();

    private InvalidImageException() {
        super(ErrorCode.INVALID_IMAGE);
    }

}