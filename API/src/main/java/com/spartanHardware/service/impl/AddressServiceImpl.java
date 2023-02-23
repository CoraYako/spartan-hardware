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
    public AddressResponseDTO registerAddress(AddressRequestDTO dto,User loggedUser) {
        Address address = mapper.toAddress(dto);
        loggedUser.getAddresses().add(address);
        address.setUser(loggedUser);
        address.setDefaultAddress(true);

        return mapper.toDto(repository.save(address));
    }

    @Override
    @Transactional
    public AddressResponseDTO updateAddress(AddressRequestDTO dto, Long id, User
                                             loggedUser) {
        Address address = getAddressById(id);
        if(!address.getUser().equals(loggedUser))
            // TODO: 22/2/2023 Cambiar mensaje por properties
            throw new RuntimeException("Esta dirección no coincide con el usuario logeado");

        Address updatedAddress = mapper.toUpdatedAddress(dto,address);

        return mapper.toDto(repository.save(updatedAddress));
    }

    @Override
    public List<AddressResponseDTO> getAllAddresses(User loggedUser) {

        return mapper.toDtoList(loggedUser.getAddresses());
    }

    @Override
    public Address getAddressById(Long id) {
        if(repository.findById(id).isEmpty())
            // TODO: 22/2/2023 Cambiar mensaje por properties
            throw new RuntimeException("La dirección no coincide");
        return repository.findById(id).get();
    }

    @Override
    public AddressResponseDTO getAddressDtoById(Long id, User loggedUser) {
        Address address = getAddressById(id);
        if(!address.getUser().equals(loggedUser))
            // TODO: 22/2/2023 Cambiar mensaje por properties
            throw new RuntimeException("Esta dirección no coincide con el usuario logeado");
        return mapper.toDto(address);
    }

    @Override
    @Transactional
    public void deleteAddressById(Long id, User loggedUser) {
        Address address = getAddressById(id);
        if(!address.getUser().equals(loggedUser))
            // TODO: 22/2/2023 Cambiar mensaje por properties
            throw new RuntimeException("Esta dirección no coincide con el usuario logeado");
        repository.deleteById(id);
    }
}
