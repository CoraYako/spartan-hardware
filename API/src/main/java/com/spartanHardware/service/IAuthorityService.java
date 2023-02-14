package com.spartanHardware.service;

import com.spartanHardware.model.dto.request.AuthorityRequestDTO;
import com.spartanHardware.model.dto.response.AuthorityResponseDTO;
import com.spartanHardware.model.entity.Authority;

import java.util.List;

public interface IAuthorityService {

    Authority createAuthority (Authority dto);

    List<Authority> getAllAuthorities();
}
