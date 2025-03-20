package com.example.daedongv3_5.domain.recruitment.application;

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

@Service
@RequiredArgsConstructor
public class NotifyRecruitmentResultService {
    private final RecruitmentRepository recruitmentRepository;
    private final ClubRepository clubRepository;
    private final UserFacade userFacade;

    public void pass() {
        StudentEntity student = userFacade.currentUser();

        Recruitment recruitment = recruitmentRepository.findRecruitmentByAccountId(student.getAccountId())
                .orElseThrow(() -> RecruitmentNotFoundException.EXCEPTION);

        Club club = clubRepository.findRecruitmentByClubName(recruitment.getClub().getClubName())
                .orElseThrow(() -> ClubNotFoundException.EXCEPTION);

        if (!club.getCreatedBy().equals(student.getAccountId())) {
            throw NoPermissionException.EXCEPTION;
        }

        recruitmentRepository.save(Recruitment.builder()
                .status(RecruitmentStatus.ACCEPTED)
                .build());
    }

    public void failed() {
        StudentEntity student = userFacade.currentUser();

        Recruitment recruitment = recruitmentRepository.findRecruitmentByAccountId(student.getAccountId())
                .orElseThrow(() -> RecruitmentNotFoundException.EXCEPTION);

        Club club = clubRepository.findRecruitmentByClubName(recruitment.getClub().getClubName())
                        .orElseThrow(() -> ClubNotFoundException.EXCEPTION);

        if (!club.getCreatedBy().equals(student.getAccountId())) {
            throw NoPermissionException.EXCEPTION;
        }

        recruitmentRepository.save(Recruitment.builder()
                        .status(RecruitmentStatus.REJECTED)
                .build());
    }
}
