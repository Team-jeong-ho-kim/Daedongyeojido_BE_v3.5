package com.example.daedongv3_5.domain.recruitment.application.facade;

import com.example.daedongv3_5.domain.recruitment.domain.Recruitment;
import com.example.daedongv3_5.domain.recruitment.domain.repository.RecruitmentRepository;
import com.example.daedongv3_5.domain.recruitment.exception.RecruitmentNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RecruitmentFacade {

    private final RecruitmentRepository recruitmentRepository;

    public Recruitment getRecruitment(Long id) {
        return recruitmentRepository.findById(id)
            .orElseThrow(() -> RecruitmentNotFoundException.EXCEPTION);
    }

}