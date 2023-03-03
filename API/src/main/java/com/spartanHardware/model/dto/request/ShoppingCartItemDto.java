package com.spartanHardware.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ShoppingCartItemDto {
    private Long id;
    private Integer quantity;
    private BigDecimal price;
}
