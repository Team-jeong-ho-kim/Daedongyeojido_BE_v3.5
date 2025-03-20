package com.example.daedongv3_5.domain.recruitment.presentation;

import com.example.daedongv3_5.domain.recruitment.application.*;
import com.example.daedongv3_5.domain.recruitment.presentation.dto.request.RecruitmentRequest;
import com.example.daedongv3_5.domain.recruitment.presentation.dto.request.UpdateRecruitmentRequest;
import com.example.daedongv3_5.domain.recruitment.presentation.dto.response.RecruitmentListResponse;
import com.example.daedongv3_5.domain.recruitment.presentation.dto.response.RecruitmentResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recruitment")
@RequiredArgsConstructor
public class RecruitmentController {

    private final CreateRecruitmentService createRecruitmentService;
    private final UpdateRecruitmentService updateRecruitmentService;
    private final DeleteRecruitmentService deleteRecruitmentService;
    private final QueryRecruitmentService queryRecruitmentService;
    private final QueryRecruitmentListService queryRecruitmentListService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createRecruitment(@RequestBody @Valid RecruitmentRequest request) {
        createRecruitmentService.createRecruitment(request);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateRecruitment(@RequestBody @Valid UpdateRecruitmentRequest request) {
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

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<RecruitmentListResponse> queryRecruitmentList(@RequestParam String clubName) {
        return queryRecruitmentListService.queryRecruitmentList(clubName);
    }

}