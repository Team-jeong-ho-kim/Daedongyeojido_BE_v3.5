package com.example.daedongv3_5.domain.announcement.domain.application;

import com.example.daedongv3_5.domain.announcement.domain.Announcement;
import com.example.daedongv3_5.domain.announcement.domain.repository.AnnouncementRepository;
import com.example.daedongv3_5.domain.announcement.exception.AnnouncementNotFoundException;
import com.example.daedongv3_5.domain.announcement.exception.CannotDeleteAnnouncementException;
import com.example.daedongv3_5.domain.auth.service.facade.UserFacade;
import com.example.daedongv3_5.domain.club.domain.Club;
import com.example.daedongv3_5.domain.club.domain.repository.ClubRepository;
import com.example.daedongv3_5.domain.student.domain.StudentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteAnnouncementService {
    private final AnnouncementRepository announcementRepository;
    private final ClubRepository clubRepository;
    private final UserFacade userFacade;

    @Transactional
    public void deleteAnnouncement(Long id) {
        StudentEntity student = userFacade.currentUser();

        Announcement announcement = announcementRepository.findById(id)
                        .orElseThrow(() -> AnnouncementNotFoundException.EXCEPTION);

        if (!announcement.getCreatedBy().equals(student.getAccountId())) {
            throw CannotDeleteAnnouncementException.EXCEPTION;
        }

        announcementRepository.delete(announcement);

    }
}
