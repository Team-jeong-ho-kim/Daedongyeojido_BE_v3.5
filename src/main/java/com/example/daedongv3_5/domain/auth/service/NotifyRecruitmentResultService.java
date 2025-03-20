package com.example.daedongv3_5.domain.auth.service;

import com.example.daedongv3_5.domain.auth.exception.NoPermissionException;
import com.example.daedongv3_5.domain.auth.service.facade.UserFacade;
import com.example.daedongv3_5.domain.club.domain.Club;
import com.example.daedongv3_5.domain.club.domain.repository.ClubRepository;
import com.example.daedongv3_5.domain.club.exception.ClubNotFoundException;
import com.example.daedongv3_5.domain.recruitment.domain.Recruitment;
import com.example.daedongv3_5.domain.recruitment.domain.enums.RecruitmentStatus;
import com.example.daedongv3_5.domain.recruitment.domain.repository.RecruitmentRepository;
import com.example.daedongv3_5.domain.recruitment.exception.RecruitmentNotFoundException;
import com.example.daedongv3_5.domain.student.domain.StudentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class NotifyRecruitmentResultService {
    private final RecruitmentRepository recruitmentRepository;
    private final ClubRepository clubRepository;
    private final UserFacade userFacade;

    @Transactional
    public void pass(Long id) {
        StudentEntity student = userFacade.currentUser();

        Recruitment recruitment = recruitmentRepository.findById(id)
                .orElseThrow(() -> RecruitmentNotFoundException.EXCEPTION);

        Club club = clubRepository.findRecruitmentByClubName(recruitment.getClub().getClubName())
                .orElseThrow(() -> ClubNotFoundException.EXCEPTION);

        if (!club.getCreatedBy().equals(student.getAccountId())) {
            throw NoPermissionException.EXCEPTION;
        }

        recruitment.changeStatus(RecruitmentStatus.ACCEPTED);
    }

    @Transactional
    public void failed(Long id) {
        StudentEntity student = userFacade.currentUser();

        Recruitment recruitment = recruitmentRepository.findById(id)
                .orElseThrow(() -> RecruitmentNotFoundException.EXCEPTION);

        Club club = clubRepository.findRecruitmentByClubName(recruitment.getClub().getClubName())
                        .orElseThrow(() -> ClubNotFoundException.EXCEPTION);

        if (!club.getCreatedBy().equals(student.getAccountId())) {
            throw NoPermissionException.EXCEPTION;
        }

        recruitment.changeStatus(RecruitmentStatus.REJECTED);
    }
}
