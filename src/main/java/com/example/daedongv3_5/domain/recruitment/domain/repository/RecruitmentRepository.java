package com.example.daedongv3_5.domain.recruitment.domain.repository;

import com.example.daedongv3_5.domain.recruitment.domain.Recruitment;
import com.example.daedongv3_5.domain.recruitment.presentation.dto.response.RecruitmentListResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RecruitmentRepository extends JpaRepository<Recruitment, Long> {
    List<Recruitment> findRecruitmentByClub_ClubName(String clubName);

    List<Recruitment> findByCreatedBy(String createdBy);

    Optional<Recruitment> findRecruitmentByCreatedBy(String createdBy);
}