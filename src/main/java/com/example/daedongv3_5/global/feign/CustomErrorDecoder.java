package com.example.daedongv3_5.global.feign;

import com.example.daedongv3_5.global.exception.feign.FeignBadRequestException;
import com.example.daedongv3_5.global.exception.feign.FeignForbiddenException;
import com.example.daedongv3_5.global.exception.feign.FeignUnauthorizedException;
import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;


public class CustomErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response){
        var exception = errorDecoder.decode(methodKey, response);

        if(response != null && response.status() >= 400) {
            switch (response.status()) {
                case 400:
                    return FeignBadRequestException.EXCEPTION;
                case 401:
                    return FeignUnauthorizedException.EXCEPTION;
                case 403:
                    return FeignForbiddenException.EXCEPTION;
                default:
                    if (response.status() >= 500) {
                        return new RetryableException(
                                response.status(),
                                exception.getMessage(),
                                response.request().httpMethod(),
                                exception,
                                (Long) null,
                                response.request()
                        );
                    }
                    break;
            }

        }
        return exception;
    }
}
