package com.example.daedongv3_5.domain.club.domain.repository;

import com.example.daedongv3_5.domain.club.domain.Club;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClubRepository extends CrudRepository<Club, Long>, ClubRepositoryCustom{
    Optional<Club> findByClubName(String clubName);

    void deleteByClubName(String clubName);
}
