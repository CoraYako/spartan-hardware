package com.spartanHardware.service.impl;

import com.spartanHardware.model.dto.request.AddressRequestDTO;
import com.spartanHardware.model.dto.response.AddressResponseDTO;
import com.spartanHardware.model.entity.Address;
import com.spartanHardware.model.entity.User;
import com.spartanHardware.model.mapper.AddressMapper;
import com.spartanHardware.repository.AddressRepository;
import com.spartanHardware.service.IAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements IAddressService {

    private final AddressRepository repository;
    private final AddressMapper mapper;
    private final MessageSource message;

    @Override
    @Transactional
    public AddressResponseDTO registerAddress(AddressRequestDTO dto,User loggedUser) {
        if(repository.findIfAddressExist(dto.getStreet(),dto.getNumber())){
            throw new RuntimeException(
                    message.getMessage("entity.exists", new String[] {"address", "street"}, Locale.US)
            );
        }
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
        if(!loggedUser.getUsername().equals(address.getUser().getUsername()))
            throw new RuntimeException(
                    message.getMessage("entity.noAccess", new String[] {"modify", "address"}, Locale.US)
            );

        Address updatedAddress = mapper.toUpdatedAddress(dto,address);

        return mapper.toDto(repository.save(updatedAddress));
    }

    @Override
    public List<AddressResponseDTO> getAllAddresses(User loggedUser) {

        return mapper.toDtoList(loggedUser.getAddresses());
    }

    @Override
    public Address getAddressById(Long id) {

        return repository.findById(id).orElseThrow(() -> new NullPointerException(
                message.getMessage("entity.notFound", new String[] {"Address", "id", id.toString()}, Locale.US)
        ));
    }

    @Override
    public AddressResponseDTO getAddressDtoById(Long id, User loggedUser) {
        Address address = getAddressById(id);
        if(!loggedUser.getUsername().equals(address.getUser().getUsername()))
            throw new RuntimeException(
                    message.getMessage("entity.noAccess", new String[] {"modify", "address"}, Locale.US)
            );
        return mapper.toDto(address);
    }

    @Override
    @Transactional
    public void deleteAddressById(Long id, User loggedUser) {
        Address address = getAddressById(id);
        if(!loggedUser.getUsername().equals(address.getUser().getUsername()))
            throw new RuntimeException(
                    message.getMessage("entity.noAccess", new String[] {"modify", "address"}, Locale.US)
            );
        repository.deleteById(id);
    }
}
