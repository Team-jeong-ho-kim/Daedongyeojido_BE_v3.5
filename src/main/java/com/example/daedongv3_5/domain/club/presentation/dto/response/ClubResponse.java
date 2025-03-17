package com.example.daedongv3_5.domain.club.presentation.dto.response;

import com.example.daedongv3_5.domain.club.domain.enums.Major;
import lombok.Builder;

import java.util.List;
@Builder
public record ClubResponse(
        Long id,
        String clubName,
        String introduction,
        String oneLiner,
        List<Major> majors
) {
}
