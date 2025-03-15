package com.example.daedongv3_5.domain.auth.presentation.dto.response;

import lombok.Builder;

@Builder
public record TokenResponse(
        String accessToken,
        String refreshToken,
        Long accessExpiredAt,
        Long refreshExpiredAt
) {}