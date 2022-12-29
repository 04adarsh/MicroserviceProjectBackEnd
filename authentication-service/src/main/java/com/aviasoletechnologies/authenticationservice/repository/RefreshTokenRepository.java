package com.aviasoletechnologies.authenticationservice.repository;


import com.aviasoletechnologies.authenticationservice.model.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;


public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByToken(String token);

    @Modifying
    int deleteByUser(User user);

    int deleteByUser(com.aviasoletechnologies.authenticationservice.model.User user);
}
