package com.spartanHardware.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "product_attribute")
@Setter
@Getter
public class ProductAttribute {

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

    @OneToMany(mappedBy = "productAttribute")
    @JsonIgnoreProperties("productAttribute")
    private List<AttributeValue> attributeValues;

}
