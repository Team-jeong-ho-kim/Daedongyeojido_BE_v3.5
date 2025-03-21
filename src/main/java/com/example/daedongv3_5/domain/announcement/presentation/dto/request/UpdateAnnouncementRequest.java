package com.example.daedongv3_5.domain.announcement.presentation.dto.request;

import com.example.daedongv3_5.domain.club.domain.enums.Major;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
public class UpdateAnnouncementRequest {

    @NotNull
    private Long id;

    @NotNull
    @Size(max = 300)
    private String introduction;

    @NotNull
    private List<Major> majors;

    @Size(max = 300)
    private String idealTalent;

    @Size(max = 100)
    private String interviewProject;

    @NotNull
    private LocalDate deadline;
}
