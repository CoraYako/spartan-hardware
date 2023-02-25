package com.spartanHardware.auth.security;

import com.spartanHardware.auth.filter.JWTAuthenticationFilter;
import com.spartanHardware.model.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.*;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class AppSecurity {
    private final JWTAuthenticationFilter jwtFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers("/api/v1/auth/register-user", "/api/v1/auth/login")
                .permitAll()
                .requestMatchers(POST, "/api/v1/auth/register-admin").hasAnyAuthority(Role.ADMIN.getSimpleRoleName())
                .requestMatchers(GET, "/api/v1/users").hasAnyAuthority(Role.ADMIN.getSimpleRoleName())
                .requestMatchers(GET, "/api/v1/users/{id}").hasAnyAuthority(Role.ADMIN.getSimpleRoleName())
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
        ;

        return http.build();
    }
}
