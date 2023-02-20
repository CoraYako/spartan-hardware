package com.spartanHardware.controller;

import com.spartanHardware.model.dto.request.UserRequestDTO;
import com.spartanHardware.model.dto.response.UserResponseDTO;
import com.spartanHardware.service.IUserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("auth")
public class AuthController {

    private final IUserService service;

    @PostMapping("/register-user")
    public ResponseEntity<UserResponseDTO> registerUser(@Valid @RequestBody UserRequestDTO dto){
        UserResponseDTO user = service.registerUser(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PostMapping("/register-admin")
    public ResponseEntity<UserResponseDTO> registerAdmin(@Valid @RequestBody UserRequestDTO dto){
        UserResponseDTO user = service.registerAdmin(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
