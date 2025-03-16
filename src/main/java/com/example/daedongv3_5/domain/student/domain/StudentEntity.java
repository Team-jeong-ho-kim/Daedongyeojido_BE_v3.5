package com.example.daedongv3_5.domain.student.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@Entity
public class StudentEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String accountId;
    private String password;
    private String name;

    @Embedded // ClassInfo를 내장형으로 사용
    private ClassInfo classInfo;

    // 기본 생성자
    protected StudentEntity() {
    }

    // 사용자 입력을 받는 생성자
    public StudentEntity(String accountId, String password, String name, Integer grade, Integer classNum, Integer num) {
        this.accountId = accountId;
        this.password = password;
        this.name = name;
        this.classInfo = new ClassInfo(grade, classNum, num, String.format("%1d%1d%02d", grade, classNum, num));
    }

    @Getter
    @AllArgsConstructor
    @Embeddable // JPA에서 사용할 수 있도록 설정
    public static class ClassInfo {
        private Integer grade;
        private Integer classNumber;
        private Integer number;
        private String schoolNumber;

        // 기본 생성자
        protected ClassInfo() {
        }
    }
}
