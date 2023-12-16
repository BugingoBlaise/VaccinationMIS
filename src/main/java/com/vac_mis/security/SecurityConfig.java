package com.vac_mis.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
//@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
/*
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        UserDetails admin = User.withUsername("Blaise").password(encoder.encode("open")).roles("ADMIN").build();
        UserDetails nurse = User.withUsername("dinah").password(encoder.encode("open")).roles("NURSE").build();
return new InMemoryUserDetailsManager(admin,nurse);
    }
@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
return http.csrf().disable()
        .authorizeHttpRequests()
        .requestMatchers("/home","/login").permitAll()
        .and()
        .authorizeHttpRequests().requestMatchers("/vaccine/**").authenticated()
        .and().build();
    }
*/

}

