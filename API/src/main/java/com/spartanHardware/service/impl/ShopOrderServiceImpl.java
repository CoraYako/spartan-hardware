package com.spartanHardware.service.impl;

import com.spartanHardware.model.dto.request.ShopOrderDto;
import com.spartanHardware.model.entity.ShopOrder;
import com.spartanHardware.model.entity.ShoppingCartItem;
import com.spartanHardware.model.entity.User;
import com.spartanHardware.model.enums.PaymentType;
import com.spartanHardware.model.enums.StateShopOrder;
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

    @Override
    public ShopOrder createShopOrder(User loggedUser, ShopOrderDto orderDto) {
        ShopOrder order = new ShopOrder();
        order.setUser(loggedUser);
        order.setProducts(orderDto.getCart());
        //Todo: change to accept more payment methods
        order.setType(PaymentType.DEPOSIT);
        //Todo: add address
        order.setOrderTotal(orderDto.getTotalAmount());
        //Todo: change to accept more states
        order.setState(StateShopOrder.PENDENT);
        repository.save(order);
        return order;
    }
}
