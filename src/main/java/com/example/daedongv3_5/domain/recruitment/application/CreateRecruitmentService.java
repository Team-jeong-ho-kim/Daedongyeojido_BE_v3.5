package com.example.daedongv3_5.domain.recruitment.application;

import com.example.daedongv3_5.domain.recruitment.domain.Recruitment;
import com.example.daedongv3_5.domain.recruitment.domain.RecruitmentStatus;
import com.example.daedongv3_5.domain.recruitment.domain.repository.RecruitmentRepository;
import com.example.daedongv3_5.domain.recruitment.presentation.dto.request.RecruitmentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateRecruitmentService {

    private final RecruitmentRepository recruitmentRepository;

    @Transactional
    public void createRecruitment(RecruitmentRequest request) {
        recruitmentRepository.save(Recruitment.builder()
                .introduction(request.getIntroduction())
                .phoneNumber(request.getPhoneNumber())
                .majors(request.getMajors())
                .taskLink(request.getTaskLink())
                .status(RecruitmentStatus.SUBMITTED)
            .build());
    }

}