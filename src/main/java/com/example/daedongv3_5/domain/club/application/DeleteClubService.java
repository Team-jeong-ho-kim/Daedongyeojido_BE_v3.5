package com.example.daedongv3_5.domain.club.application;

import com.example.daedongv3_5.domain.club.application.facade.ClubFacade;
import com.example.daedongv3_5.domain.club.domain.Club;
import com.example.daedongv3_5.domain.club.domain.repository.ClubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteClubService {
    private final ClubRepository clubRepository;
    private final ClubFacade clubFacade;

    @Transactional
    public void deleteClub(Long id) {
        Club club = clubFacade.clubFacade(id);

        clubRepository.deleteById(id);
    }
}
