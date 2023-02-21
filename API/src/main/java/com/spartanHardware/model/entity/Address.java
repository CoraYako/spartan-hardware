package com.spartanHardware.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "address")
@SQLDelete(sql = "UPDATE address SET enabled = false WHERE id = ?")
@Where(clause = "enabled = true")
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

    @Column(name = "department_floor")
    private String departmentFloor;

    @NotNull
    @Column(name = "postal_code")
    private String postalCode;

    @NotNull
    @Column(name = "city")
    private String city;

    @NotNull
    @Column(name = "province")
    private String province;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "default_address")
    private boolean defaultAddress;

    @Column(name = "enabled")
    private Boolean enabled = true;
}
