package com.example.daedongv3_5.domain.recruitment.application;

import com.example.daedongv3_5.domain.auth.service.facade.UserFacade;
import com.example.daedongv3_5.domain.club.exception.CannotUpdateClubInfoException;
import com.example.daedongv3_5.domain.recruitment.domain.Recruitment;
import com.example.daedongv3_5.domain.recruitment.domain.repository.RecruitmentRepository;
import com.example.daedongv3_5.domain.recruitment.exception.RecruitmentNotFoundException;
import com.example.daedongv3_5.domain.recruitment.presentation.dto.request.RecruitmentRequest;
import com.example.daedongv3_5.domain.student.domain.StudentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateRecruitmentService {

    private final RecruitmentRepository recruitmentRepository;
    private final UserFacade userFacade;

    @Transactional
    public void updateRecruitment(RecruitmentRequest request) {
        Recruitment recruitment = recruitmentRepository.findById(request.getId())
                        .orElseThrow(() -> RecruitmentNotFoundException.EXCEPTION);

        StudentEntity student = userFacade.currentUser();

        if (!recruitment.getCreatedBy().equals(student.getAccountId())) {
            throw CannotUpdateClubInfoException.EXCEPTION;
        }

        recruitment.update(request);
    }

}