package com.example.gestion.gestion_factures.repositories;

import com.example.gestion.gestion_factures.models.RefreshToken;
import com.example.gestion.gestion_factures.models.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

    Optional<RefreshToken> findRefreshTokenByToken(String token);
    RefreshToken findByUser(User user);
    int deleteByUser(User user);

    @Transactional
    int deleteAllByUser(User user);

    @Modifying
    @Query("delete from RefreshToken t where t.id = ?1")
    void deleteById(Long id);
}
