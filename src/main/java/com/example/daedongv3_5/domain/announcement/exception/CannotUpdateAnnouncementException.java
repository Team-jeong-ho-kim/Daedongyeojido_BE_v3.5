package com.example.daedongv3_5.domain.announcement.exception;

import com.example.daedongv3_5.global.error.exception.DaedongException;
import com.example.daedongv3_5.global.error.exception.ErrorCode;

public class CannotUpdateAnnouncementException extends DaedongException {
    public static final CannotUpdateAnnouncementException EXCEPTION = new CannotUpdateAnnouncementException();

    public CannotUpdateAnnouncementException() {
        super(ErrorCode.CANNOT_UPDATE_ANNOUNCEMENT);
    }
}
