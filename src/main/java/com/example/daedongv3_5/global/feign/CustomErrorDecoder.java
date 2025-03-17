package com.example.daedongv3_5.global.feign;

import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response){
        var exception = errorDecoder.decode(methodKey, response);

        if(response != null && response.status() >= 500) {
            return new RetryableException(
                    response.status(),
                    exception.getMessage(),
                    response.request().httpMethod(),
                    exception,
                    (Long) null,
                    response.request()
            );
        }
        return exception;
    }
}