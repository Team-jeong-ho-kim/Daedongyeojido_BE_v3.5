package com.example.daedongv3_5.domain.recruitment.domain.repository;

import com.example.daedongv3_5.domain.recruitment.domain.Recruitment;

public interface RecruitmentRepositoryCustom {

    Recruitment findByRecruitmentId(Long id);

}