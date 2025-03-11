package com.example.daedongv3_5.domain.club.domain;

import com.example.daedongv3_5.domain.club.domain.enums.Major;
import com.example.daedongv3_5.global.entity.BaseIdEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Club extends BaseIdEntity {

    @Column(nullable = false)
    private String clubName;

    @Column(nullable = false, length = 300)
    private String introduction;

    private String clubMember;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Major major;

    public void update(String clubName, String introduction, String clubMember, Major major) {
        this.clubName = clubMember;
        this.introduction = introduction;
        this.clubMember = clubMember;
        this.major = major;
    }
}
