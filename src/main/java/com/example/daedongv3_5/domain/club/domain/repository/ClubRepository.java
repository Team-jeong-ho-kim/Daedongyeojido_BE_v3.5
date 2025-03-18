package com.example.daedongv3_5.domain.club.domain.repository;

import com.example.daedongv3_5.domain.club.domain.Club;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClubRepository extends JpaRepository<Club, Long> {
    Optional<Club> findRecruitmentByClubName(String clubName);

}
