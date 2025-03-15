package com.example.daedongv3_5.domain.recruitment.domain;

import com.example.daedongv3_5.domain.club.domain.Major;
import com.example.daedongv3_5.domain.recruitment.presentation.dto.request.RecruitmentRequest;
import com.example.daedongv3_5.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

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

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RecruitmentStatus status;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Major> majors;

    public void update(RecruitmentRequest request) {
        this.introduction = request.getIntroduction();
        this.phoneNumber = request.getPhoneNumber();
        this.taskLink = request.getTaskLink();
        this.majors = request.getMajors();
    }

}