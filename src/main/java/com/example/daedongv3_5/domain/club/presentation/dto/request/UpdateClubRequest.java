package com.example.daedongv3_5.domain.club.presentation.dto.request;

import com.example.daedongv3_5.domain.club.domain.enums.Major;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.List;

@Getter
public class UpdateClubRequest {

    @NotNull
    private Long id;

    @NotNull
    private String clubName;

    private String introduction;

    private String oneLiner;

    private List<Major> majors;
}
