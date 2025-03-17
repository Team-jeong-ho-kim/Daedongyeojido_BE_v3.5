package com.example.daedongv3_5.domain.recruitment.exception;

import com.example.daedongv3_5.global.error.exception.DaedongException;
import com.example.daedongv3_5.global.error.exception.ErrorCode;

public class CannotUpdateRecruitmentException extends DaedongException {

    public static final DaedongException EXCEPTION = new CannotUpdateRecruitmentException();

    private CannotUpdateRecruitmentException() {
        super(ErrorCode.CANNOT_UPDATE_RECRUITMENT);
    }

}