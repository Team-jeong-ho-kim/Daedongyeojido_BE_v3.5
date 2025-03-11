package com.example.daedongv3_5.domain.club.application;

import com.example.daedongv3_5.domain.club.domain.Club;
import com.example.daedongv3_5.domain.club.domain.repository.ClubRepository;
import com.example.daedongv3_5.domain.club.exception.ClubNotFoundException;
import com.example.daedongv3_5.domain.club.presentation.dto.request.UpdateClubRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateClubService {
    private final ClubRepository clubRepository;

    @Transactional
    public void updateClub(String clubName, UpdateClubRequest request) {
        Club club = clubRepository.findByClubName(clubName)
                .orElseThrow(() -> ClubNotFoundException.EXCEPTION);

        club.update(request.getClubName(), request.getIntroduction(), request.getClubMember(), request.getMajor());
    }

}
