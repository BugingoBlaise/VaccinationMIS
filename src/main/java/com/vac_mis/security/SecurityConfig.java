package com.vac_mis.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
            .authorizeHttpRequests(authorize -> authorize
                    .requestMatchers("/login", "/info", "/vaccine", "/css/**", "/js/**").permitAll()
                    .anyRequest().authenticated()
            )
            .formLogin(formLogin -> formLogin
                    .defaultSuccessUrl("/info")
                    .loginProcessingUrl("/login")
                    .failureForwardUrl("/login")
                    .permitAll()

            ).logout(
                    logout -> logout
                            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                            .logoutSuccessUrl("/login")  // Add this line
                            .permitAll()

            );
//            .csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable());

    return http.build();
}
}
