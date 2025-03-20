package com.example.daedongv3_5.domain.announcement.exception;

import com.example.daedongv3_5.global.error.exception.DaedongException;
import com.example.daedongv3_5.global.error.exception.ErrorCode;

public class AnnouncementNotFoundException extends DaedongException {
    public static final AnnouncementNotFoundException EXCEPTION = new AnnouncementNotFoundException();

    public AnnouncementNotFoundException() {
        super(ErrorCode.ANNOUNCEMENT_NOT_FOUND);
    }
}
