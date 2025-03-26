package com.crudoperation.jw.repo;

import com.crudoperation.jw.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query("SELECT p.ProductQuantity FROM Product p WHERE p.id = :id")
    int findProductQuantityById(@Param("id") int id);
}
