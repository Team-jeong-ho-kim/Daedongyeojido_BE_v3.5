package com.example.daedongv3_5.domain.recruitment.presentation.dto.response;

import com.example.daedongv3_5.domain.club.domain.enums.Major;
import com.example.daedongv3_5.domain.recruitment.domain.Recruitment;
import com.example.daedongv3_5.domain.recruitment.domain.enums.RecruitmentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.List;

@Builder
public record RecruitmentResponse(
    Long id,
    String introduction,
    String phoneNumber,
    List<Major> majors,
    String taskLink,
    RecruitmentStatus status,
    String clubName,
    String applicantName

) {
}