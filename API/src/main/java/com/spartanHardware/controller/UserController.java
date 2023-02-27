package com.spartanHardware.controller;

import com.spartanHardware.model.dto.request.PaymentMethodRequestDto;
import com.spartanHardware.model.dto.request.UserRequestDTO;
import com.spartanHardware.model.dto.request.UserRequestUpdateDto;
import com.spartanHardware.model.dto.response.UserProfileResponseDto;
import com.spartanHardware.model.dto.response.UserResponseDTO;
import com.spartanHardware.model.entity.User;
import com.spartanHardware.service.IPaymentMethodService;
import com.spartanHardware.service.IUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final IUserService service;
    private final IPaymentMethodService paymentMethodService;

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
    public ResponseEntity<UserResponseDTO> updateUser(@Valid @RequestBody UserRequestUpdateDto dto, @PathVariable Long id, @AuthenticationPrincipal User loggedUser){
        UserResponseDTO user = service.updateUser(dto, id, loggedUser);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id, @AuthenticationPrincipal User loggedUser){
        service.deleteUserById(id, loggedUser);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/payment-method")
    public ResponseEntity<Void> createPaymentMethod(@Valid @RequestBody PaymentMethodRequestDto dto, @AuthenticationPrincipal User loggedUser) {
        paymentMethodService.createPaymentMethod(dto, loggedUser);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/payment-method/{id}")
    public ResponseEntity<Void> createPaymentMethod(@PathVariable Long id, @AuthenticationPrincipal User loggedUser) {
        paymentMethodService.deletePaymentMethod(id, loggedUser);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
