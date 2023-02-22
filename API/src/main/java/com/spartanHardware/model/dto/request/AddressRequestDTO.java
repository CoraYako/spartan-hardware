package com.spartanHardware.model.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class AddressRequestDTO{

    @NotNull
    private String street;
    @NotNull
    private String number;
    private String departamentNumber;
    private String departamentFloor;
    @NotNull
    private String postalCode;
    @NotNull
    private String city;
    @NotNull
    private String province;
    private Boolean defaultAddress;
}
