package com.example.daedongv3_5.domain.auth.service.facade;

import com.example.daedongv3_5.domain.student.domain.StudentEntity;
import com.example.daedongv3_5.domain.student.repository.StudentRepository;
import com.example.daedongv3_5.global.exception.auth.NotAuthenticatedException;
import com.example.daedongv3_5.global.exception.auth.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {
    private final StudentRepository studentRepository;

    public StudentEntity currentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication == null || !authentication.isAuthenticated()) {
            throw new NotAuthenticatedException("인증 되지 않은 유저입니다.");
        }

        return studentRepository.findByAccountId(authentication.getName())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
}
