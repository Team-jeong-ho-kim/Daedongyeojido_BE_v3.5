package com.example.daedongv3_5.domain.recruitment.presentation;

import com.example.daedongv3_5.domain.recruitment.application.CreateRecruitmentService;
import com.example.daedongv3_5.domain.recruitment.application.DeleteRecruitmentService;
import com.example.daedongv3_5.domain.recruitment.application.QueryRecruitmentService;
import com.example.daedongv3_5.domain.recruitment.application.UpdateRecruitmentService;
import com.example.daedongv3_5.domain.recruitment.presentation.dto.request.RecruitmentRequest;
import com.example.daedongv3_5.domain.recruitment.presentation.dto.response.RecruitmentResponse;
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
    private final DeleteRecruitmentService deleteRecruitmentService;
    private final QueryRecruitmentService queryRecruitmentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createRecruitment(@RequestBody @Valid RecruitmentRequest request) {
        createRecruitmentService.createRecruitment(request);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateRecruitment(@RequestBody @Valid RecruitmentRequest request) {
        updateRecruitmentService.updateRecruitment(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRecruitment(@PathVariable Long id) {
        deleteRecruitmentService.deleteRecruitment(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RecruitmentResponse getRecruitment(@PathVariable Long id) {
        return queryRecruitmentService.getRecruitmentById(id);
    }

}