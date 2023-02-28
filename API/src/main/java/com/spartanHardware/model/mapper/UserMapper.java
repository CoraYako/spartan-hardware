package com.spartanHardware.model.mapper;

import com.spartanHardware.exception.CustomException;
import com.spartanHardware.model.dto.request.UserRequestDTO;
import com.spartanHardware.model.dto.request.UserRequestUpdateDto;
import com.spartanHardware.model.dto.response.UserProfileResponseDto;
import com.spartanHardware.model.dto.response.UserResponseDTO;
import com.spartanHardware.model.dto.response.UserResponseRegisterDTO;
import com.spartanHardware.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final AddressMapper addressMapper;
    private final PaymentMethodMapper paymentMethodMapper;
    private final PasswordEncoder encoder;

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

    public UserResponseRegisterDTO toDtoRegister(User user) {
        return new UserResponseRegisterDTO(
                user.getUsername(),
                user.getFirstName(),
                user.getLastName(),
                user.getAuthorities()
                        .stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList()),
                user.getCreationDate(),
                ""
        );
    }

    public UserProfileResponseDto toDtoProfile(User user){
        return new  UserProfileResponseDto(
                user.getUsername(),
                user.getFirstName(),
                user.getLastName(),
                user.getAuthorities()
                        .stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList()),
                addressMapper.toDto(
                        user.getAddresses()
                                .stream()
                                .filter(address -> address.isDefaultAddress())
                                .collect(Collectors.toList())
                                .get(0)),
                paymentMethodMapper.toDtoList(user.getPaymentMethods())
        );
    }

    public User toUser(UserRequestDTO dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEnabled(true);
        user.setPassword(encoder.encode(dto.getPassword()));
        return user;
    }

    public User toUpdatedUser(UserRequestUpdateDto dto, User user) {
        if(!Objects.isNull(dto.getEmail()) && !dto.getEmail().isEmpty()) user.setEmail(dto.getEmail());
        if(!Objects.isNull(dto.getFirstName()) && !dto.getFirstName().isEmpty()) user.setFirstName(dto.getFirstName());

        if(!Objects.isNull(dto.getOldPassword()) && !dto.getOldPassword().isEmpty())
            if(!encoder.matches(dto.getOldPassword(), user.getPassword())) {
                throw new CustomException("Old password incorrecta", BAD_REQUEST, LocalDateTime.now());
            } else if (!Objects.isNull(dto.getNewPassword()) && !dto.getNewPassword().isEmpty()) {
                user.setPassword(encoder.encode(dto.getNewPassword()));
            }

        if(!Objects.isNull(dto.getLastName()) && !dto.getLastName().isEmpty()) user.setLastName(dto.getLastName());
        return user;
    }

    public List<UserResponseDTO> toDtoList (List<User> users){
        return users.stream().map(user -> toDto(user)).collect(Collectors.toList());
    }
}
