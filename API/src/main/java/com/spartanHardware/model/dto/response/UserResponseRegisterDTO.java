package com.spartanHardware.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class UserResponseRegisterDTO {
    private String email;
    private String firstName;
    private String lastName;
    private List<String> authorities;
    private LocalDateTime creationDate;
    private String token;
}
