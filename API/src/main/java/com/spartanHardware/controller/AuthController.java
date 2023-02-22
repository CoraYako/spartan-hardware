package com.spartanHardware.controller;

import com.spartanHardware.model.dto.request.LoginRequestDto;
import com.spartanHardware.model.dto.request.UserRequestDTO;
import com.spartanHardware.model.dto.response.LoginResponseDto;
import com.spartanHardware.model.dto.response.UserResponseDTO;
import com.spartanHardware.model.dto.response.UserResponseRegisterDTO;
import com.spartanHardware.service.IUserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final IUserService service;

    @PostMapping("/register-user")
    public ResponseEntity<UserResponseRegisterDTO> registerUser(@Valid @RequestBody UserRequestDTO dto){
        UserResponseRegisterDTO user = service.registerUser(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PostMapping("/register-admin")
    public ResponseEntity<UserResponseRegisterDTO> registerAdmin(@Valid @RequestBody UserRequestDTO dto){
        UserResponseRegisterDTO user = service.registerAdmin(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@Valid @RequestBody LoginRequestDto dto){
        LoginResponseDto response = service.loginUser(dto);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
