package com.example.daedongv3_5.infra.exception;

import com.example.daedongv3_5.global.error.exception.DaedongException;
import com.example.daedongv3_5.global.error.exception.ErrorCode;

public class ImageNotFoundException extends DaedongException {

    public static final DaedongException EXCEPTION = new ImageNotFoundException();

    private ImageNotFoundException() {
        super(ErrorCode.IMAGE_NOT_FOUND);
    }

}