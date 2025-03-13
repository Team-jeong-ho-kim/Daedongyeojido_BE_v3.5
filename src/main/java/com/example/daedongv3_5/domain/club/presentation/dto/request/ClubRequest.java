package com.example.daedongv3_5.domain.club.presentation.dto.request;

import com.example.daedongv3_5.domain.club.domain.enums.MajorType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class ClubRequest {

    @NotNull
    private String clubName;

    private String introduction;

    private String clubMember;

    private List<MajorType> majors;

}
