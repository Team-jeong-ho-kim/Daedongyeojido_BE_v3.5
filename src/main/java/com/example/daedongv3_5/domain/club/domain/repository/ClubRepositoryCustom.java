package com.example.daedongv3_5.domain.club.domain.repository;

import com.example.daedongv3_5.domain.club.presentation.dto.response.ClubListResponse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClubRepositoryCustom {

    List<ClubListResponse> findAllClub();
}
