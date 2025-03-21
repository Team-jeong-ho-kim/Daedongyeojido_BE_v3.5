package com.example.daedongv3_5.domain.auth.presentation;

import com.example.daedongv3_5.domain.auth.presentation.dto.request.LoginRequest;
import com.example.daedongv3_5.domain.auth.presentation.dto.response.TokenResponse;
import com.example.daedongv3_5.domain.auth.service.NotifyRecruitmentResultService;
import com.example.daedongv3_5.domain.auth.service.ReissueTokenService;
import com.example.daedongv3_5.domain.auth.service.StudentLoginService;
import com.example.daedongv3_5.domain.auth.service.TeacherLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final ReissueTokenService reissueTokenService;
    private final StudentLoginService studentLoginService;
    private final TeacherLoginService teacherLoginService;
    private final NotifyRecruitmentResultService notifyRecruitmentResultService;

    @PostMapping("/student")
    @ResponseStatus(HttpStatus.OK)
    TokenResponse studentLogin(@RequestBody LoginRequest request) {
        return studentLoginService.studentLogin(request);
    }

    @PostMapping("/teacher")
    @ResponseStatus(HttpStatus.OK)
    TokenResponse teacherLogin(@RequestBody LoginRequest request) {
        return teacherLoginService.teacherLogin(request);
    }

    @PutMapping("/token")
    @ResponseStatus(HttpStatus.OK)
    TokenResponse reissueToken(@RequestHeader(name = "x-refresh-token") String token) {
        return reissueTokenService.reissueToken(token);
    }

    @PostMapping("/pass/{id}")
    public void pass(@PathVariable Long id) {
        notifyRecruitmentResultService.pass(id);
    }

    @PostMapping("/failed/{id}")
        public void failed(@PathVariable Long id) {
            notifyRecruitmentResultService.failed(id);
    }
}
