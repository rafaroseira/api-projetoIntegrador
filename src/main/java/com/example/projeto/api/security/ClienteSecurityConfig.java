package com.example.projeto.api.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import com.example.projeto.api.service.ClienteUserDetailsService;

@SuppressWarnings("deprecation")
@Configuration
public class ClienteSecurityConfig{
    @Bean
    public UserDetailsService clienteUserDetailsService() {
        return new ClienteUserDetailsService();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(clienteUserDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
 
        return authProvider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authenticationProvider(authenticationProvider());
        
        http.authorizeRequests().requestMatchers("/","/cliente/cadastro").permitAll()
        .requestMatchers("/cliente/*").authenticated().and().httpBasic().and().csrf().disable();

        /*http.authorizeRequests().anyRequest().authenticated();
        http.formLogin();
        http.httpBasic();*/
       
       return http.build();
    }
}
