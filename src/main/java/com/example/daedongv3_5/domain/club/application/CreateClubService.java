package com.example.daedongv3_5.domain.club.application;

import com.example.daedongv3_5.domain.club.domain.Club;
import com.example.daedongv3_5.domain.club.domain.repository.ClubRepository;
import com.example.daedongv3_5.domain.club.presentation.dto.request.ClubRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateClubService {
    private final ClubRepository clubRepository;

    @Transactional
    public void createClub(ClubRequest request) {
        clubRepository.save(Club.builder()
                        .clubName(request.getClubName())
                        .introduction(request.getIntroduction())
                        .clubMember(request.getClubMember())
                        .major(request.getMajor())
                .build());
    }
}
