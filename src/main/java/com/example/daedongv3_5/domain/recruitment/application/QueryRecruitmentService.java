package com.example.daedongv3_5.domain.recruitment.application;

import com.example.daedongv3_5.domain.recruitment.domain.Recruitment;
import com.example.daedongv3_5.domain.recruitment.domain.repository.RecruitmentRepository;
import com.example.daedongv3_5.domain.recruitment.exception.RecruitmentNotFoundException;
import com.example.daedongv3_5.domain.recruitment.presentation.dto.response.RecruitmentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class QueryRecruitmentService {

    private final RecruitmentRepository recruitmentRepository;

    @Transactional(readOnly = true)
    public RecruitmentResponse getRecruitmentById(Long id) {
        Recruitment recruitment = recruitmentRepository.findById(id)
                .orElseThrow(() -> RecruitmentNotFoundException.EXCEPTION);

        return RecruitmentResponse.builder()
            .id(recruitment.getId())
            .introduction(recruitment.getIntroduction())
            .phoneNumber(recruitment.getPhoneNumber())
            .majors(new ArrayList<>(recruitment.getMajors()))
            .taskLink(recruitment.getTaskLink())
            .status(recruitment.getStatus())
            .build();
    }

}