package com.example.daedongv3_5.domain.club.exception;

import com.example.daedongv3_5.global.error.exception.DaedongException;
import com.example.daedongv3_5.global.error.exception.ErrorCode;

public class CannotDeleteClubException extends DaedongException {
    public static final CannotDeleteClubException EXCEPTION = new CannotDeleteClubException();

     private CannotDeleteClubException() {
        super(ErrorCode.CANNOT_DELETE_CLUB);
    }
}
