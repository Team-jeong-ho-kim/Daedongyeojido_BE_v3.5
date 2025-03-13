package com.example.daedongv3_5.domain.club.domain;

import com.example.daedongv3_5.global.entity.BaseIdEntity;
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
public class Club extends BaseIdEntity {

    @Column(nullable = false)
    private String clubName;

    @Column(nullable = false, length = 300)
    private String introduction;

    private String clubMember;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Major> majors = new ArrayList<>();


    public void update(String clubName, String introduction, String clubMember, List<Major> majors) {
        this.clubName = clubName;
        this.introduction = introduction;
        this.clubMember = clubMember;
        this.majors = majors;
    }
}
