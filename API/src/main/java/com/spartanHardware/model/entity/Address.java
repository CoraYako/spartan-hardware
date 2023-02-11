package com.spartanHardware.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "street")
    private String street;

    @NotNull
    @Column(name = "number")
    private String number;

    @Column(name = "department_number")
    private String departmentNumber;

    @NotNull
    @Column(name = "city")
    private String city;

    @NotNull
    @Column(name = "province")
    private String province;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    @Column(name = "default")
    private boolean defaultAddress;
}
