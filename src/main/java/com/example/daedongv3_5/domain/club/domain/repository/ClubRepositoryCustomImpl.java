package com.example.daedongv3_5.domain.club.domain.repository;

import com.example.daedongv3_5.domain.club.domain.QClub;
import com.example.daedongv3_5.domain.club.presentation.dto.response.ClubListResponse;
import com.example.daedongv3_5.domain.club.presentation.dto.response.ClubResponse;
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

    @Override
    public ClubResponse findClubInfoByClubName(String clubName) {
        return jpaQueryFactory.select(Projections.constructor(ClubResponse.class, qClub.clubName, qClub.clubMember, qClub.introduction, qClub.major))
                .from(qClub)
                .where(qClub.clubName.eq(clubName))
                .fetchOne();
    }

}
