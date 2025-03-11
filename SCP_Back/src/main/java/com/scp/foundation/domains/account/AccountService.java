package com.scp.foundation.domains.account;

import com.scp.foundation.controllers.account.AccountDto;
import com.scp.foundation.models.account.Account;
import com.scp.foundation.security.ScpEncryption;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements UserDetailsService {

    @Value("${SECRET_KEY}")
    private String secretKey;

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    // Méthode d'authentification avec décryptage du mot de passe
    public AccountDto authenticate(String username, String password) {
        // Recherche de l'utilisateur
        Account account = accountRepository.findByUserName(username);
        if (account != null) {
            // Utilisation de ScpEncryption pour décryptage du mot de passe
            String decryptedPassword = ScpEncryption.decrypt(account.getPassword(), secretKey);
            
            // Comparaison du mot de passe fourni avec le mot de passe décrypté
            if (password.equals(decryptedPassword)) {
                return new AccountDto(
                    account.getId(),
                    account.getDefaultEmail(),
                    account.getUserName(),
                    account.getPassword(),  // Conserve le mot de passe crypté en réponse
                    account.getSecurityLevel()
                );
            }
        }
        return null; // Authentification échouée
    }

    // Méthode pour charger un utilisateur pour Spring Security
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUserName(username);
        if (account == null) {
            throw new UsernameNotFoundException("Utilisateur non trouvé");
        }

        // Renvoie un UserDetails avec le nom d'utilisateur et le mot de passe crypté
        return User.withUsername(account.getUserName())
                   .password(account.getPassword())
                   .authorities(account.getSecurityLevel().toString())  // Facultatif : définir les rôles
                   .build();
    }
}
