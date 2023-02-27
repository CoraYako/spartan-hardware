package com.spartanHardware.service.impl;

import com.spartanHardware.auth.filter.JWTAuthenticationFilter;
import com.spartanHardware.auth.filter.JwtService;
import com.spartanHardware.exception.CustomException;
import com.spartanHardware.model.dto.request.LoginRequestDto;
import com.spartanHardware.model.dto.request.UserRequestDTO;
import com.spartanHardware.model.dto.request.UserRequestUpdateDto;
import com.spartanHardware.model.dto.response.LoginResponseDto;
import com.spartanHardware.model.dto.response.UserResponseDTO;
import com.spartanHardware.model.dto.response.UserResponseRegisterDTO;
import com.spartanHardware.model.entity.Authority;
import com.spartanHardware.model.entity.User;
import com.spartanHardware.model.enums.Role;
import com.spartanHardware.model.mapper.UserMapper;
import com.spartanHardware.repository.AuthorityRepository;
import com.spartanHardware.repository.UserRepository;
import com.spartanHardware.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;

import static org.springframework.http.HttpStatus.*;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService, UserDetailsService {

    private final UserRepository repository;
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserMapper mapper;
    private final MessageSource message;

    @Override
    @Transactional
    public UserResponseRegisterDTO registerUser(UserRequestDTO dto) {
         if(repository.existsByEmail(dto.getEmail()))
             throw new CustomException(message.getMessage("entity.exists",null,Locale.US), BAD_REQUEST, LocalDateTime.now());
        User user = mapper.toUser(dto);
        user.setPassword(encoder.encode(dto.getPassword()));
        addRoleToUser(Role.USER.getSimpleRoleName(), user);

        UserResponseRegisterDTO userResponse = mapper.toDtoRegister(repository.save(user));
        String token = jwtService.generateToken(user);
        userResponse.setToken(token);
        return userResponse;
    }

    @Override
    @Transactional
    public UserResponseRegisterDTO registerAdmin(UserRequestDTO dto) {
        if(repository.existsByEmail(dto.getEmail()))
            throw new CustomException(message.getMessage("entity.exists",null,Locale.US), BAD_REQUEST, LocalDateTime.now());;
        User user = mapper.toUser(dto);
        user.setPassword(encoder.encode(dto.getPassword()));
        addRoleToUser(Role.ADMIN.getSimpleRoleName(), user);

        UserResponseRegisterDTO userResponse = mapper.toDtoRegister(repository.save(user));
        String token = jwtService.generateToken(user);
        userResponse.setToken(token);
        return userResponse;
    }

    @Override
    public LoginResponseDto loginUser(LoginRequestDto dto) {
        authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(
                dto.getUsername(),
                dto.getPassword()
                )
        );
        User user = repository.findByEmail(dto.getUsername()).orElseThrow();
        String token = jwtService.generateToken(user);
        return new LoginResponseDto(token);
    }

    @Override
    @Transactional
    public UserResponseDTO updateUser(UserRequestUpdateDto dto, Long id, User loggedUser) {
        User user = getUserById(id);

        if(!loggedUser.getUsername().equalsIgnoreCase(user.getUsername()))
            throw new CustomException(message.getMessage("entity.noAccess", new String[] {"modify", "account"}, Locale.US), FORBIDDEN,LocalDateTime.now());

        if(repository.existsByEmail(dto.getEmail()))
            throw new CustomException(message.getMessage("entity.exists",null,Locale.US), BAD_REQUEST, LocalDateTime.now());

        User updatedUser = mapper.toUpdatedUser(dto,user);
        return mapper.toDto(repository.save(updatedUser));
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return mapper.toDtoList(repository.findAll());
    }

    @Override
    public User getUserById(Long id) {
        if(!repository.findById(id).isPresent())
            throw new CustomException(message.getMessage("entity.notFound", new String[] {"User", "id", id.toString()}, Locale.US), NOT_FOUND, LocalDateTime.now());
        return repository.findById(id).get();
    }

    @Override
    public UserResponseDTO getUserDtoById(Long id) {
        return mapper.toDto(getUserById(id));
    }

    @Override
    @Transactional
    public void deleteUserById(Long id, User loggedUser) {
        User user =  getUserById(id);
        if(!loggedUser.getUsername().equalsIgnoreCase(user.getUsername()))
            throw new CustomException(message.getMessage("entity.noAccess", new String[] {"delete", "account"}, Locale.US), FORBIDDEN, LocalDateTime.now());
        repository.deleteById(id);
    }

    @Transactional
    private void addRoleToUser(String nameRole, User user) {
        Set<Authority> authorities = new HashSet<>();
        Authority authority = authorityRepository.findByName(nameRole).get();
        authorities.add(authority);
        user.setAuthorities(authorities);

        authority.getUsers().add(user);
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(
                message.getMessage("entity.notFound", new String[] {"User", "email", email}, Locale.US)));
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getAuthorities().forEach((authority) -> {
            authorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
        });

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }
}
