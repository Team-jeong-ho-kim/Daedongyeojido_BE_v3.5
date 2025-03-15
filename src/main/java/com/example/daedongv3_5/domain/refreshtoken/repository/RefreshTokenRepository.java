package com.example.daedongv3_5.domain.refreshtoken.repository;

import com.example.daedongv3_5.domain.refreshtoken.domain.RefreshTokenEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends CrudRepository<RefreshTokenEntity, String> {
    Optional<RefreshTokenEntity> findByToken(String token);
}
