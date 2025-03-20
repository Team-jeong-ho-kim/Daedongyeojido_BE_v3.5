package com.example.daedongv3_5.domain.announcement.exception;

import com.example.daedongv3_5.global.error.exception.DaedongException;
import com.example.daedongv3_5.global.error.exception.ErrorCode;

public class CannotDeleteAnnouncementException extends DaedongException {
    public static final CannotDeleteAnnouncementException EXCEPTION = new CannotDeleteAnnouncementException();

    public CannotDeleteAnnouncementException() {
        super(ErrorCode.CANNOT_DELETE_ANNOUNCEMENT);
    }
}
