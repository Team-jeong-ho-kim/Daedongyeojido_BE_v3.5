package com.example.daedongv3_5.domain.club.exception;

import com.example.daedongv3_5.global.error.exception.DaedongException;
import com.example.daedongv3_5.global.error.exception.ErrorCode;

public class ClubNotFoundException extends DaedongException {
    public static final ClubNotFoundException EXCEPTION = new ClubNotFoundException();

    private ClubNotFoundException() {
        super(ErrorCode.CLUB_NOT_FOUND);
    }
}
