package com.spartanHardware.repository;

import com.spartanHardware.model.entity.ParentCategory;
import com.spartanHardware.model.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {

    @Query(value = "SELECT * FROM sub_category WHERE sub_category LIKE ?", nativeQuery = true)
    Optional<SubCategory> findBySubCategory(String subCategory);
}
