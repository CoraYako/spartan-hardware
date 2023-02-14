package com.spartanHardware.model.mapper;

import com.spartanHardware.model.dto.request.UserRequestDTO;
import com.spartanHardware.model.entity.User;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class DTOToUserMapper implements Function<UserRequestDTO, User> {

    @Override
    public User apply(UserRequestDTO dto) {
        User user = new User();
        user.setEmail(dto.email());
        user.setFirstName(dto.firstName());
        user.setLastName(dto.lastName());
        user.setEnabled(Boolean.TRUE);
        return user;
    }
}
