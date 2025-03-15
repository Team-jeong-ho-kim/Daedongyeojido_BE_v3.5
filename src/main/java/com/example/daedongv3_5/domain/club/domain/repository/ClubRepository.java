package com.example.daedongv3_5.domain.club.domain.repository;

import com.example.daedongv3_5.domain.club.domain.Club;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClubRepository extends JpaRepository<Club, Long> {

    @EntityGraph(attributePaths = {"majors"})
    Optional<Club> findClubById(Long id);

    @EntityGraph(attributePaths = {"majors"}) // majors 필드를 즉시 로딩
    List<Club> findAll();
}
