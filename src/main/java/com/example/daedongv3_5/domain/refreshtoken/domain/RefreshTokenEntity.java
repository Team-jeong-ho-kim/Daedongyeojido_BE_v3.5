package com.example.daedongv3_5.domain.refreshtoken.domain;


import com.example.daedongv3_5.domain.auth.presentation.dto.AuthElementDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

@RedisHash
@Getter
@Builder
@AllArgsConstructor
public class RefreshTokenEntity {
    @Id
    private String id;
    private AuthElementDto.UserRole role;

    @Indexed
    private String token;

    @TimeToLive
    private Long timeToLive;

    protected RefreshTokenEntity() {}
}
