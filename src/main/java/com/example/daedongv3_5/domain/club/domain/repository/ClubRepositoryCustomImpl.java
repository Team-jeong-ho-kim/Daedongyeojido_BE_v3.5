package com.example.daedongv3_5.domain.club.domain.repository;

import com.example.daedongv3_5.domain.club.domain.QClub;
import com.example.daedongv3_5.domain.club.presentation.dto.response.ClubListResponse;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ClubRepositoryCustomImpl implements ClubRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    private final QClub qClub = QClub.club;

    @Override
    public List<ClubListResponse> findAllClub() {
        return jpaQueryFactory.select(Projections.constructor(ClubListResponse.class, qClub.clubName, qClub.introduction, qClub.clubMember, qClub.major, qClub.createdAt))
                .from(qClub)
                .orderBy(qClub.createdAt.desc())
                .fetch();
    }

}
