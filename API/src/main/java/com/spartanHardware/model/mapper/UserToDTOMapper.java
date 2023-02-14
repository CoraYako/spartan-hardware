package com.spartanHardware.model.mapper;

import com.spartanHardware.model.dto.response.UserResponseDTO;
import com.spartanHardware.model.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class UserToDTOMapper implements Function<User, UserResponseDTO> {

    @Override
    public UserResponseDTO apply(User user) {
        UserResponseDTO dto = new  UserResponseDTO(
                user.getUsername(),
                user.getFirstName(),
                user.getLastName(),
                user.getAuthorities()
                        .stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList()),
                user.getCreationDate()
        );
        return dto;
    }
}
