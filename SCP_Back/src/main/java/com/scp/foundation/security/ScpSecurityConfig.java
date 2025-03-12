package com.scp.foundation.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

import com.scp.foundation.domains.account.AccountService;

@Configuration
@EnableWebSecurity
public class ScpSecurityConfig {

    private final AccountService accountService;

    public ScpSecurityConfig(AccountService accountService) {
        this.accountService = accountService;
    }

    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/auth", "/account").permitAll() // Permet l'accès à /basicauth et /account sans authentification
                .anyRequest().authenticated()  // Toutes les autres requêtes nécessitent une authentification
            )
            .csrf(csrf -> csrf.disable());  // Désactive la protection CSRF (à utiliser pour des API REST)

        return http.build();
    }

    // Bean pour UserDetailsService pour charger les utilisateurs
    @Bean
    protected UserDetailsService userDetailsService() {
        return accountService;
    }
}
