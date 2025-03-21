package com.example.daedongv3_5.domain.recruitment.application;

import com.example.daedongv3_5.domain.auth.service.facade.UserFacade;
import com.example.daedongv3_5.domain.club.domain.Club;
import com.example.daedongv3_5.domain.club.domain.repository.ClubRepository;
import com.example.daedongv3_5.domain.club.exception.ClubNotFoundException;
import com.example.daedongv3_5.domain.recruitment.domain.repository.RecruitmentRepository;
import com.example.daedongv3_5.domain.recruitment.exception.CannotQueryRecruitmentException;
import com.example.daedongv3_5.domain.recruitment.presentation.dto.response.RecruitmentListResponse;
import com.example.daedongv3_5.domain.student.domain.StudentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryRecruitmentListService {
    private final RecruitmentRepository recruitmentRepository;
    private final UserFacade userFacade;
    private final ClubRepository clubRepository;


    @Transactional(readOnly = true)
    public List<RecruitmentListResponse> queryRecruitmentList(String clubName) {
        StudentEntity student = userFacade.currentUser();

        Club club = clubRepository.findRecruitmentByClubName(clubName)
                .orElseThrow(() -> ClubNotFoundException.EXCEPTION);

        if (!club.getCreatedBy().equals(student.getAccountId())) {
            throw CannotQueryRecruitmentException.EXCEPTION;
        }

        return recruitmentRepository.findRecruitmentByClub_ClubName(clubName)
                .stream()
                .map(recruitment -> new RecruitmentListResponse(recruitment))
                .collect(Collectors.toList());
    }
}
