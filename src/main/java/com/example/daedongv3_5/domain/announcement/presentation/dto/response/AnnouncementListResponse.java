package com.example.daedongv3_5.domain.announcement.presentation.dto.response;

import com.example.daedongv3_5.domain.announcement.domain.Announcement;
import com.example.daedongv3_5.domain.announcement.domain.enums.AnnouncementStatus;
import com.example.daedongv3_5.domain.club.domain.enums.Major;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class AnnouncementListResponse {

    private Long id;
    private String clubName;
    private String introduction;
    private String idealTalent;
    private String interviewProject;
    private List<Major> majors;
    private AnnouncementStatus announcementStatus;
    private LocalDate deadline;
    private LocalDateTime createAt;

    public AnnouncementListResponse(Announcement announcement) {
        this.id = announcement.getId();
        this.clubName = announcement.getClub().getClubName();
        this.introduction = announcement.getIntroduction();
        this.idealTalent = announcement.getIdealTalent();
        this.interviewProject = announcement.getInterviewProject();
        this.majors = new ArrayList<>(announcement.getMajors());
        this.announcementStatus = announcement.getAnnouncementStatus();
        this.deadline = announcement.getDeadline();
        this.createAt = announcement.getCreatedAt();
    }

}
