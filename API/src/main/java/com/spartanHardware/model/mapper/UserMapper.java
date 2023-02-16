package com.spartanHardware.model.mapper;

import com.spartanHardware.model.dto.request.UserRequestDTO;
import com.spartanHardware.model.dto.response.UserResponseDTO;
import com.spartanHardware.model.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserResponseDTO toDto(User user) {
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

    public User toUser(UserRequestDTO dto) {
        User user = new User();
        user.setEmail(dto.email());
        user.setFirstName(dto.firstName());
        user.setLastName(dto.lastName());
        user.setPassword(dto.password());
        user.setEnabled(true);
        return user;
    }
}
