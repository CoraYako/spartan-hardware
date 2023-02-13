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

import java.time.LocalDateTime;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

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
    private Double price;

    @Column(name = "price_with_discount")
    private Double priceWithDiscount;

    @Column(name = "sku")
    private String sku;

    @Column(name = "photo")
    private String photo;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "in_stock_since")
    private LocalDateTime inStockSince;

    @Column(name = "available")
    private Boolean available;

    @CreationTimestamp
    @Column(name = "created_on_date")
    private LocalDateTime creationDate;

    @UpdateTimestamp
    @Column(name = "updated_on_date")
    private LocalDateTime updateDate;

}
