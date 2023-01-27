package com.aviasoletechnologies.authenticationservice.repository;

import com.aviasoletechnologies.authenticationservice.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Long> {
    List<Address> findAddressByUserId(Long userId);
}
