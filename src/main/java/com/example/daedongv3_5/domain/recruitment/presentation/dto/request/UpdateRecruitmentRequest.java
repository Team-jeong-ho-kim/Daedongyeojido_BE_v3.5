package com.example.daedongv3_5.domain.recruitment.presentation.dto.request;

import com.example.daedongv3_5.domain.club.domain.enums.Major;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class UpdateRecruitmentRequest {
    @NotNull
    private Long id;

    @NotNull
    private String clubName;

    @NotBlank
    @Size(max = 300)
    private String introduction;

    @NotBlank
    @Size(max = 15)
    private String phoneNumber;

    private String taskLink;

    @NotNull(message = "1개 이상의 전공을 선택해주세요.")
    private List<Major> majors;
}
