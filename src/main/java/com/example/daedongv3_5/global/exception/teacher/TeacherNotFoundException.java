package com.example.daedongv3_5.global.exception.teacher;

import com.example.daedongv3_5.global.error.exception.DaedongException;
import com.example.daedongv3_5.global.error.exception.ErrorCode;

public class TeacherNotFoundException extends DaedongException {

    public static final DaedongException EXCEPTION = new TeacherNotFoundException();

    public TeacherNotFoundException() {
        super(ErrorCode.TEACHER_NOT_FOUND);
    }
}
