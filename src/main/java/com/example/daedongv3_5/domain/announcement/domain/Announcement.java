package com.example.daedongv3_5.domain.announcement.domain;

import com.example.daedongv3_5.domain.announcement.domain.enums.AnnouncementStatus;
import com.example.daedongv3_5.domain.announcement.presentation.dto.request.UpdateAnnouncementRequest;
import com.example.daedongv3_5.domain.club.domain.Club;
import com.example.daedongv3_5.domain.club.domain.enums.Major;
import com.example.daedongv3_5.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Announcement extends BaseTimeEntity {

    @Column(nullable = false, length = 300)
    private String introduction;

    @OneToOne
    @JoinColumn(name = "club_name", nullable = false)
    private Club club;

    @ElementCollection(fetch = FetchType.LAZY)
    @Enumerated(EnumType.STRING)
    private List<Major> majors = new ArrayList<>();

    @Column(nullable = false, length = 300)
    private String idealTalent; //인재상

    @Column(nullable = false)
    private String createdBy;

    @Column(length = 100)
    private String interviewProject;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AnnouncementStatus announcementStatus;

    public void update(UpdateAnnouncementRequest request) {
        this.introduction = request.getIntroduction();
        this.idealTalent = request.getIdealTalent();
        this.interviewProject = request.getInterviewProject();
        this.majors = request.getMajors();
    }

}
