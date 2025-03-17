package com.example.daedongv3_5.domain.auth.service;

import com.example.daedongv3_5.domain.auth.presentation.dto.AuthElementDto;
import com.example.daedongv3_5.domain.auth.presentation.dto.request.LoginRequest;
import com.example.daedongv3_5.domain.auth.presentation.dto.response.TokenResponse;
import com.example.daedongv3_5.domain.student.domain.StudentEntity;
import com.example.daedongv3_5.domain.student.repository.StudentRepository;
import com.example.daedongv3_5.global.error.exception.ErrorCode;
import com.example.daedongv3_5.global.exception.auth.InvalidUserException;
import com.example.daedongv3_5.global.exception.auth.PasswordMismatchException;
import com.example.daedongv3_5.global.exception.external.ExternalException;
import com.example.daedongv3_5.global.exception.student.StudentNotFoundException;
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
public class StudentLoginService {
    private final StudentRepository studentRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final XquareClient xquareClient;
    private final PasswordEncoder passwordEncoder;
    //private final DefaultProfileImageProperties defaultProfileImageProperties;

    @Transactional
    public TokenResponse studentLogin(LoginRequest request) {
        return studentRepository.existsByAccountId(request.accountId())
                ? loginExistingStudent(request)
                : registerAndLoginNewStudent(request);
    }

    private TokenResponse loginExistingStudent(LoginRequest request) {
        final var student = studentRepository.findByAccountId(request.accountId())
                .orElseThrow(() -> StudentNotFoundException.EXCEPTION);

        if (!passwordEncoder.matches(request.password(), student.getPassword())) {
            throw PasswordMismatchException.EXCEPTION;
        }

        return getTokenResponse(String.valueOf(student.getId()));
    }

    private TokenResponse registerAndLoginNewStudent(LoginRequest request) {
        XquareUserResponse xquareUserResponse;
        xquareUserResponse = xquareClient.xquareUser(request);
        System.out.println(request.accountId());

//        try {
//            xquareUserResponse = xquareClient.xquareUser(request);
//        } catch (FeignException e) {
//            final var status = e.status();
//            if (status == 401) {
//                throw new ExternalException(ErrorCode.LOGIN_FAILED);
//            }
//            else {
//                throw new ExternalException(ErrorCode.XQUARE);
//            }
//        }

        if(!xquareUserResponse.getUserRole().equals("STU")) throw InvalidUserException.EXCEPTION;
        final var newStudent = createAndSaveNewStudent(xquareUserResponse);


        return getTokenResponse(String.valueOf(newStudent.getId()));
    }

    private TokenResponse getTokenResponse(String id) {
        return jwtTokenProvider.receiveToken(id, AuthElementDto.UserRole.STUDENT);
    }

    private StudentEntity createAndSaveNewStudent(XquareUserResponse xquareUserResponse) {


        return studentRepository.save(
                new StudentEntity(
                        xquareUserResponse.getAccountId(),
                        xquareUserResponse.getPassword(),
                        xquareUserResponse.getName(),
                        xquareUserResponse.getGrade(),
                        xquareUserResponse.getClassNum(),
                        xquareUserResponse.getNum()
                        //defaultProfileImageProperties.imageUrl(),

                )
        );
    }
}

