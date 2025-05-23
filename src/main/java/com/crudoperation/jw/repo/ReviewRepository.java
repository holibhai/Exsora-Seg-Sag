package com.crudoperation.jw.repo;

import com.crudoperation.jw.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByProductId(Long productId);
    List<Review> findByUserId(Long userId);
}
