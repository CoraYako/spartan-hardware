package com.spartanHardware.repository;

import com.spartanHardware.model.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query(value = "SELECT * FROM user_product_reviews WHERE product_id = ?", nativeQuery = true)
    Page<Review> findReviewByProductId(Long productId, Pageable pageable);

    @Query(value = "SELECT * FROM user_product_reviews WHERE user_id = ?", nativeQuery = true)
    Page<Review> findReviewByUserId(Long userId, Pageable pageable);
}
