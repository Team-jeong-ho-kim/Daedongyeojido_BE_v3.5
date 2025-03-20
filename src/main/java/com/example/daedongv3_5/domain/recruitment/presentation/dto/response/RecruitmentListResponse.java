package com.example.daedongv3_5.domain.recruitment.presentation.dto.response;

import com.example.daedongv3_5.domain.club.domain.enums.Major;
import com.example.daedongv3_5.domain.recruitment.domain.Recruitment;
import com.example.daedongv3_5.domain.recruitment.domain.enums.RecruitmentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class RecruitmentListResponse {
    private Long id;
    private String introduction;
    private String phoneNumber;
    private List<Major> majors;
    private String taskLink;
    private RecruitmentStatus status;
    private String clubName;
    private String applicantName;

    public RecruitmentListResponse(Recruitment recruitment) {
        this.id = recruitment.getId();
        this.introduction = recruitment.getIntroduction();
        this.phoneNumber = recruitment.getPhoneNumber();
        this.majors = new ArrayList<>(recruitment.getMajors());
        this.taskLink = recruitment.getTaskLink();
        this.status = recruitment.getStatus();
        this.clubName = recruitment.getClub().getClubName();
        this.applicantName = recruitment.getStudent().getName();
    }
}
