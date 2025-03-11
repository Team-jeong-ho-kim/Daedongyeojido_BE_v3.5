package com.example.daedongv3_5.domain.club.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QClub is a Querydsl query type for Club
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QClub extends EntityPathBase<Club> {

    private static final long serialVersionUID = 1638385170L;

    public static final QClub club = new QClub("club");

    public final com.example.daedongv3_5.global.entity.QBaseIdEntity _super = new com.example.daedongv3_5.global.entity.QBaseIdEntity(this);

    public final StringPath clubName = createString("clubName");

    public final StringPath clubUser = createString("clubUser");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath introduction = createString("introduction");

    public final EnumPath<com.example.daedongv3_5.domain.club.domain.enums.Major> major = createEnum("major", com.example.daedongv3_5.domain.club.domain.enums.Major.class);

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

