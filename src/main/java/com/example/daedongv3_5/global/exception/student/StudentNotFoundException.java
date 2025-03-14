package com.example.daedongv3_5.global.exception.student;

import com.example.daedongv3_5.global.error.exception.DaedongException;
import com.example.daedongv3_5.global.error.exception.ErrorCode;

public class StudentNotFoundException extends DaedongException {

    public static final DaedongException EXCEPTION = new StudentNotFoundException();

    public StudentNotFoundException() {
        super(ErrorCode.STUDENT_NOT_FOUND);
    }
}
