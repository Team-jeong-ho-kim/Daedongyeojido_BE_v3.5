package com.example.daedongv3_5.domain.club.presentation.dto.request;

import com.example.daedongv3_5.domain.club.domain.enums.MajorType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class ClubRequest {

    @NotNull(message = "동아리 이름이 비어있습니다.")
    private String clubName;

    @Size(max = 300, message = "소개를 300자 이하로 작성해주세요.")
    private String introduction;

    @Size(max = 20, message = "한 줄 소개를 20자 이하로 작성해주세요.")
    private String oneLiner;

    private String clubMember;

    @NotEmpty(message = "한 가지 이상의 전공을 선택해야 합니다.")
    private List<MajorType> majors;

}
