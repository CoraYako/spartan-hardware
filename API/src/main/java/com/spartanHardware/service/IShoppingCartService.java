package com.spartanHardware.service;

import com.spartanHardware.model.dto.request.ShoppingCartItemDto;
import com.spartanHardware.model.entity.ShoppingCart;
import com.spartanHardware.model.entity.ShoppingCartItem;
import com.spartanHardware.model.entity.User;

import java.math.BigDecimal;
import java.util.List;

public interface IShoppingCartService {
    ShoppingCart createShoppingCart (User loggedUser);
}
