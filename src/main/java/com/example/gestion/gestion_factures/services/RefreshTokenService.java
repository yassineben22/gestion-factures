package com.example.gestion.gestion_factures.services;

import com.example.gestion.gestion_factures.models.RefreshToken;
import com.example.gestion.gestion_factures.models.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface RefreshTokenService {

    Optional<RefreshToken> findByToken(String token);

    RefreshToken createRefreshToken(User user);

    RefreshToken verifyExpiration(RefreshToken token);

    RefreshToken findByUser(Long userId);

    int deleteByUserId(Long userId);

    int deleteAllByUser(User user);

}
