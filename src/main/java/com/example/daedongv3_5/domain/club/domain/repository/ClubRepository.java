package com.example.daedongv3_5.domain.club.domain.repository;

import com.example.daedongv3_5.domain.club.domain.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long>, ClubRepositoryCustom{
    Optional<Club> findById(Long clubId);

    void deleteByClubName(String clubName);
}
