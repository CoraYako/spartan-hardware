package com.spartanHardware.repository;

import com.spartanHardware.model.entity.ProductAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductAttributeRepository extends JpaRepository<ProductAttribute, Long> {

    @Query(value = "SELECT * FROM product_attribute WHERE attribute LIKE ? AND product_id = ?", nativeQuery = true)
    Optional<ProductAttribute> findAttributeByProductId(String attribute, Long productId);
}
