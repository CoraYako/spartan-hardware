package com.spartanHardware.service.impl;

import com.spartanHardware.model.entity.ShoppingCart;
import com.spartanHardware.model.entity.User;
import com.spartanHardware.repository.ShoppingCartRepository;
import com.spartanHardware.service.IShoppingCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ShoppingCartServiceImpl implements IShoppingCartService {

    private final ShoppingCartRepository repository;

    @Override
    @Transactional
    public ShoppingCart createShoppingCart(User loggedUser) {
        ShoppingCart cart = new ShoppingCart();
        cart.setUser(loggedUser);
        repository.save(cart);

        loggedUser.getShoppingCarts().add(cart);

        return cart;
    }
}
