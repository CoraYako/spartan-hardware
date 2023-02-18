package com.spartanHardware.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class AddressRequestDTO{
    private String street;
    private String number;
    private String departamentNumber;
    private String departamentFloor;
    private String postalCode;
    private String city;
    private String province;
    private Boolean defaultAddress;
}
