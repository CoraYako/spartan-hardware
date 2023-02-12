package com.spartanHardware.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "sub_category")
@Setter
@Getter
public class SubCategory {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "sub_category")
    private String sub_category;

    @ManyToOne
    @JoinColumn(name = "parent_category_id")
    private ParentCategory parentCategory;

    @OneToMany(mappedBy = "subCategory")
    @JsonIgnoreProperties("subCategory")
    private List<Product> products;
}
