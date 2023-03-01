package com.spartanHardware.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.time.LocalDateTime.now;

@Entity
@Table(name = "product")
@Setter
@Getter
@SQLDelete(sql = "UPDATE product SET available = false WHERE id = ?")
@Where(clause = "available = true")
public class Product {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @ManyToOne
    @JoinColumn(name = "parent_category_id")
    private ParentCategory parentCategory;

    @ManyToOne
    @JoinColumn(name = "sub_category_id")
    private SubCategory subCategory;

    @Column(name = "short_description",
            nullable = false,
            length = 500)
    private String shortDescription;

    @Column(name = "description",
            nullable = false,
            length = 1000)
    private String description;

    @Column(name = "recommended")
    private boolean recommended = FALSE;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "special_price")
    private BigDecimal specialPrice;

    @OneToMany(mappedBy = "product")
    private List<Image> productImages;

    @Column(name = "quantity")
    private Integer quantity;

    @CreationTimestamp
    @Column(name = "in_stock_since")
    private LocalDateTime inStockSince = now();

    @Column(name = "available")
    private Boolean available = TRUE;

    @Column(name = "fast_shipping")
    private boolean fastShipping = FALSE;

    @UpdateTimestamp
    @Column(name = "updated_on_date")
    private LocalDateTime updateDate;

    @OneToMany(mappedBy = "product")
    private List<Review> productReviews;
}
