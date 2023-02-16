package com.spartanHardware.controller;

import com.spartanHardware.model.dto.request.UserRequestDTO;
import com.spartanHardware.model.dto.response.UserResponseDTO;
import com.spartanHardware.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final IUserService service;

    @PostMapping("users/register")
    public ResponseEntity<UserResponseDTO> registerUser(@RequestBody UserRequestDTO dto){
        UserResponseDTO user = service.registerUser(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PostMapping("auth/register")
    public ResponseEntity<UserResponseDTO> registerAdmin(@RequestBody UserRequestDTO dto){
        UserResponseDTO user = service.registerAdmin(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
