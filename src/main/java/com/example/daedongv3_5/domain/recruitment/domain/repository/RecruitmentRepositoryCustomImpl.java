//package com.example.daedongv3_5.domain.recruitment.domain.repository;
//
//import com.example.daedongv3_5.domain.club.domain.QMajor;
//import com.example.daedongv3_5.domain.recruitment.domain.QRecruitment;
//import com.example.daedongv3_5.domain.recruitment.domain.Recruitment;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import lombok.RequiredArgsConstructor;
//
//@RequiredArgsConstructor
//public class RecruitmentRepositoryCustomImpl implements RecruitmentRepositoryCustom {
//
//    private final JPAQueryFactory queryFactory;
//    private final QRecruitment recruitment = QRecruitment.recruitment;
//    private final QMajor major = QMajor.major;
//
//    @Override
//    public Recruitment findByRecruitmentId(Long id) {
//        return queryFactory
//            .selectFrom(recruitment)
//            .leftJoin(recruitment.majors, major).fetchJoin()
//            .where(recruitment.id.eq(id))
//            .fetchOne();
//    }
//
//}