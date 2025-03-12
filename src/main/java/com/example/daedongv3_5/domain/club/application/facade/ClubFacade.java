package com.example.daedongv3_5.domain.club.application.facade;

import com.example.daedongv3_5.domain.club.domain.Club;
import com.example.daedongv3_5.domain.club.domain.repository.ClubRepository;
import com.example.daedongv3_5.domain.club.exception.ClubNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClubFacade {
    private final ClubRepository clubRepository;

    public Club clubFacade(String clubName) {
        return clubRepository.findByClubName(clubName)
                .orElseThrow(() -> ClubNotFoundException.EXCEPTION);
    }
}
