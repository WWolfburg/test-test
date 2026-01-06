package com.LL.login_WWolfburg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import com.LL.login_WWolfburg.service.JpaUserDetailsService;

@Configuration
public class SecurityConfig {

    private final JpaUserDetailsService jpaUserDetailsService;

    

    public SecurityConfig(JpaUserDetailsService jpaUserDetailsService) {
        this.jpaUserDetailsService = jpaUserDetailsService;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(auth -> auth
        .requestMatchers("/", "/api/users/Register", "/images/**").permitAll()
        .requestMatchers("/orders/**", "/api/orders/**").authenticated()
        .anyRequest().permitAll()
        )
        .userDetailsService(jpaUserDetailsService)
        .formLogin(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
}
