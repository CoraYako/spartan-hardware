package com.spartanHardware.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginRequestDto {
    private String username;
    private String password;
}
