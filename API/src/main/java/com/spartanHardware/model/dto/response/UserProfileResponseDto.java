package com.spartanHardware.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserProfileResponseDto {
    private String email;
    private String firstName;
    private String lastName;
    private List<String> authorities;
    private AddressResponseDTO defaultAddress;
    private List<PaymentMethodResponseDto> paymentMethods;
}
