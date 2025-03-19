package com.example.daedongv3_5.domain.club.application;

import com.example.daedongv3_5.domain.auth.service.facade.UserFacade;
import com.example.daedongv3_5.domain.club.domain.Club;
import com.example.daedongv3_5.domain.club.domain.repository.ClubRepository;
import com.example.daedongv3_5.domain.club.exception.CannotUpdateClubInfoException;
import com.example.daedongv3_5.domain.club.exception.ClubNotFoundException;
import com.example.daedongv3_5.domain.club.presentation.dto.request.UpdateClubRequest;
import com.example.daedongv3_5.domain.student.domain.StudentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateClubInfoService {
    private final ClubRepository clubRepository;
    private final UserFacade userFacade;

    @Transactional
    public void updateClub(UpdateClubRequest request) {
        Club club = clubRepository.findById(request.getId())
                .orElseThrow(() -> ClubNotFoundException.EXCEPTION);

        StudentEntity student = userFacade.currentUser();

        if (!club.getCreatedBy().equals(student.getAccountId())) {
            throw CannotUpdateClubInfoException.EXCEPTION;
        }

        club.update(request);
    }

}
