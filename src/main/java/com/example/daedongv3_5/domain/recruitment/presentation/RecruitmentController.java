package com.example.daedongv3_5.domain.recruitment.presentation;

import com.example.daedongv3_5.domain.recruitment.application.CreateRecruitmentService;
import com.example.daedongv3_5.domain.recruitment.presentation.dto.request.RecruitmentRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recruitment")
@RequiredArgsConstructor
public class RecruitmentController {

    private final CreateRecruitmentService createRecruitmentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createRecruitment(@RequestBody @Valid RecruitmentRequest request) {
        createRecruitmentService.createRecruitment(request);
    }

}