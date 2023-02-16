package com.spartanHardware.model.dto.request;

public record AddressRequestDTO(
        String street,
        String number,
        String departamentNumber,
        String city,
        String province,
        Boolean defaultAddress
) {
}
