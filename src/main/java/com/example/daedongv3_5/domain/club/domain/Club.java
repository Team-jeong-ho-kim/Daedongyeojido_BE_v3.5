package com.example.daedongv3_5.domain.club.domain;

import com.example.daedongv3_5.domain.club.domain.enums.Major;
import com.example.daedongv3_5.global.entity.BaseIdEntity;
import jakarta.persistence.Entity;
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

    private String clubName;

    private String introduction;

    private String clubUser;

    private Major major;

}
