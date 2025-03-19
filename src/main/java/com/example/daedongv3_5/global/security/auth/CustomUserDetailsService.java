package com.example.daedongv3_5.global.security.auth;


import com.example.daedongv3_5.domain.auth.presentation.dto.AuthElementDto;
import com.example.daedongv3_5.domain.student.repository.StudentRepository;
import com.example.daedongv3_5.domain.teacher.repository.TeacherRepository;
import com.example.daedongv3_5.global.exception.auth.InvalidTokenException;
import com.example.daedongv3_5.global.exception.student.StudentNotFoundException;
import com.example.daedongv3_5.global.exception.teacher.TeacherNotFoundException;
import com.example.daedongv3_5.global.security.jwt.JwtProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final JwtProperties jwtProperties;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String accountId) {
        var parts = accountId.split(":");

        var userId = parts[0];
        var userSecretId = parts[1];
        String type;

        if (userSecretId.equals(jwtProperties.teacherSecret())) {
            type = handleTeacher(Long.valueOf(userId));
        } else if (userSecretId.equals(jwtProperties.studentSecret())) {
            type = handleStudent(Long.valueOf(userId));
        } else {
            throw InvalidTokenException.EXCEPTION;
        }

        return new CustomUserDetails(accountId, type);
    }

    private String handleTeacher(Long teacherId) {
        if (!teacherRepository.existsById(teacherId)) {
            throw TeacherNotFoundException.EXCEPTION;
        }

        return AuthElementDto.UserRole.TEACHER.name();
    }

    private String handleStudent(Long studentId) {
        if (!studentRepository.existsById(studentId)) {
            throw StudentNotFoundException.EXCEPTION;
        }

        return AuthElementDto.UserRole.STUDENT.name();
    }
}
