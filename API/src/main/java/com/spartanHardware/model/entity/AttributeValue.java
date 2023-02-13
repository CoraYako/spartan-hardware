package com.spartanHardware.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "attribute_value")
@Setter
@Getter
public class AttributeValue {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_attribute_id")
    private ProductAttribute productAttribute;

    @NotNull
    @Column(name = "value")
    private String value;

}
