package com.spartanHardware.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class ShoppingCartDto {
    private List<ShoppingCartItemDto> cart;
    private String typeOfPayment;
    private BigDecimal totalAmount;
}
