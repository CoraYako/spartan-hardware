package com.spartanHardware.controller;

import com.spartanHardware.model.dto.request.UserRequestDTO;
import com.spartanHardware.model.dto.request.UserRequestUpdateDto;
import com.spartanHardware.model.dto.response.UserProfileResponseDto;
import com.spartanHardware.model.dto.response.UserResponseDTO;
import com.spartanHardware.model.entity.User;
import com.spartanHardware.service.IUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final IUserService service;
    @GetMapping()
    public ResponseEntity<List<UserResponseDTO>> getAllUsers(){
        List<UserResponseDTO> users = service.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id){
        UserResponseDTO user = service.getUserDtoById(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping("/profile/{id}")
    public ResponseEntity<UserProfileResponseDto> getProfileUserById(@PathVariable Long id, @AuthenticationPrincipal User loggedUser){
        UserProfileResponseDto profileUser = service.getUserProfile(id, loggedUser);
        return ResponseEntity.status(HttpStatus.OK).body(profileUser);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@Valid @RequestBody UserRequestUpdateDto dto, @PathVariable Long id){
        UserResponseDTO user = service.updateUser(dto, id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        service.deleteUserById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
