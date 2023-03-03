package com.spartanHardware.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.EAGER;
import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "sub_category")
public class SubCategory {

    // TODO: 18/2/2023 Find the best practice to initialize the HashMap
    public SubCategory(String subCategory) {
        this.subCategory = subCategory;
        this.products = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "sub_category")
    private String subCategory;

    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "parent_category_id")
    private ParentCategory parentCategory;

    @OneToMany(mappedBy = "subCategory", fetch = EAGER)
    @JsonIgnoreProperties("subCategory")
    private List<Product> products = new ArrayList<>();
}


