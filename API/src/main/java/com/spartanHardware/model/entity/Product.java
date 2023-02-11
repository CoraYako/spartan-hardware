package com.spartanHardware.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@MappedSuperclass
@Table(name = "products")
@Setter
@Getter
@SQLDelete(sql = "UPDATE products SET available = false WHERE id = ?")
@Where(clause = "available = true")
public class Product {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "category")
    private Category category;

    @NotNull
    @Column(name = "price")
    private Double price;

    @Column(name = "price_with_discount")
    private Double priceWithDiscount;

    @Column(name = "photo")
    private String photo;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "available")
    private Boolean available;

    @CreationTimestamp
    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @UpdateTimestamp
    @Column(name = "update_date")
    private LocalDateTime updateDate;

}
