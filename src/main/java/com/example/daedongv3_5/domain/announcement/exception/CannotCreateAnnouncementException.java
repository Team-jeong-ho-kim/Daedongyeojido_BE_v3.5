package com.example.daedongv3_5.domain.announcement.exception;

import com.example.daedongv3_5.global.error.exception.DaedongException;
import com.example.daedongv3_5.global.error.exception.ErrorCode;

public class CannotCreateAnnouncementException extends DaedongException {
    public static final CannotCreateAnnouncementException EXCEPTION = new CannotCreateAnnouncementException();

    public CannotCreateAnnouncementException() {
        super(ErrorCode.CANNOT_CREATE_ANNOUNCEMENT);
    }
}
