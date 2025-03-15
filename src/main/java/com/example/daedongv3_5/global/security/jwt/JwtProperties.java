package com.example.daedongv3_5.global.security.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "jwt")
public record JwtProperties(
        String header,
        String prefix,
        String secretKey,
        Long accessExpiration,
        Long refreshExpiration,
        String teacherSecret,
        String studentSecret
) {
}

