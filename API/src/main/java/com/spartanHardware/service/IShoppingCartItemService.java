package com.spartanHardware.service;

import com.spartanHardware.model.dto.request.ShopOrderDto;
import com.spartanHardware.model.dto.request.ShoppingCartDto;
import com.spartanHardware.model.dto.request.ShoppingCartItemDto;
import com.spartanHardware.model.entity.ShoppingCartItem;
import com.spartanHardware.model.entity.User;

import java.math.BigDecimal;
import java.util.List;

public interface IShoppingCartItemService {
    void createShoppingCartItem (ShoppingCartDto dto, User loggedUser);
}
