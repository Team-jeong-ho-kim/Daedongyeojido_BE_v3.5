package com.example.daedongv3_5.domain.announcement.domain.application;

import com.example.daedongv3_5.domain.announcement.domain.Announcement;
import com.example.daedongv3_5.domain.announcement.domain.repository.AnnouncementRepository;
import com.example.daedongv3_5.domain.announcement.exception.AnnouncementNotFoundException;
import com.example.daedongv3_5.domain.announcement.presentation.dto.response.AnnouncementResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class QueryAnnouncementService {
    private final AnnouncementRepository announcementRepository;

    @Transactional(readOnly = true)
    public AnnouncementResponse queryAnnouncement(Long id) {

        Announcement announcement = announcementRepository.findById(id)
                .orElseThrow(() -> AnnouncementNotFoundException.EXCEPTION);

        return AnnouncementResponse.builder()
                .introduction(announcement.getIntroduction())
                .clubName(announcement.getClub().getClubName())
                .idealTalent(announcement.getIdealTalent())
                .interviewProject(announcement.getInterviewProject())
                .majors(Collections.unmodifiableList(announcement.getMajors()))
                .announcementStatus(announcement.getAnnouncementStatus())
                .build();
    }
}
