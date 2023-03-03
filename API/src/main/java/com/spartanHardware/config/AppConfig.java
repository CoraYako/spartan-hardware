package com.spartanHardware.config;

import com.spartanHardware.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

@Configuration
@RequiredArgsConstructor
public class AppConfig {

    protected final String[] ALLOWED_ORIGINS = {
            "https://c9-22-t-javareact.vercel.app",
            "http://localhost:3000",
            "http://localhost"
    };
    protected final String[] ALLOWED_METHODS = {
            "GET",
            "POST",
            "PATCH",
            "DELETE"
    };
    private final UserRepository repository;
    private final MessageSource message;

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> repository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(message.getMessage("entity.notFound", new String[]{"User", "email", username}, Locale.US)));
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebMvcConfigurer corsConfigure() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/v1/users/**")
                        .allowedOrigins(ALLOWED_ORIGINS)
                        .allowedMethods(ALLOWED_METHODS);
                registry.addMapping("/api/v1/auth/**")
                        .allowedOrigins(ALLOWED_ORIGINS)
                        .allowedMethods(ALLOWED_METHODS);
                registry.addMapping("/api/v1/addresses/**")
                        .allowedOrigins(ALLOWED_ORIGINS)
                        .allowedMethods(ALLOWED_METHODS);
                registry.addMapping("/api/v1/products/**")
                        .allowedOrigins(ALLOWED_ORIGINS)
                        .allowedMethods(ALLOWED_METHODS);
            }

        };
    }
}