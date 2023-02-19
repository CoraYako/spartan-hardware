package com.spartanHardware.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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

    @NotNull
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

    @OneToMany(mappedBy = "product")
    @JsonIgnoreProperties("product")
    private List<ProductAttribute> attributes;

    @NotNull
    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "price_with_discount")
    private BigDecimal priceWithDiscount;

    @Column(name = "sku")
    private String sku;

    @Column(name = "photo")
    private String photo;

    @Column(name = "quantity")
    private Integer quantity;

    @CreationTimestamp
    @Column(name = "in_stock_since")
    private LocalDateTime inStockSince = now();

    @Column(name = "available")
    private Boolean available = TRUE;

    @UpdateTimestamp
    @Column(name = "updated_on_date")
    private LocalDateTime updateDate;

}
