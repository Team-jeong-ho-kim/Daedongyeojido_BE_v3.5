package com.example.daedongv3_5.domain.club.application;

import com.example.daedongv3_5.domain.club.application.facade.ClubFacade;
import com.example.daedongv3_5.domain.club.domain.Club;
import com.example.daedongv3_5.domain.club.domain.repository.ClubRepository;
import com.example.daedongv3_5.domain.club.presentation.dto.request.UpdateClubRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateClubInfoService {
    private final ClubRepository clubRepository;
    private final ClubFacade clubFacade;

    @Transactional
    public void updateClub(Long clubId, UpdateClubRequest request) {
        Club club = clubFacade.clubFacade(clubId);

        club.update(
                request.getClubName(),
                request.getIntroduction(),
                request.getClubMember(),
                request.getMajor()
        );
    }

}
