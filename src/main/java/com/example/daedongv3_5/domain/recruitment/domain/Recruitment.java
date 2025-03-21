package com.example.daedongv3_5.domain.recruitment.domain;

import com.example.daedongv3_5.domain.club.domain.Club;
import com.example.daedongv3_5.domain.club.domain.enums.Major;
import com.example.daedongv3_5.domain.recruitment.domain.enums.RecruitmentStatus;
import com.example.daedongv3_5.domain.recruitment.presentation.dto.request.RecruitmentRequest;
import com.example.daedongv3_5.domain.recruitment.presentation.dto.request.UpdateRecruitmentRequest;
import com.example.daedongv3_5.domain.student.domain.StudentEntity;
import com.example.daedongv3_5.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Recruitment extends BaseTimeEntity {

    @Column(nullable = false, length = 300)
    private String introduction;

    @Column(nullable = false, length = 15)
    private String phoneNumber;

    private String taskLink;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "applicant_name", nullable = false)
    private StudentEntity student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_name", nullable = false)
    private Club club;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RecruitmentStatus status;

    @ElementCollection(fetch = FetchType.LAZY)
    @Enumerated(EnumType.STRING)
    private List<Major> majors = new ArrayList<>();

    @Column(nullable = false)
    private String createdBy;

    public void update(UpdateRecruitmentRequest request) {
        this.introduction = request.getIntroduction();
        this.phoneNumber = request.getPhoneNumber();
        this.taskLink = request.getTaskLink();
        this.majors = request.getMajors();
    }

    public void changeStatus(RecruitmentStatus status) {
        this.status = status;
    }

}