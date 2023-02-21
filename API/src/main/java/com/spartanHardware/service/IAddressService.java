package com.spartanHardware.service;

import com.spartanHardware.model.dto.request.AddressRequestDTO;
import com.spartanHardware.model.dto.response.AddressResponseDTO;
import com.spartanHardware.model.entity.Address;

import java.util.List;

public interface IAddressService {

    AddressResponseDTO registerAddress(AddressRequestDTO dto);
    AddressResponseDTO updateAddress(AddressRequestDTO dto, Long id);
    List<AddressResponseDTO> getAllAddresses();
    Address getAddressById(Long id);
    AddressResponseDTO getAddressDtoById(Long id);
    void deleteAddressById(Long id);
}
