package com.spartanHardware.controller;

import com.spartanHardware.model.dto.request.PaymentMethodRequestDto;
import com.spartanHardware.model.dto.request.ShoppingCartDto;
import com.spartanHardware.model.dto.request.UserRequestDTO;
import com.spartanHardware.model.dto.request.UserRequestUpdateDto;
import com.spartanHardware.model.dto.response.PaymentMethodResponseDto;
import com.spartanHardware.model.dto.response.UserProfileResponseDto;
import com.spartanHardware.model.dto.response.UserResponseDTO;
import com.spartanHardware.model.entity.User;
import com.spartanHardware.service.IPaymentMethodService;
import com.spartanHardware.service.IShoppingCartItemService;
import com.spartanHardware.service.IUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final IUserService service;
    private final IPaymentMethodService paymentMethodService;
    private final IShoppingCartItemService cartService;

    @GetMapping()
    public ResponseEntity<List<UserResponseDTO>> getAllUsers(){
        List<UserResponseDTO> users = service.getAllUsers();
        return ResponseEntity.status(OK).body(users);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id){
        UserResponseDTO user = service.getUserDtoById(id);
        return ResponseEntity.status(OK).body(user);
    }

    @GetMapping("/profile/{id}")
    public ResponseEntity<UserProfileResponseDto> getProfileUserById(@PathVariable Long id, @AuthenticationPrincipal User loggedUser){
        UserProfileResponseDto profileUser = service.getUserProfile(id, loggedUser);
        return ResponseEntity.status(OK).body(profileUser);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@Valid @RequestBody UserRequestUpdateDto dto, @PathVariable Long id, @AuthenticationPrincipal User loggedUser){
        UserResponseDTO user = service.updateUser(dto, id, loggedUser);
        return ResponseEntity.status(OK).body(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id, @AuthenticationPrincipal User loggedUser){
        service.deleteUserById(id, loggedUser);
        return ResponseEntity.status(OK).build();
    }

    @GetMapping("/payment-method/{id}")
    public ResponseEntity<List<PaymentMethodResponseDto>> getAllPaymentMethodsByUser(@PathVariable Long id, @AuthenticationPrincipal User loggedUser) {
        List<PaymentMethodResponseDto> list = service.paymentMethodsByUser(id, loggedUser);
        return ResponseEntity.status(OK).body(list);
    }

    @PostMapping("/payment-method")
    public ResponseEntity<Void> createPaymentMethod(@Valid @RequestBody PaymentMethodRequestDto dto, @AuthenticationPrincipal User loggedUser) {
        paymentMethodService.createPaymentMethod(dto, loggedUser);
        return ResponseEntity.status(OK).build();
    }

    @DeleteMapping("/payment-method/{id}")
    public ResponseEntity<Void> createPaymentMethod(@PathVariable Long id, @AuthenticationPrincipal User loggedUser) {
        paymentMethodService.deletePaymentMethod(id, loggedUser);
        return ResponseEntity.status(OK).build();
    }

    @PostMapping("/shopping-cart")
    public ResponseEntity<Void> createShoppingCart(@RequestBody ShoppingCartDto dto, @AuthenticationPrincipal User loggedUser){
        cartService.createShoppingCartItem(dto, loggedUser);
        return ResponseEntity.status(OK).build();
    }

}
