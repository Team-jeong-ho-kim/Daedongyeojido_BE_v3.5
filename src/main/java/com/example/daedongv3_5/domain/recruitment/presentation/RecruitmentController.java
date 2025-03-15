package com.example.daedongv3_5.domain.recruitment.presentation;

import com.example.daedongv3_5.domain.recruitment.application.CreateRecruitmentService;
import com.example.daedongv3_5.domain.recruitment.application.UpdateRecruitmentService;
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
    private final UpdateRecruitmentService updateRecruitmentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createRecruitment(@RequestBody @Valid RecruitmentRequest request) {
        createRecruitmentService.createRecruitment(request);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateRecruitment(@PathVariable Long id, @RequestBody @Valid RecruitmentRequest request) {
        updateRecruitmentService.updateRecruitment(id, request);
    }

}