package com.example.daedongv3_5.global.exception.feign;

import com.example.daedongv3_5.global.error.exception.DaedongException;
import com.example.daedongv3_5.global.error.exception.ErrorCode;

public class FeignUnauthorizedException extends DaedongException {

    public static final DaedongException EXCEPTION = new FeignUnauthorizedException();

    private FeignUnauthorizedException(){
        super(ErrorCode.FEIGN_UNAUTHORIZED_EXCEPTION);
    }
}
