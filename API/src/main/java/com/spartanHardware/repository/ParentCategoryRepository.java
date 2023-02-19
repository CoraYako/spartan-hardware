package com.spartanHardware.repository;

import com.spartanHardware.model.entity.ParentCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParentCategoryRepository extends JpaRepository<ParentCategory, Long> {

    @Query(value = "SELECT * FROM parent_category WHERE category LIKE ?", nativeQuery = true)
    Optional<ParentCategory> findByCategory(String category);
}
