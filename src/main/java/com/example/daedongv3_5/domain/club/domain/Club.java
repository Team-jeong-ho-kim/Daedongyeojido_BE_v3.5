package com.example.daedongv3_5.domain.club.domain;

import com.example.daedongv3_5.domain.club.domain.enums.Major;
import com.example.daedongv3_5.domain.club.presentation.dto.request.UpdateClubRequest;
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
public class Club extends BaseTimeEntity {

    @Column(nullable = false, length = 15)
    private String clubName;

    @Column(nullable = false, length = 300)
    private String introduction;

    @Column(nullable = false, length = 20)
    private String oneLiner;  //한 줄 소개라는 뜻

    private String clubMember;

    @Column(nullable = false)
    private String createdBy;

    @ElementCollection(fetch = FetchType.LAZY)
    @Enumerated(EnumType.STRING)
    private List<Major> majors = new ArrayList<>();

    public void update(UpdateClubRequest request) {
        this.clubName = request.getClubName();
        this.introduction = request.getIntroduction();
        this.oneLiner = request.getOneLiner();
        this.majors = request.getMajors();
    }
}
