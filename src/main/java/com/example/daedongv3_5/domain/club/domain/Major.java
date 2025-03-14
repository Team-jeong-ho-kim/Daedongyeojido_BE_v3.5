package com.example.daedongv3_5.domain.club.domain;

import com.example.daedongv3_5.domain.club.domain.enums.MajorType;
import com.example.daedongv3_5.global.entity.BaseIdEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Major extends BaseIdEntity {

    @Enumerated(EnumType.STRING)
    private MajorType majorType;

    public Major(MajorType majorType) {
        this.majorType = majorType;
    }
}
