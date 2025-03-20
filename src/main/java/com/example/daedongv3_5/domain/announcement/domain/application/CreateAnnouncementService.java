package com.example.daedongv3_5.domain.announcement.domain.application;

import com.example.daedongv3_5.domain.announcement.domain.Announcement;
import com.example.daedongv3_5.domain.announcement.domain.enums.AnnouncementStatus;
import com.example.daedongv3_5.domain.announcement.domain.repository.AnnouncementRepository;
import com.example.daedongv3_5.domain.announcement.exception.CannotCreateAnnouncementException;
import com.example.daedongv3_5.domain.announcement.presentation.dto.request.AnnouncementRequest;
import com.example.daedongv3_5.domain.auth.service.facade.UserFacade;
import com.example.daedongv3_5.domain.club.domain.Club;
import com.example.daedongv3_5.domain.club.domain.repository.ClubRepository;
import com.example.daedongv3_5.domain.club.exception.ClubNotFoundException;
import com.example.daedongv3_5.domain.student.domain.StudentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateAnnouncementService {
    private final AnnouncementRepository announcementRepository;
    private final ClubRepository clubRepository;
    private final UserFacade userFacade;

    @Transactional
    public void createAnnouncement(AnnouncementRequest request) {
        StudentEntity student = userFacade.currentUser();

        Club club = clubRepository.findRecruitmentByClubName(request.getClubName())
                        .orElseThrow(() -> ClubNotFoundException.EXCEPTION);

        if(!club.getCreatedBy().equals(student.getAccountId())) {
            throw CannotCreateAnnouncementException.EXCEPTION;
        }

        announcementRepository.save(Announcement.builder()
                        .club(club)
                        .introduction(request.getIntroduction())
                        .interviewProject(request.getInterviewProject())
                        .idealTalent(request.getIdealTalent())
                        .announcementStatus(AnnouncementStatus.SubmissionPossible)
                        .createdBy(student.getAccountId())
                        .majors(request.getMajors())
                .build());
    }
}
