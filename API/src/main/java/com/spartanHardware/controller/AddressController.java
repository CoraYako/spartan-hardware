package com.spartanHardware.controller;


import com.spartanHardware.model.dto.request.AddressRequestDTO;
import com.spartanHardware.model.dto.response.AddressResponseDTO;
import com.spartanHardware.model.entity.Address;
import com.spartanHardware.model.entity.User;
import com.spartanHardware.service.IAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/addresses")
@RequiredArgsConstructor
public class AddressController {

    private final IAddressService service;

    @PostMapping
    public ResponseEntity<AddressResponseDTO> registerAddress(@AuthenticationPrincipal User loggedUser, @RequestBody AddressRequestDTO dto){
      AddressResponseDTO address = service.registerAddress(dto, loggedUser);

      return ResponseEntity.status(HttpStatus.CREATED).body(address);
    }

    @GetMapping("/")
    public ResponseEntity<AddressResponseDTO> getAllAddresses(@AuthenticationPrincipal User loggedUser) {
        AddressResponseDTO addressResponseDto = (AddressResponseDTO) service.getAllAddresses(loggedUser);
        return ResponseEntity.status(OK).body(addressResponseDto);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<AddressResponseDTO> updateProduct(@AuthenticationPrincipal User loggedUser,
                                                            @PathVariable Long id,
                                                            @RequestBody AddressRequestDTO addressRequestDTO) {
        AddressResponseDTO productResponseDto = service.updateAddress(addressRequestDTO, id, loggedUser);
        return ResponseEntity.status(OK).body(productResponseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddressById(@AuthenticationPrincipal User loggedUser, @PathVariable Long id) {
        service.deleteAddressById(id, loggedUser);
        return ResponseEntity.status(NO_CONTENT).build();
    }

}
