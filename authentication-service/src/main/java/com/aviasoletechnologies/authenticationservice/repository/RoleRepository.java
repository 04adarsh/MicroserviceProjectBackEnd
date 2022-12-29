package com.aviasoletechnologies.authenticationservice.repository;

import com.aviasoletechnologies.authenticationservice.model.ERole;
import com.aviasoletechnologies.authenticationservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}

