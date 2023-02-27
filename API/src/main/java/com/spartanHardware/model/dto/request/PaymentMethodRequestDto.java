package com.spartanHardware.model.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class PaymentMethodRequestDto {
    @NotNull
    private String paymentType;

    @NotNull
    private String provider;

    @NotNull
    private Long accountNumber;

    @NotNull
    private LocalDate expiryDate;

    @NotNull
    private boolean defaultMethod;
}
