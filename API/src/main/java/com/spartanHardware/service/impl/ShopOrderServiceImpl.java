package com.spartanHardware.service.impl;

import com.spartanHardware.model.dto.request.ShopOrderDto;
import com.spartanHardware.model.entity.ShopOrder;
import com.spartanHardware.model.entity.ShoppingCartItem;
import com.spartanHardware.model.entity.User;
import com.spartanHardware.repository.ShopOrderRepository;
import com.spartanHardware.service.IAddressService;
import com.spartanHardware.service.IPaymentMethodService;
import com.spartanHardware.service.IShopOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopOrderServiceImpl implements IShopOrderService {

    private final ShopOrderRepository repository;
    private final IAddressService addressService;
    private final IPaymentMethodService paymentMethodService;

    @Override
    public ShopOrder createShopOrder(User loggedUser, ShopOrderDto orderDto) {
        ShopOrder order = new ShopOrder();
        order.setUser(loggedUser);
        order.setProducts(orderDto.getItems());
        order.setPaymentMethod(paymentMethodService.getById(orderDto.getIdPaymentMethod()));
        order.setShippingAddress(addressService.getAddressById(orderDto.getIdAddress()));
        order.setOrderTotal(orderDto.getPriceTotal());
        repository.save(order);
        return order;
    }
}
