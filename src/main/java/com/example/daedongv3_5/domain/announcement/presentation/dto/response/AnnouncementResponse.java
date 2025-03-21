package com.example.daedongv3_5.domain.announcement.presentation.dto.response;

import com.example.daedongv3_5.domain.announcement.domain.enums.AnnouncementStatus;
import com.example.daedongv3_5.domain.club.domain.enums.Major;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;
@Builder
public record AnnouncementResponse(
        String clubName,
        String introduction,
        String idealTalent,
        String interviewProject,
        List<Major>majors,
        AnnouncementStatus announcementStatus,
        LocalDate deadline
) {
}
