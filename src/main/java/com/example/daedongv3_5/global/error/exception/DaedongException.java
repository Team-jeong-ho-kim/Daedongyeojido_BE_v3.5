package com.example.daedongv3_5.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DaedongException extends RuntimeException{
    private final ErrorCode errorCode;

}
