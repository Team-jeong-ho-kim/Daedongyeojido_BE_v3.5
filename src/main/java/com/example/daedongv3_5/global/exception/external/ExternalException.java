package com.example.daedongv3_5.global.exception.external;

import com.example.daedongv3_5.global.error.exception.DaedongException;
import com.example.daedongv3_5.global.error.exception.ErrorCode;

public class ExternalException extends DaedongException {
    public ExternalException(final ErrorCode errorCode) {
        super(errorCode);
    }
}
