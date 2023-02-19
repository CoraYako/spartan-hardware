package com.spartanHardware.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "product_attribute")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProductAttribute {

    public ProductAttribute(String attribute, String value) {
        this.attribute = attribute;
        this.value = value;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @NotNull
    @Column(name = "attribute")
    private String attribute;

    @NotNull
    @Column(name = "value")
    private String value;
}
