package com.example.daedongv3_5.domain.recruitment.exception;

import com.example.daedongv3_5.global.error.exception.DaedongException;
import com.example.daedongv3_5.global.error.exception.ErrorCode;

public class CannotCreateRecruitmentException extends DaedongException {
    public static final CannotCreateRecruitmentException EXCEPTION = new CannotCreateRecruitmentException();

    private CannotCreateRecruitmentException() {
        super(ErrorCode.CANNOT_CREATE_RECRUITMENT);
    }
}
