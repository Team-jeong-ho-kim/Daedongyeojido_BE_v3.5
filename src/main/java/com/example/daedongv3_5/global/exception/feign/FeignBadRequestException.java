package com.example.daedongv3_5.global.exception.feign;

import com.example.daedongv3_5.global.error.exception.DaedongException;
import com.example.daedongv3_5.global.error.exception.ErrorCode;

public class FeignBadRequestException extends DaedongException {

    public static final DaedongException EXCEPTION = new FeignBadRequestException();

    private FeignBadRequestException(){
        super(ErrorCode.FEIGN_BAD_REQUEST);
    }
}
