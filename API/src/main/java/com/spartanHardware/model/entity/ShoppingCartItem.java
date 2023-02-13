package com.spartanHardware.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "shopping_cart_item")
@Entity
public class ShoppingCartItem {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "cart_id")
    private ShoppingCart shoppingCart;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "product_qty")
    private Integer productQuantity;

    @ManyToOne
    @JoinColumn(name = "shop_order_id")
    private ShopOrder shopOrder;
}
