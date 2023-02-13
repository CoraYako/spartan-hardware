package com.spartanHardware.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "parent_category")
@Setter
@Getter
public class ParentCategory {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "category")
    private String category;

    @OneToMany(mappedBy = "parentCategory")
    @JsonIgnoreProperties("parentCategory")
    private List<Product> products;

    @OneToMany(mappedBy = "parentCategory")
    @JsonIgnoreProperties("parentCategory")
    private List<SubCategory> subCategories;

}
