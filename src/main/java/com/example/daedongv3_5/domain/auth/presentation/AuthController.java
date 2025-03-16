package com.example.daedongv3_5.domain.auth.presentation;

import com.example.daedongv3_5.domain.auth.presentation.dto.request.LoginRequest;
import com.example.daedongv3_5.domain.auth.presentation.dto.response.TokenResponse;
import com.example.daedongv3_5.domain.auth.service.ReissueTokenService;
import com.example.daedongv3_5.domain.auth.service.StudentLoginService;
import com.example.daedongv3_5.domain.auth.service.TeacherLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final ReissueTokenService reissueTokenService;
    private final StudentLoginService studentLoginService;
    private final TeacherLoginService teacherLoginService;

    @PostMapping("/student")
    TokenResponse studentLogin(@RequestBody LoginRequest request) {
        return studentLoginService.studentLogin(request);
    }

    @PostMapping("/teacher")
    TokenResponse teacherLogin(@RequestBody LoginRequest request) {
        return teacherLoginService.teacherLogin(request);
    }

    @PutMapping("/token")
    TokenResponse reissueToken(@RequestHeader(name = "x-refresh-token") String token) {
        return reissueTokenService.reissueToken(token);
    }
}
