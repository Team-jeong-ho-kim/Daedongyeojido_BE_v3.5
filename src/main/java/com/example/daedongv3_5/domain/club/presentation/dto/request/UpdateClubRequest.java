package com.example.daedongv3_5.domain.club.presentation.dto.request;

import com.example.daedongv3_5.domain.club.domain.enums.Major;
import lombok.Getter;

@Getter
public class UpdateClubRequest {
    private String clubName;
    private String introduction;
    private String clubMember;
    private Major major;
}
