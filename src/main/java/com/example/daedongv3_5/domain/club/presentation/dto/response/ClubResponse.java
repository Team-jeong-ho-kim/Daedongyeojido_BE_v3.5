package com.example.daedongv3_5.domain.club.presentation.dto.response;

import com.example.daedongv3_5.domain.club.domain.Club;
import com.example.daedongv3_5.domain.club.domain.Major;
import com.example.daedongv3_5.domain.club.domain.enums.MajorType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ClubResponse {
    private Long id;
    private String clubName;
    private String introduction;
    private String oneLiner;
    private String clubMember;
    private List<Major> majors;

    public ClubResponse(Club club) {
        this.id = club.getId();
        this.clubName = club.getClubName();
        this.introduction = club.getIntroduction();
        this.oneLiner = club.getOneLiner();
        this.clubMember = club.getClubMember();
        this.majors = club.getMajors();
    }
}
