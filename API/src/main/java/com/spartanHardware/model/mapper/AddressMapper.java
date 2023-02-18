package com.spartanHardware.model.mapper;

import com.spartanHardware.model.dto.request.AddressRequestDTO;
import com.spartanHardware.model.dto.response.AddressResponseDTO;
import com.spartanHardware.model.entity.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public AddressResponseDTO toDto(Address address) {
        AddressResponseDTO dto = new AddressResponseDTO(
                address.getId(),
                address.getStreet(),
                address.getNumber(),
                address.getDepartmentNumber(),
                address.getDepartmentFloor(),
                address.getPostalCode(),
                address.getCity(),
                address.getProvince(),
                address.isDefaultAddress()
        );
        return dto;
    }

    public Address toAddress(AddressRequestDTO dto) {
        Address address = new Address();
        address.setStreet(dto.getStreet());
        address.setNumber(dto.getNumber());
        address.setDepartmentNumber(dto.getDepartamentNumber());
        address.setDepartmentFloor(dto.getDepartamentFloor());
        address.setPostalCode(dto.getPostalCode());
        address.setCity(dto.getCity());
        address.setProvince(dto.getProvince());
        address.setDefaultAddress(false);

        return address;
    }
}
