package com.example.daedongv3_5.domain.club.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QClub is a Querydsl query type for Club
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QClub extends EntityPathBase<Club> {

    private static final long serialVersionUID = 1638385170L;

    public static final QClub club = new QClub("club");

    public final com.example.daedongv3_5.global.entity.QBaseIdEntity _super = new com.example.daedongv3_5.global.entity.QBaseIdEntity(this);

    public final StringPath clubMember = createString("clubMember");

    public final StringPath clubName = createString("clubName");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath introduction = createString("introduction");

    public final ListPath<Major, QMajor> majors = this.<Major, QMajor>createList("majors", Major.class, QMajor.class, PathInits.DIRECT2);

    public final StringPath oneLiner = createString("oneLiner");

    public QClub(String variable) {
        super(Club.class, forVariable(variable));
    }

    public QClub(Path<? extends Club> path) {
        super(path.getType(), path.getMetadata());
    }

    public QClub(PathMetadata metadata) {
        super(Club.class, metadata);
    }

}

