package com.spartanHardware.repository;

import com.spartanHardware.model.entity.AttributeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeValueRepository extends JpaRepository<AttributeValue, Long> {
}
