package com.example.daedongv3_5.domain.recruitment.domain.repository;

import com.example.daedongv3_5.domain.recruitment.domain.Recruitment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecruitmentRepository extends JpaRepository<Recruitment, Long>, RecruitmentRepositoryCustom {
}