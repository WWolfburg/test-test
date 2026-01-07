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

    //Regler för access till olika endpoints
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(auth -> auth
        .requestMatchers("/", "/api/users/Register", "/images/**", "/products/**", "/css/**", "/product/**").permitAll()  //Allmän access till endpoints
        .requestMatchers("/orders/**", "/api/orders/**").authenticated()  //Inlogg krävs för att se dessa endpoints
        .anyRequest().authenticated() // Allmän inlogg krävs allt som inte är listat ovan
        )
        .userDetailsService(jpaUserDetailsService)
        .formLogin(Customizer.withDefaults()); // Standarn login form från Spring Security
        return http.build();
    }

    // Crypterar lösenord med BCrypt så att det inte sparas som lösentext
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
}
