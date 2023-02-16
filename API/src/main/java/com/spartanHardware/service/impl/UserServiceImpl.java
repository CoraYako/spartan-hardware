package com.spartanHardware.service.impl;

import com.spartanHardware.model.dto.request.UserRequestDTO;
import com.spartanHardware.model.dto.response.UserResponseDTO;
import com.spartanHardware.model.entity.Authority;
import com.spartanHardware.model.entity.User;
import com.spartanHardware.model.enums.Role;
import com.spartanHardware.model.mapper.DTOToUserMapper;
import com.spartanHardware.model.mapper.UserToDTOMapper;
import com.spartanHardware.repository.AuthorityRepository;
import com.spartanHardware.repository.UserRepository;
import com.spartanHardware.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService, UserDetailsService {

    private final UserRepository repository;

    private final AuthorityRepository authorityRepository;

    private final PasswordEncoder encoder;

    private final UserToDTOMapper toDTOMapper;

    private final DTOToUserMapper toUserMapper;

    private final MessageSource message;

    @Override
    @Transactional
    public UserResponseDTO registerUser(UserRequestDTO dto) {
        if(!repository.existsByEmail(dto.email())){

        }
        User user = toUserMapper.apply(dto);
        user.setPassword(encoder.encode(dto.password()));
        addRoleToUser(Role.USER.getSimpleRoleName(), user);
        User savedUser = repository.save(user);
        return toDTOMapper.apply(savedUser);
    }

    @Override
    @Transactional
    public UserResponseDTO registerAdmin(UserRequestDTO dto) {
        if(!repository.existsByEmail(dto.email())){

        }
        User user = toUserMapper.apply(dto);
        user.setPassword(encoder.encode(dto.password()));
        addRoleToUser(Role.ADMIN.getSimpleRoleName(), user);
        User savedUser = repository.save(user);
        return toDTOMapper.apply(savedUser);
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
                message.getMessage("entity.notFound", null, Locale.US)));
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getAuthorities().forEach((authority) -> {
            authorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
        });

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }
}
