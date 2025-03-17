package com.example.daedongv3_5.domain.teacher.domain;

import com.example.daedongv3_5.global.xquare.dto.XquareUserResponse;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TeacherEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String accountId;
    private String password;

    // XquareUserResponse를 매개변수로 받는 생성자 추가
    public TeacherEntity(XquareUserResponse xquareResponse) {
        this.accountId = xquareResponse.getAccountId();
        this.password = xquareResponse.getPassword();
        this.name = xquareResponse.getName();
        // 필요한 경우 다른 필드도 초기화
    }
}
