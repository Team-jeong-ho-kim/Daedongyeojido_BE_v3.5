package com.example.daedongv3_5.domain.auth.service;


import com.example.daedongv3_5.domain.auth.presentation.dto.response.TokenResponse;
import com.example.daedongv3_5.domain.refreshtoken.domain.RefreshTokenEntity;
import com.example.daedongv3_5.domain.refreshtoken.repository.RefreshTokenRepository;
import com.example.daedongv3_5.global.exception.auth.InvalidTokenException;
import com.example.daedongv3_5.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReissueTokenService {
    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtTokenProvider jwtTokenProvider;


    @Transactional
    public TokenResponse reissueToken(String token) {
        RefreshTokenEntity refreshToken = refreshTokenRepository.findByToken(token)
                .orElseThrow(()-> InvalidTokenException.EXCEPTION);

        return jwtTokenProvider.receiveToken(refreshToken.getId(), refreshToken.getRole());
    }
}
