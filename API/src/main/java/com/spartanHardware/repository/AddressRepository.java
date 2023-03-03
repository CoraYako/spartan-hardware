package com.spartanHardware.repository;

import com.spartanHardware.model.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query(value="SELECT CASE WHEN COUNT(*) > 0 THEN 'true' else 'false' END FROM address WHERE street = :street AND number = :number", nativeQuery = true)
    boolean findIfAddressExist(@Param("street") String street, @Param("number") String number);
}