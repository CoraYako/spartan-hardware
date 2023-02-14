package com.spartanHardware.util;

import com.spartanHardware.model.dto.request.AuthorityRequestDTO;
import com.spartanHardware.model.entity.Authority;
import com.spartanHardware.model.enums.Role;
import com.spartanHardware.service.IAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AuthorityDataLoader implements CommandLineRunner {

    @Autowired
    private IAuthorityService service;

    @Override
    public void run(String... args) throws Exception {
        loadAuthorityData();
    }

    private void loadAuthorityData(){
        if (service.getAllAuthorities().isEmpty()) {

            Authority roleAdmin = new Authority();
            roleAdmin.setName(Role.ADMIN.getSimpleRoleName());
            service.createAuthority(roleAdmin);

            Authority roleUser = new Authority();
            roleUser.setName(Role.USER.getSimpleRoleName());
            service.createAuthority(roleUser);
        }
    }
}
