package com.spartanHardware.service;

import com.spartanHardware.model.dto.request.AddressRequestDTO;
import com.spartanHardware.model.dto.response.AddressResponseDTO;

public interface IAddressService {

    AddressResponseDTO registerAddress(AddressRequestDTO dto);
}
