package com.example.daedongv3_5.domain.recruitment.exception;

import com.example.daedongv3_5.global.error.exception.DaedongException;
import com.example.daedongv3_5.global.error.exception.ErrorCode;

public class CannotQueryRecruitmentException extends DaedongException {
    public static final CannotQueryRecruitmentException EXCEPTION = new CannotQueryRecruitmentException();

    private CannotQueryRecruitmentException() {
        super(ErrorCode.CANNOT_QUERY_RECRUITMENT);
    }
}
