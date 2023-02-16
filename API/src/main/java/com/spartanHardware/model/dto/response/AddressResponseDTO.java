package com.spartanHardware.model.dto.response;

public record AddressResponseDTO(
        String street,
        String number,
        String departamentNumber,
        String city,
        String province,
        Boolean defaultAddress
) {
}
