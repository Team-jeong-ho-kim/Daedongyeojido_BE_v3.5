package com.example.daedongv3_5.domain.club.application;

import com.example.daedongv3_5.domain.club.application.facade.ClubFacade;
import com.example.daedongv3_5.domain.club.domain.Club;
import com.example.daedongv3_5.domain.club.domain.repository.ClubRepository;
import com.example.daedongv3_5.domain.club.presentation.dto.response.ClubResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QueryClubInfoService {
    private final ClubRepository clubRepository;
    private final ClubFacade clubFacade;

    public ClubResponse queryClubInfo(Long clubId) {
        Club club = clubFacade.clubFacade(clubId);

        return clubRepository.findClubInfoByClubId(clubId);
    }
}
