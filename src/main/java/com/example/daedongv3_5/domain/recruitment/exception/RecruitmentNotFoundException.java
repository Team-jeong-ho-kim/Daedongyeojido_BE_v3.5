package com.example.daedongv3_5.domain.recruitment.exception;

import com.example.daedongv3_5.global.error.exception.DaedongException;
import com.example.daedongv3_5.global.error.exception.ErrorCode;

public class RecruitmentNotFoundException extends DaedongException {

    public static final DaedongException EXCEPTION = new RecruitmentNotFoundException();

    private RecruitmentNotFoundException() {
        super(ErrorCode.RECRUITMENT_NOT_FOUND);
    }

}