package com.example.daedongv3_5.global.xquare;


import com.example.daedongv3_5.global.feign.Custom5xxRetryer;
import com.example.daedongv3_5.global.feign.CustomErrorDecoder;
import feign.Retryer;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class XquareRetryConfiguartion {

    @Bean
    public Retryer retryer() {
        return new Custom5xxRetryer();
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new CustomErrorDecoder();
    }
}
