package com.crudoperation.jw.repo;

import com.crudoperation.jw.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    Optional<Address> findByUserId(int userId);
}
