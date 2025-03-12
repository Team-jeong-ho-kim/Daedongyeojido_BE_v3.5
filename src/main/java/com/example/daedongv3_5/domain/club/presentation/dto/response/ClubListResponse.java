package com.example.daedongv3_5.domain.club.presentation.dto.response;

import com.example.daedongv3_5.domain.club.domain.enums.Major;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ClubListResponse {
    private Long clubId;
    private String clubName;
    private String introduction;
    private String clubMember;
    private Major major;
    private LocalDateTime createAt;
}
