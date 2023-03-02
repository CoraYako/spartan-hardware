package com.spartanHardware.model.mapper;

import com.spartanHardware.model.dto.request.ShoppingCartItemDto;
import com.spartanHardware.model.entity.Product;
import com.spartanHardware.model.entity.ShoppingCart;
import com.spartanHardware.model.entity.ShoppingCartItem;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartItemMapper {

    public ShoppingCartItem toEntity (ShoppingCartItemDto dto, Product product, ShoppingCart cart){
        ShoppingCartItem item = new ShoppingCartItem();
        item.setProduct(product);
        item.setProductQuantity(dto.getProductQuantity());
        item.setShoppingCart(cart);
        return item;
    }
}
