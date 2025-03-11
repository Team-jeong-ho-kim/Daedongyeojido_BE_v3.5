package com.example.daedongv3_5.domain.club.application;

import com.example.daedongv3_5.domain.club.domain.repository.ClubRepository;
import com.example.daedongv3_5.domain.club.presentation.dto.response.ClubListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryAllClubService {
    private final ClubRepository clubRepository;

    @Transactional(readOnly = true)
    public List<ClubListResponse> queryAllClub() {
        return clubRepository.findAllClub();
    }
}
