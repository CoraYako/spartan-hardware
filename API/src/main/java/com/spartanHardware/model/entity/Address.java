package com.spartanHardware.model.entity;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@Table(name = "address")
@SQLDelete(sql = "UPDATE users SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
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

    @Column(name = "departament_number")
    private String departament_number;

    @NotNull
    @Column(name = "city")
    private String city;

    @NotNull
    @Column(name = "province")
    private String province;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

}
