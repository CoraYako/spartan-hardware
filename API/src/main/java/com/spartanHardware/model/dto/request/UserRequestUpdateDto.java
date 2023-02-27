package com.spartanHardware.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRequestUpdateDto {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
