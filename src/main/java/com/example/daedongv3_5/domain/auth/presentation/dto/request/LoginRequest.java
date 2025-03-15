package com.example.daedongv3_5.domain.auth.presentation.dto.request;



public record LoginRequest(
        String accountId,
        String password
) {}
