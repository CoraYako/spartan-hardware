package com.spartanHardware.service;

import com.spartanHardware.model.dto.request.UserRequestDTO;
import com.spartanHardware.model.dto.response.UserResponseDTO;

public interface IUserService {

    UserResponseDTO registerUser(UserRequestDTO dto);
    UserResponseDTO registerAdmin(UserRequestDTO dto);


}
