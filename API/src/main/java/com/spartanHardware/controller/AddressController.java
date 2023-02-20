package com.spartanHardware.controller;


import com.spartanHardware.model.dto.request.AddressRequestDTO;
import com.spartanHardware.model.dto.response.AddressResponseDTO;
import com.spartanHardware.service.IAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AddressController {

    private final IAddressService service;

    @PostMapping
    public ResponseEntity<AddressResponseDTO> registerAddress(@RequestBody AddressRequestDTO dto){
      AddressResponseDTO address = service.registerAddress(dto);

      return ResponseEntity.status(HttpStatus.CREATED).body(address);
    }
}
