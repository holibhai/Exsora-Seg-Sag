package com.crudoperation.jw.repo;

import com.crudoperation.jw.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
