package com.example.daedongv3_5.domain.recruitment.application;

import com.example.daedongv3_5.domain.announcement.domain.Announcement;
import com.example.daedongv3_5.domain.announcement.domain.enums.AnnouncementStatus;
import com.example.daedongv3_5.domain.announcement.domain.repository.AnnouncementRepository;
import com.example.daedongv3_5.domain.announcement.exception.AnnouncementNotFoundException;
import com.example.daedongv3_5.domain.auth.service.facade.UserFacade;
import com.example.daedongv3_5.domain.club.domain.Club;
import com.example.daedongv3_5.domain.club.domain.repository.ClubRepository;
import com.example.daedongv3_5.domain.club.exception.ClubNotFoundException;
import com.example.daedongv3_5.domain.recruitment.domain.Recruitment;
import com.example.daedongv3_5.domain.recruitment.domain.enums.RecruitmentStatus;
import com.example.daedongv3_5.domain.recruitment.domain.repository.RecruitmentRepository;
import com.example.daedongv3_5.domain.recruitment.exception.CannotCreateRecruitmentException;
import com.example.daedongv3_5.domain.recruitment.presentation.dto.request.RecruitmentRequest;
import com.example.daedongv3_5.domain.student.domain.StudentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateRecruitmentService {

    private final RecruitmentRepository recruitmentRepository;
    private final AnnouncementRepository announcementRepository;
    private final ClubRepository clubRepository;
    private final UserFacade userFacade;

    @Transactional
    public void createRecruitment(RecruitmentRequest request) {
        Club club = clubRepository.findRecruitmentByClubName(request.getClubName())
                        .orElseThrow(() -> ClubNotFoundException.EXCEPTION);

        StudentEntity student = userFacade.currentUser();

        Announcement announcement = announcementRepository.findAnnouncementByClub_ClubName(request.getClubName())
                .orElseThrow(() -> AnnouncementNotFoundException.EXCEPTION);

        if (announcement.getAnnouncementStatus() != AnnouncementStatus.SubmissionPossible) {
            throw CannotCreateRecruitmentException.EXCEPTION;
        }

        recruitmentRepository.save(Recruitment.builder()
                .introduction(request.getIntroduction())
                .phoneNumber(request.getPhoneNumber())
                .majors(request.getMajors())
                .taskLink(request.getTaskLink())
                .status(RecruitmentStatus.SUBMITTED)
                .club(club)
                .createdBy(student.getAccountId())
                .student(student)
            .build());
    }

}