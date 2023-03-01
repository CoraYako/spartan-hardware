package com.spartanHardware.service;

import com.spartanHardware.model.dto.request.AddressRequestDTO;
import com.spartanHardware.model.dto.response.AddressResponseDTO;
import com.spartanHardware.model.entity.Address;
import com.spartanHardware.model.entity.User;

import java.util.List;

public interface IAddressService {

    AddressResponseDTO registerAddress(AddressRequestDTO dto, User loggedUser);
    AddressResponseDTO updateAddress(AddressRequestDTO dto, Long id, User loggedUser);
    List<AddressResponseDTO> getAllAddresses(User loggedUser);
    Address getAddressById(Long id);
    AddressResponseDTO getAddressDtoById(Long id, User loggedUser);
    void deleteAddressById(Long id, User loggedUser);
}
