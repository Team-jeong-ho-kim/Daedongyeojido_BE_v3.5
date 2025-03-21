package com.example.daedongv3_5.domain.auth.exception;

import com.example.daedongv3_5.global.error.exception.DaedongException;
import com.example.daedongv3_5.global.error.exception.ErrorCode;

public class NoPermissionException extends DaedongException {
    public static final NoPermissionException EXCEPTION = new NoPermissionException();

    public NoPermissionException() {
        super(ErrorCode.NO_PERMISSION);
    }
}
