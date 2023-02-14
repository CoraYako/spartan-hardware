package com.spartanHardware.model.dto.response;

import com.spartanHardware.model.entity.Authority;

import java.time.LocalDateTime;
import java.util.List;

public record UserResponseDTO(
        String email,
        String firstName,
        String lastName,
        List<String> authorities,
        LocalDateTime creationDate
) {
}
