package com.spartanHardware.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.data.repository.cdi.Eager;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "parent_category")
public class ParentCategory {

    // TODO: 18/2/2023 Find the best practice to initialize the HashMap
    public ParentCategory(String category) {
        this.category = category;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "category")
    private String category;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "parentCategory")
    @JsonIgnoreProperties("parentCategory")
    private List<Product> products = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "parentCategory", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("parentCategory")
    private List<SubCategory> subCategories = new ArrayList<>();
}
