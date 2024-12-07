package com.bcc.gestao.bluevelvet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(
                configurer -> configurer
                        .requestMatchers( "/api/v1/users").permitAll()
                        .requestMatchers( "/api/v1/users/**").permitAll()
                        .requestMatchers( "/api/v1/products").permitAll()
                        .requestMatchers( "/api/v1/products/**").permitAll()
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/swagger-resources/**").permitAll()
        );

        // use http basic authorization
        httpSecurity.httpBasic(Customizer.withDefaults());

        // disable CSRF
        httpSecurity.csrf(csrf -> csrf.disable());

        return httpSecurity.build();
    }
}
