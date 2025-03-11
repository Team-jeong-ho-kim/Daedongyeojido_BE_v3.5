package com.example.daedongv3_5.domain.club.presentation.dto.request;

import com.example.daedongv3_5.domain.club.domain.enums.Major;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ClubRequest {

    @NotNull
    private String clubName;

    private String introduction;

    private String clubMember;

    @Enumerated(EnumType.STRING)
    private Major major;

}
