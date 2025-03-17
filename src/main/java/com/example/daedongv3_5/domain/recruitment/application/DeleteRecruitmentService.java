package com.example.daedongv3_5.domain.recruitment.application;

import com.example.daedongv3_5.domain.recruitment.domain.Recruitment;
import com.example.daedongv3_5.domain.recruitment.domain.repository.RecruitmentRepository;
import com.example.daedongv3_5.domain.recruitment.exception.RecruitmentNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteRecruitmentService {

    private final RecruitmentRepository recruitmentRepository;

    @Transactional
    public void deleteRecruitment(Long recruitmentId) {
        Recruitment recruitment = recruitmentRepository.findById(recruitmentId)
                .orElseThrow(() -> RecruitmentNotFoundException.EXCEPTION);

        recruitmentRepository.delete(recruitment);
    }

}