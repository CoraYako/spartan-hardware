package com.spartanHardware.repository;

import com.spartanHardware.model.entity.ParentCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentCategoryRepository extends JpaRepository<ParentCategory, Long> {
}
