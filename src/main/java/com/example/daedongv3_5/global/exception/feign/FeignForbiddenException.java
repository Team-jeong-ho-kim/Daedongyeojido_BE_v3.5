package com.example.daedongv3_5.global.exception.feign;

import com.example.daedongv3_5.global.error.exception.DaedongException;
import com.example.daedongv3_5.global.error.exception.ErrorCode;

public class FeignForbiddenException extends DaedongException {

    public static final DaedongException EXCEPTION = new FeignForbiddenException();

    private FeignForbiddenException(){
        super(ErrorCode.FEIGN_FORBIDDDEN_EXCEPTION);
    }
}
