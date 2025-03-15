package com.example.daedongv3_5.domain.auth.service;

import com.example.daedongv3_5.domain.auth.presentation.dto.AuthElementDto;
import com.example.daedongv3_5.domain.auth.presentation.dto.request.LoginRequest;
import com.example.daedongv3_5.domain.auth.presentation.dto.response.TokenResponse;
import com.example.daedongv3_5.domain.teacher.domain.TeacherEntity;
import com.example.daedongv3_5.domain.teacher.repository.TeacherRepository;
import com.example.daedongv3_5.global.error.exception.ErrorCode;
import com.example.daedongv3_5.global.exception.auth.InvalidUserException;
import com.example.daedongv3_5.global.exception.auth.PasswordMismatchException;
import com.example.daedongv3_5.global.exception.external.ExternalException;
import com.example.daedongv3_5.global.exception.teacher.TeacherNotFoundException;
import com.example.daedongv3_5.global.security.jwt.JwtTokenProvider;
import com.example.daedongv3_5.global.xquare.XquareClient;
import com.example.daedongv3_5.global.xquare.dto.XquareUserResponse;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TeacherLoginService {
    private final TeacherRepository teacherRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final XquareClient xquareClient;


    @Transactional
    public TokenResponse teacherLogin(LoginRequest request) {
        return teacherRepository.existsByAccountId(request.accountId())
                ? loginExistingTeacher(request)
                : registerAndLoginNewTeacher(request);
    }

    private TokenResponse loginExistingTeacher(LoginRequest request) {
        final var teacher = teacherRepository.findByAccountId(request.accountId())
                .orElseThrow(() -> TeacherNotFoundException.EXCEPTION);

        if (!passwordEncoder.matches(request.password(), teacher.getPassword())) {
            throw PasswordMismatchException.EXCEPTION;
        }

        return jwtTokenProvider.receiveToken(String.valueOf(teacher.getId()), AuthElementDto.UserRole.TEACHER);
    }

    private TokenResponse registerAndLoginNewTeacher(LoginRequest request) {
        XquareUserResponse xquareResponse;

        try {
            xquareResponse = xquareClient.xquareUser(request);
        } catch (FeignException e) {
            final var status = e.status();
            if (status == 401) {
                throw new ExternalException(ErrorCode.LOGIN_FAILED);
            }
            else {
                throw new ExternalException(ErrorCode.XQUARE);
            }
        }

        if(!xquareResponse.getUserRole().equals("SCH")) throw InvalidUserException.EXCEPTION;
        final var newTeacher = createAndSaveNewTeacher(xquareResponse);

        return jwtTokenProvider.receiveToken(String.valueOf(newTeacher.getId()), AuthElementDto.UserRole.TEACHER);
    }

    private TeacherEntity createAndSaveNewTeacher(XquareUserResponse xquareResponse) {
        return teacherRepository.save(new TeacherEntity(xquareResponse));
    }
}
