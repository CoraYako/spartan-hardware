package com.spartanHardware.model.mapper;

import com.spartanHardware.model.dto.request.AddressRequestDTO;
import com.spartanHardware.model.dto.response.AddressResponseDTO;
import com.spartanHardware.model.entity.Address;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

        return address;
    }

    public Address toUpdatedAddress(AddressRequestDTO dto, Address address) {
        if(!Objects.isNull(dto.getStreet())) address.setStreet(dto.getStreet());
        if(!Objects.isNull(dto.getNumber())) address.setNumber(dto.getNumber());
        if(!Objects.isNull(dto.getDepartamentNumber())) address.setDepartmentNumber(dto.getDepartamentNumber());
        if(!Objects.isNull(dto.getDepartamentFloor())) address.setDepartmentFloor(dto.getDepartamentFloor());
        if(!Objects.isNull(dto.getPostalCode())) address.setPostalCode(dto.getPostalCode());
        if(!Objects.isNull(dto.getCity())) address.setCity(dto.getCity());
        if(!Objects.isNull(dto.getProvince())) address.setProvince(dto.getProvince());
        if(!Objects.isNull(dto.getDefaultAddress()) && dto.getDefaultAddress()) address.setDefaultAddress(dto.getDefaultAddress());
        return address;
    }

    public List<AddressResponseDTO> toDtoList(List<Address> addresses) {
        return addresses.stream().map(address -> toDto(address)).collect(Collectors.toList());
    }
}
