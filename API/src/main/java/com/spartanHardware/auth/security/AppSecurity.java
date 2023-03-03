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

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class AppSecurity {

    protected final String[] AUTH_WHITELIST = {
            "/api/v1/products/outstanding",
            "/api/v1/products/search",
            "/api/v1/products/filter",
            "/swagger-ui/**",
            "/v3/**",
            "/swagger-ui.html",
            "/api/v1/auth/register-user",
            "/api/v1/auth/login",
            "/api/v1/products/details/**",
            "/api/v1/products/paginated",
            "/api/v1/products/categories",
            "/api/v1/products/sub-categories",
            "/api/v1/products/all-reviews/**"
    };

    private final JWTAuthenticationFilter jwtFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers(AUTH_WHITELIST)
                .permitAll()
                .requestMatchers(POST, "/api/v1/auth/register-admin").hasAnyAuthority(Role.ADMIN.getSimpleRoleName())
                .requestMatchers(GET, "/api/v1/users").hasAnyAuthority(Role.ADMIN.getSimpleRoleName())
                .requestMatchers(GET, "/api/v1/users/{id}").hasAnyAuthority(Role.ADMIN.getSimpleRoleName())
                .requestMatchers(POST, "/api/v3/products/upload-image").hasAnyAuthority(Role.ADMIN.getSimpleRoleName())
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
