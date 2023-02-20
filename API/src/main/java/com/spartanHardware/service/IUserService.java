package com.spartanHardware.service;

import com.spartanHardware.model.dto.request.UserRequestDTO;
import com.spartanHardware.model.dto.response.UserResponseDTO;
import com.spartanHardware.model.entity.User;

import java.util.List;

public interface IUserService {

    UserResponseDTO registerUser(UserRequestDTO dto);
    UserResponseDTO registerAdmin(UserRequestDTO dto);
    UserResponseDTO updateUser(UserRequestDTO dto, Long id);
    List<UserResponseDTO> getAllUsers();
    User getUserById(Long id);
    UserResponseDTO getUserDtoById(Long id);
    void deleteUserById(Long id);


}
