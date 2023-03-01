package com.spartanHardware.repository;

import com.spartanHardware.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findAll(Specification<Product> specification, Pageable pageable);

    @Query(value = "SELECT * FROM product WHERE name LIKE CONCAT('%', :query, '%')", nativeQuery = true)
    Page<Product> findAllByName(String query, Pageable pageable);
}
