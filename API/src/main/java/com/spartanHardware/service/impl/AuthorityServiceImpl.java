package com.spartanHardware.service.impl;

import com.spartanHardware.model.entity.Authority;
import com.spartanHardware.repository.AuthorityRepository;
import com.spartanHardware.service.IAuthorityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorityServiceImpl implements IAuthorityService {

    private final AuthorityRepository repository;

    @Override
    public Authority createAuthority(Authority authority) {
        Authority savedAuthority = repository.save(authority);
        return savedAuthority;
    }

    @Override
    public List<Authority> getAllAuthorities() {
        return repository.findAll();
    }
}
