package com.spartanHardware.service.impl;

import com.spartanHardware.model.dto.request.AddressRequestDTO;
import com.spartanHardware.model.dto.response.AddressResponseDTO;
import com.spartanHardware.model.entity.Address;
import com.spartanHardware.model.mapper.AddressMapper;
import com.spartanHardware.repository.AddressRepository;
import com.spartanHardware.service.IAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements IAddressService {

    private final AddressRepository repository;
    private final AddressMapper mapper;

    @Override
    public AddressResponseDTO registerAddress(AddressRequestDTO dto) {
        Address address = mapper.toAddress(dto);
        Address savedAddress = repository.save(address);

        return mapper.toDto(savedAddress);
    }
}
