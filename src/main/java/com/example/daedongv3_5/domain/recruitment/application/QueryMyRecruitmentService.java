package com.example.daedongv3_5.domain.recruitment.application;

import com.example.daedongv3_5.domain.auth.service.facade.UserFacade;
import com.example.daedongv3_5.domain.recruitment.domain.Recruitment;
import com.example.daedongv3_5.domain.recruitment.domain.repository.RecruitmentRepository;
import com.example.daedongv3_5.domain.recruitment.exception.CannotQueryRecruitmentException;
import com.example.daedongv3_5.domain.recruitment.exception.RecruitmentNotFoundException;
import com.example.daedongv3_5.domain.recruitment.presentation.dto.response.RecruitmentListResponse;
import com.example.daedongv3_5.domain.student.domain.StudentEntity;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryMyRecruitmentService {
    private final RecruitmentRepository recruitmentRepository;
    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public List<RecruitmentListResponse> queryMyRecruitment() {
        StudentEntity student = userFacade.currentUser();

        Recruitment recruitment = recruitmentRepository.findRecruitmentByCreatedBy(student.getAccountId())
                .orElseThrow(() -> RecruitmentNotFoundException.EXCEPTION);

        if (!recruitment.getCreatedBy().equals(student.getAccountId())) {
            throw CannotQueryRecruitmentException.EXCEPTION;
        }

        return recruitmentRepository.findByCreatedBy(student.getAccountId())
                .stream()
                .map(recruitment2 -> new RecruitmentListResponse(recruitment))
                .collect(Collectors.toList());
    }
}
