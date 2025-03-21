package com.example.daedongv3_5.domain.announcement.exception;

import com.example.daedongv3_5.global.error.exception.DaedongException;
import com.example.daedongv3_5.global.error.exception.ErrorCode;

public class DeadlineIsOverException extends DaedongException {
    public static final DeadlineIsOverException EXCEPTION = new DeadlineIsOverException();

    private DeadlineIsOverException() {
        super(ErrorCode.DEADLINE_IS_OVER);
    }
}
