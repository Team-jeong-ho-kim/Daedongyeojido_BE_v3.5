package com.example.daedongv3_5.domain.recruitment.exception;

import com.example.daedongv3_5.global.error.exception.DaedongException;
import com.example.daedongv3_5.global.error.exception.ErrorCode;

public class CannotDeleteRecruitmentException extends DaedongException {

    public static final DaedongException EXCEPTION = new CannotDeleteRecruitmentException();

    private CannotDeleteRecruitmentException() {
        super(ErrorCode.CANNOT_DELETE_RECRUITMENT);
    }

}