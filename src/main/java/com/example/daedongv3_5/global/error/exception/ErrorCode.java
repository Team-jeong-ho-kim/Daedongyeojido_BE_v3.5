package com.example.daedongv3_5.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
@AllArgsConstructor
public enum ErrorCode {
    // jwt
    EXPIRED_TOKEN(401, "만료된 토큰입니다."),
    INVALID_TOKEN(401, "검증되지 않은 토큰입니다."),
    REFRESH_TOKEN_NOT_FOUND(404, "일치하는 리프레쉬토큰이 존재하지 않습니다."),

    // user
    USER_NOT_FOUND(404, "일치하는 유저가 존재하지 않습니다."),
    USER_MISMATCH(401, "유저가 일치하지 않습니다."),
    PASSWORD_MISMATCH(401, "비밀번호가 일치하지 않습니다."),
    INVALID_USER(401, "유효하지 않는 사용자입니다."),
    USER_ALREADY_TAKEN(401, "이미 유저가 있습니다"),

    //club
    CLUB_NOT_FOUND(404, "존재하지 않는 동아리 입니다."),
    CANNOT_DELETE_CLUB(403, "삭제할 수 있는 권한이 없습니다"),
    CANNOT_UPDATE_CLUB(403, "수정 권한이 없습니다"),

    // general
    BAD_REQUEST(400, "프론트 탓이 확실하다.."),
    INTERNAL_SERVER_ERROR(500, "서버 탓일 수도 있고.."),

    // key
    INVALID_KEY(401, "잘못된 key입니다."),

    // image
    DELETE_IMAGE_FAILED(500, "이미지 삭제에 실패했습니다."),
    IMAGE_NOT_FOUND(404, "이미지를 찾을 수 없습니다."),
    INVALID_IMAGE(400, "유효하지 않은 이미지 입니다."),

    //feign
    FEIGN_BAD_REQUEST(401, "Feign Bad Reqeust"),
    FEIGN_UNAUTHORIZED_EXCEPTION(402, "Feign Unauthorized Exception"),
    FEIGN_FORBIDDDEN_EXCEPTION(403, "Feign Forbidden Exception"),

    XQUARE(503, "DSM-login 서비스에서 에러가 발생했습니다."),
    LOGIN_FAILED(401, "로그인 정보를 다시 확인해주세요."),

    FORBIDDEN(403, "접근 권한이 없는 유저입니다."),

    // student
    STUDENT_NOT_FOUND(404, "일치하는 학생을 찾을 수 없습니다."),

    // teacher
    TEACHER_NOT_FOUND(404, "일치하는 선생님을 찾을 수 없습니다."),

    // recruitment
    RECRUITMENT_NOT_FOUND(404, "해당하는 지원서를 찾을 수 없습니다."),
    CANNOT_UPDATE_RECRUITMENT(403, "지원서를 수정할 수 없습니다."),
    CANNOT_DELETE_RECRUITMENT(403, "지원서를 삭제할 수 없습니다.");

    private final int statusCode;
    private final String message;
}