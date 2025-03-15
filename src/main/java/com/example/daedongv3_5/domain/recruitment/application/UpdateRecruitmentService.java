package com.example.daedongv3_5.domain.recruitment.application;

import com.example.daedongv3_5.domain.recruitment.application.facade.RecruitmentFacade;
import com.example.daedongv3_5.domain.recruitment.domain.Recruitment;
import com.example.daedongv3_5.domain.recruitment.presentation.dto.request.RecruitmentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateRecruitmentService {

    private final RecruitmentFacade recruitmentFacade;

    @Transactional
    public void updateRecruitment(Long recruitmentId, RecruitmentRequest request) {
        Recruitment recruitment = recruitmentFacade.getRecruitment(recruitmentId);

        recruitment.update(request);
    }

}