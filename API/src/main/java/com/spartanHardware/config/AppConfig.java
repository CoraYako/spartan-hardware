package com.spartanHardware.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/v1/users/**")
                        .allowedOrigins("https://c9-22-t-javareact.vercel.app")
                        .allowedMethods("GET", "POST", "PATCH", "DELETE");
                registry.addMapping("/api/v1/auth/**")
                        .allowedOrigins("https://c9-22-t-javareact.vercel.app")
                        .allowedMethods("GET", "POST", "PATCH", "DELETE");
                registry.addMapping("/api/v1/addresses/**")
                        .allowedOrigins("https://c9-22-t-javareact.vercel.app")
                        .allowedMethods("GET", "POST", "PATCH", "DELETE");
                registry.addMapping("/api/v1/products/**")
                        .allowedOrigins("https://c9-22-t-javareact.vercel.app")
                        .allowedMethods("GET", "POST", "PATCH", "DELETE");
            }

        };
    }

}