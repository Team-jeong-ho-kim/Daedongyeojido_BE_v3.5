package com.example.daedongv3_5.domain.club.presentation.dto.response;

import com.example.daedongv3_5.domain.club.domain.Club;
import com.example.daedongv3_5.domain.club.domain.enums.Major;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class ClubListResponse {
    private Long id;
    private String clubName;
    private String introduction;
    private String oneLiner;
    private String clubMember;
    private List<Major> majors;
    private LocalDateTime createAt;

    public ClubListResponse(Club club) {
        this.id = club.getId();
        this.clubName = club.getClubName();
        this.introduction = club.getIntroduction();
        this.oneLiner = club.getOneLiner();
        this.clubMember = club.getClubMember();
        this.majors = club.getMajors();
        this.createAt = club.getCreatedAt();
    }
}
