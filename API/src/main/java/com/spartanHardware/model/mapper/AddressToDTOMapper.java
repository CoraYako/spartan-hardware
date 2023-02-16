package com.spartanHardware.model.mapper;

import com.spartanHardware.model.dto.response.AddressResponseDTO;
import com.spartanHardware.model.entity.Address;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class AddressToDTOMapper implements Function<Address, AddressResponseDTO> {
    @Override
    public AddressResponseDTO apply(Address address) {
        AddressResponseDTO dto = new AddressResponseDTO(
                address.getStreet(),
                address.getNumber(),
                address.getDepartmentNumber(),
                address.getCity(),
                address.getProvince(),
                address.isDefaultAddress()
        );
        return dto;
    }
}
