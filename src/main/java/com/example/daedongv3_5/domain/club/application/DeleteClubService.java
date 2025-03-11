package com.example.daedongv3_5.domain.club.application;

import com.example.daedongv3_5.domain.club.domain.repository.ClubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteClubService {
    private final ClubRepository clubRepository;

    @Transactional
    public void deleteClub(String clubName) {
        clubRepository.deleteByClubName(clubName);
    }
}
