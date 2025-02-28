package com.scp.foundation.controllers.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import com.scp.foundation.domains.account.AccountRepository;
import com.scp.foundation.models.account.Account;
import com.scp.foundation.security.ScpEncryption;

@RestController
public class AccountController {

	@Value("${SECRET_KEY}")
	private String secretKey;
	private final AccountRepository accountRepository;

	public AccountController(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	// Permet de récupérer la liste de tous les comptes
	@GetMapping("/accounts")
	public List<Account> getAllAccounts() {
		return accountRepository.findAll();
	}

	// Permet de récupérer un compte par son ID
	@GetMapping("/account/{id}")
	public AccountDto getAccountById(@PathVariable Long id) {
		Account account = accountRepository.findById(id).orElseThrow();
		return new AccountDto(account.getId(), account.getDefaultEmail(), account.getUserName(), ScpEncryption.decrypt(secretKey, account.getPassword()), account.getSecurityLevel());
	}

	// Permet de créer un compte
	@PostMapping("/account")
	public AccountDto createAccount(@RequestBody AccountDto accountDto) {
		Account account = accountRepository
				.save(new Account(accountDto.defaultEmail(), accountDto.userName(), accountDto.password(), accountDto.securityLevel()));
		return new AccountDto(account.getId(), account.getDefaultEmail(), account.getUserName(), ScpEncryption.encrypt(secretKey, account.getPassword()), account.getSecurityLevel());
	}

	// Permet de modifier un compte par son ID
	@PutMapping("/account/{id}")
	public Account modifyAccount(@RequestBody Account accountModified, @PathVariable Long id) {
		return accountRepository.findById(id).map(account -> {
			account.setDefaultEmail(accountModified.getDefaultEmail());
			account.setUserName(accountModified.getUserName());
			account.setPassword(ScpEncryption.encrypt(secretKey, accountModified.getPassword()));
			account.setSecurityLevel(accountModified.getSecurityLevel());
			return accountRepository.save(account);
		}).orElseGet(() -> accountRepository.save(accountModified));
	}

	// Permet de supprimer un compte par son ID
	@DeleteMapping("/account/{id}")
	public String deleteAccount(@PathVariable Long id) {
		Account account = accountRepository.findById(id).orElseThrow();
		accountRepository.delete(account);
		return null;
	}
}
