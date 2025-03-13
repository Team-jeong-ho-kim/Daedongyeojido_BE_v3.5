package com.example.daedongv3_5.domain.club.domain;

import com.example.daedongv3_5.domain.club.domain.enums.MajorType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Major {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MajorType majorType;

    public Major(MajorType majorType) {
        this.majorType = majorType;
    }
}
