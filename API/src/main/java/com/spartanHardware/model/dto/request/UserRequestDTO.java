package com.spartanHardware.model.dto.request;

public record UserRequestDTO(
        String email,
        String password,
        String firstName,
        String lastName
) {
}
