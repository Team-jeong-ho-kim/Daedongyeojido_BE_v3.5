package com.example.daedongv3_5.domain.club.exception;

import com.example.daedongv3_5.domain.recruitment.exception.CannotUpdateRecruitmentException;
import com.example.daedongv3_5.global.error.exception.DaedongException;
import com.example.daedongv3_5.global.error.exception.ErrorCode;

public class CannotUpdateClubInfoException extends DaedongException {
    public static final CannotUpdateClubInfoException EXCEPTION = new CannotUpdateClubInfoException();

    public CannotUpdateClubInfoException() {
        super(ErrorCode.CANNOT_UPDATE_CLUB);
    }
}
