package com.spartanHardware.service.impl;

import com.spartanHardware.model.dto.request.ShopOrderDto;
import com.spartanHardware.model.dto.request.ShoppingCartDto;
import com.spartanHardware.model.dto.request.ShoppingCartItemDto;
import com.spartanHardware.model.entity.*;
import com.spartanHardware.model.mapper.ShoppingCartItemMapper;
import com.spartanHardware.repository.ShoppingCartItemRepository;
import com.spartanHardware.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShoppingCartItemServiceImpl implements IShoppingCartItemService {

    private final IProductService productService;
    private final IShoppingCartService cartService;
    private final IShopOrderService orderService;
    private final ShoppingCartItemRepository itemRepository;
    private final ShoppingCartItemMapper mapper;

    @Override
    public void createShoppingCartItem(ShoppingCartDto dto, User loggedUser) {

        ShoppingCart cart = cartService.createShoppingCart(loggedUser);

        List<ShoppingCartItem> items = dto.getDtoItems().stream()
                .map(i -> mapper.toEntity(i, productService.getProductById(i.getProductId()), cart))
                .collect(Collectors.toList());

        ShopOrderDto orderDto = new ShopOrderDto(items, dto.getIdAddress(), dto.getIdPaymentMethod(), dto.getPriceTotal());
        ShopOrder order = orderService.createShopOrder(loggedUser, orderDto);

        items.forEach(i-> {
            i.setShopOrder(order);
            itemRepository.save(i);
        } );

    }
}
