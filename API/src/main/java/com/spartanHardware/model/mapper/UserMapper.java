package com.spartanHardware.model.mapper;

import com.spartanHardware.model.dto.request.UserRequestDTO;
import com.spartanHardware.model.dto.response.UserResponseDTO;
import com.spartanHardware.model.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserResponseDTO toDto(User user) {
        return new  UserResponseDTO(
                user.getUsername(),
                user.getFirstName(),
                user.getLastName(),
                user.getAuthorities()
                        .stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList()),
                user.getCreationDate()
        );
    }

    public User toUser(UserRequestDTO dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEnabled(true);
        return user;
    }

    public User toUpdatedUser(UserRequestDTO dto, User user) {
        if(!Objects.isNull(dto.getEmail())) user.setEmail(dto.getEmail());
        if(!Objects.isNull(dto.getPassword())) user.setPassword(dto.getPassword());
        if(!Objects.isNull(dto.getFirstName())) user.setFirstName(dto.getFirstName());
        if(!Objects.isNull(dto.getLastName())) user.setLastName(dto.getLastName());
        return user;
    }

    public List<UserResponseDTO> toDtoList (List<User> users){
        return users.stream().map(user -> toDto(user)).collect(Collectors.toList());
    }
}
