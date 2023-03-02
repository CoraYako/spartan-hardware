package com.spartanHardware.service;

import com.spartanHardware.model.dto.request.ShopOrderDto;
import com.spartanHardware.model.entity.ShopOrder;
import com.spartanHardware.model.entity.User;

public interface IShopOrderService {

    ShopOrder createShopOrder (User loggedUser, ShopOrderDto order);
}