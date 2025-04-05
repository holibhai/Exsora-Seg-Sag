package com.crudoperation.jw.repo;

import com.crudoperation.jw.model.DeliveryCharge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryChargeRepository extends JpaRepository<DeliveryCharge, Integer> {
}
