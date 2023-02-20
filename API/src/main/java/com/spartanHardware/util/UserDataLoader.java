package com.spartanHardware.util;

import com.spartanHardware.model.dto.request.UserRequestDTO;
import com.spartanHardware.model.entity.Authority;
import com.spartanHardware.model.enums.Role;
import com.spartanHardware.service.IAuthorityService;
import com.spartanHardware.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthorityDataLoader implements CommandLineRunner {

    private final IAuthorityService service;
    private final IUserService userService;

    @Override
    public void run(String... args) throws Exception {
        loadAuthorityData();
        loadUserData();
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

    private void loadUserData() {
        if(userService.getAllUsers().isEmpty()){
            UserRequestDTO admin1 = new UserRequestDTO(
                    "c.admin@cuak.cm",
                    "1234",
                    "Carolina",
                    "Martinez"
            );
            UserRequestDTO admin2 = new UserRequestDTO(
                    "p.admin123@ht.cm",
                    "1234",
                    "Pedro",
                    "López"
            );
            userService.registerAdmin(admin1);
            userService.registerAdmin(admin2);

            UserRequestDTO user1 = new UserRequestDTO(
                    "m.prueba@cuak.cm",
                    "1234",
                    "Martina",
                    "Benitez"
            );
            UserRequestDTO user2 = new UserRequestDTO(
                    "w.prueba980@ht.cm",
                    "1234",
                    "Lucas",
                    "Weber"
            );
            userService.registerUser(user1);
            userService.registerUser(user2);
        }
    }
}
