package com.example.daedongv3_5.domain.club.application;

import com.example.daedongv3_5.domain.club.domain.Club;
import com.example.daedongv3_5.domain.club.domain.repository.ClubRepository;
import com.example.daedongv3_5.domain.club.exception.ClubNotFoundException;
import com.example.daedongv3_5.domain.club.presentation.dto.response.ClubResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class QueryClubInfoService {
    private final ClubRepository clubRepository;

    @Transactional(readOnly = true)
    public ClubResponse queryClubInfo(Long id) {
        Club club = clubRepository.findById(id)
                .orElseThrow(() -> ClubNotFoundException.EXCEPTION);

        return ClubResponse.builder()
                .id(club.getId())
                .clubName(club.getClubName())
                .introduction(club.getIntroduction())
                .oneLiner(club.getOneLiner())
                .majors(Collections.unmodifiableList(club.getMajors()))
                .build();
    }
}
