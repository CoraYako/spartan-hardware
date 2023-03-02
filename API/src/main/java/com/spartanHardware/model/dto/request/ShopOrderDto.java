package com.spartanHardware.model.dto.request;

import com.spartanHardware.model.entity.ShoppingCartItem;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class ShopOrderDto {
    private List<ShoppingCartItem> items;
    private Long idAddress;
    private Long idPaymentMethod;
    private BigDecimal priceTotal;
}
