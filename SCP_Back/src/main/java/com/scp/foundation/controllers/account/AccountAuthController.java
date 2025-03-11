package com.scp.foundation.controllers.account;

import org.springframework.web.bind.annotation.*;

import com.scp.foundation.domains.account.AccountService;
import com.scp.foundation.exceptions.UnauthorizedException;
import com.scp.foundation.models.account.LoginRequest;
import com.scp.foundation.security.JwtUtil;

@RestController
@RequestMapping("/api/v1")
public class AccountAuthController {

    private final AccountService accountService;
    private final JwtUtil jwtUtil;

    public AccountAuthController(AccountService accountService, JwtUtil jwtUtil) {
        this.accountService = accountService;
        this.jwtUtil = jwtUtil;
    }

    // Endpoint pour l'authentification
    @PostMapping("/auth")
    public String authenticate(@RequestBody LoginRequest loginRequest) {
        // Appel à la méthode d'authentification
        AccountDto accountDto = accountService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());

        if (accountDto != null) {
            // Générer le token JWT si l'authentification est réussie
            return jwtUtil.generateToken(accountDto.userName());
        } else {
            throw new UnauthorizedException("Nom d'utilisateur ou mot de passe incorrect");
        }
    }
}
