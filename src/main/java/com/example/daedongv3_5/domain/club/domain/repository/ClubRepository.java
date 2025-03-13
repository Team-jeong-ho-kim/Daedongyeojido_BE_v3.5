package com.example.daedongv3_5.domain.club.domain.repository;

import com.example.daedongv3_5.domain.club.domain.Club;
import com.example.daedongv3_5.domain.club.presentation.dto.response.ClubResponse;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long>, ClubRepositoryCustom{

    Optional<Club> findClubById(Long id);

    void deleteById(Long id);

    @EntityGraph(attributePaths = {"majors"}) // majors 필드를 즉시 로딩
    List<Club> findAll();
}
