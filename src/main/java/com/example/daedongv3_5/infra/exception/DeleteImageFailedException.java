package com.example.daedongv3_5.infra.exception;

import com.example.daedongv3_5.global.error.exception.DaedongException;
import com.example.daedongv3_5.global.error.exception.ErrorCode;

public class DeleteImageFailedException extends DaedongException {

    public static final DaedongException EXCEPTION = new DeleteImageFailedException();

    private DeleteImageFailedException() {
        super(ErrorCode.DELETE_IMAGE_FAILED);
    }

}