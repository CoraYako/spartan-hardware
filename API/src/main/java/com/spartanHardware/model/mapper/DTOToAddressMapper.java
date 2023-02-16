package com.spartanHardware.model.mapper;

import com.spartanHardware.model.dto.request.AddressRequestDTO;
import com.spartanHardware.model.entity.Address;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class DTOToAddressMapper implements Function<AddressRequestDTO, Address> {
    @Override
    public Address apply(AddressRequestDTO dto) {
        Address address = new Address();
        address.setStreet(dto.street());
        address.setNumber(dto.number());
        address.setDepartmentNumber(dto.departamentNumber());
        address.setCity(dto.city());
        address.setProvince(dto.province());
        address.setDefaultAddress(dto.defaultAddress());

        return address;
    }
}
