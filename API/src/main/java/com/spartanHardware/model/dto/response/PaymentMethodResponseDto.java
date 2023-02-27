package com.spartanHardware.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class PaymentMethodResponseDto {
    private String paymentType;
    private String provider;
    private Long accountNumber;
    private LocalDate expiryDate;
    private boolean defaultMethod;
}
