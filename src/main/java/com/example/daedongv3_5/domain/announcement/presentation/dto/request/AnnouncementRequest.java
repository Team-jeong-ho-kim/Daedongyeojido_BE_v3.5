package com.example.daedongv3_5.domain.announcement.presentation.dto.request;

import com.example.daedongv3_5.domain.club.domain.enums.Major;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class AnnouncementRequest {

    @Size(max = 15)
    @NotNull(message = "동아리 이름이 비어있습니다.")
    private String clubName;

    @Size(max = 300)
    private String introduction;

    @NotNull(message = "한 가지 이상의 전공을 선택해야 합니다.")
    private List<Major> majors;

    @Size(max = 300)
    private String idealTalent;

    @Size(max = 100)
    private String interviewProject;

    @NotNull
    private LocalDate deadline;

}
