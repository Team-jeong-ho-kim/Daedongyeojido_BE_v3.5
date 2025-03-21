package com.example.daedongv3_5.domain.announcement.domain.application;

import com.example.daedongv3_5.domain.announcement.domain.Announcement;
import com.example.daedongv3_5.domain.announcement.domain.repository.AnnouncementRepository;
import com.example.daedongv3_5.domain.announcement.exception.AnnouncementNotFoundException;
import com.example.daedongv3_5.domain.announcement.exception.CannotUpdateAnnouncementException;
import com.example.daedongv3_5.domain.announcement.presentation.dto.request.UpdateAnnouncementRequest;
import com.example.daedongv3_5.domain.auth.service.facade.UserFacade;
import com.example.daedongv3_5.domain.student.domain.StudentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateAnnouncementService {
    private final AnnouncementRepository announcementRepository;
    private final UserFacade userFacade;

    @Transactional
    public void updateAnnouncement(UpdateAnnouncementRequest request) {
        StudentEntity student = userFacade.currentUser();

        Announcement announcement = announcementRepository.findById(request.getId())
                .orElseThrow(() -> AnnouncementNotFoundException.EXCEPTION);

        if (!announcement.getCreatedBy().equals(student.getAccountId())) {
            throw CannotUpdateAnnouncementException.EXCEPTION;
        }

        announcement.update(request);

    }
}
