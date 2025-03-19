package com.example.daedongv3_5.domain.club.application;

import com.example.daedongv3_5.domain.auth.service.facade.UserFacade;
import com.example.daedongv3_5.domain.club.domain.Club;
import com.example.daedongv3_5.domain.club.domain.repository.ClubRepository;
import com.example.daedongv3_5.domain.club.presentation.dto.request.ClubRequest;
import com.example.daedongv3_5.domain.student.domain.StudentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateClubService {
    private final ClubRepository clubRepository;
    private final UserFacade userFacade;

    @Transactional
    public void createClub(ClubRequest request) {

        StudentEntity student = userFacade.currentUser();

        clubRepository.save(Club.builder()
                        .clubName(request.getClubName())
                        .introduction(request.getIntroduction())
                        .oneLiner(request.getOneLiner())
                        .clubMember(request.getClubMember())
                        .majors(request.getMajors())
                        .createdBy(student.getAccountId())
                .build());
    }
}
