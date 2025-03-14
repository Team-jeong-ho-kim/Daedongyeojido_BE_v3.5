package com.example.daedongv3_5.domain.club.domain;

import com.example.daedongv3_5.global.entity.BaseIdEntity;
import com.example.daedongv3_5.global.entity.BaseTimeEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Club extends BaseTimeEntity {

    @Column(nullable = false, length = 15)
    private String clubName;

    @Column(nullable = false, length = 300)
    private String introduction;

    @Column(nullable = false, length = 20)
    private String oneLiner;  //한 줄 소개라는 뜻

    private String clubMember;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Major> majors = new ArrayList<>();


    public void update(String clubName, String introduction, String oneLiner, List<Major> majors) {
        this.clubName = clubName;
        this.introduction = introduction;
        this.oneLiner = oneLiner;
        this.majors = majors;
    }
}
