package com.spartanHardware.service;

import com.spartanHardware.model.dto.request.LoginRequestDto;
import com.spartanHardware.model.dto.request.UserRequestDTO;
import com.spartanHardware.model.dto.request.UserRequestUpdateDto;
import com.spartanHardware.model.dto.response.*;
import com.spartanHardware.model.entity.User;

import java.util.List;

public interface IUserService {

    UserResponseRegisterDTO registerUser(UserRequestDTO dto);
    UserResponseRegisterDTO registerAdmin(UserRequestDTO dto);
    LoginResponseDto loginUser(LoginRequestDto dto);
    UserResponseDTO updateUser(UserRequestUpdateDto dto, Long id, User loggedUser);
    List<UserResponseDTO> getAllUsers();
    User getUserById(Long id);
    UserResponseDTO getUserDtoById(Long id);
    UserProfileResponseDto getUserProfile(Long id, User loggedUser);
    void deleteUserById(Long id, User loggedUser);
    List<PaymentMethodResponseDto> paymentMethodsByUser(Long id, User loggedUser);

}
