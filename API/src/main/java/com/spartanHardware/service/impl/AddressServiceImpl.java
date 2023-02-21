package com.spartanHardware.service.impl;

import com.spartanHardware.model.dto.request.AddressRequestDTO;
import com.spartanHardware.model.dto.response.AddressResponseDTO;
import com.spartanHardware.model.entity.Address;
import com.spartanHardware.model.entity.User;
import com.spartanHardware.model.mapper.AddressMapper;
import com.spartanHardware.repository.AddressRepository;
import com.spartanHardware.service.IAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements IAddressService {

    private final AddressRepository repository;
    private final AddressMapper mapper;

    @Override
    @Transactional
    public AddressResponseDTO registerAddress(AddressRequestDTO dto) {
        Address address = mapper.toAddress(dto);
        Address savedAddress = repository.save(address);

        return mapper.toDto(savedAddress);
    }

    @Override
    @Transactional
    public AddressResponseDTO updateAddress(AddressRequestDTO dto, Long id) {
        Address address = getAddressById(id);
        User user = new User();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(!auth.getName().equalsIgnoreCase(user.getUsername()))
            System.out.println("Usuario no coincide");
        Address updatedAddress = mapper.toUpdatedAddress(dto,address);

        return mapper.toDto(repository.save(updatedAddress));
    }

    @Override
    public List<AddressResponseDTO> getAllAddresses() {
        return mapper.toDtoList(repository.findAll());
    }

    @Override
    public Address getAddressById(Long id) {
        if(!repository.findById(id).isPresent())
            System.out.println("La dirección no coincide");
        return repository.findById(id).get();
    }

    @Override
    public AddressResponseDTO getAddressDtoById(Long id) {
        return mapper.toDto(getAddressById(id));
    }

    @Override
    @Transactional
    public void deleteAddressById(Long id) {
        Address address = getAddressById(id);
        User user = new User();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(!auth.getName().equalsIgnoreCase(user.getUsername()))
            System.out.println("Usuario no coincide");
        repository.deleteById(id);
    }
}
