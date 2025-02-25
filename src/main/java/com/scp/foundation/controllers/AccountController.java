package com.scp.foundation.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.scp.foundation.domains.AccountRepository;
import com.scp.foundation.models.Account;

@RestController
public class AccountController {
	
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
		return new AccountDto(account.getId(), account.getDefaultEmail(), account.getUserName(), account.getStatus());
	}	
	
	// Permet de créer un compte
	@PostMapping("/account")
	public AccountDto createAccount(@RequestBody AccountDto accountDto) {
		Account account = accountRepository.save(new Account(accountDto.defaultEmail(), accountDto.userName(), accountDto.status()));
		return new AccountDto(account.getId(), account.getDefaultEmail(), account.getUserName(), account.getStatus());
	}
	
	// Permet de modifier un compte par son ID
	@PutMapping("/account/{id}")
	public Account modifyAccount(@RequestBody Account accountModified, @PathVariable Long id) {
		return accountRepository.findById(id)
				.map(account -> { 
					account.setDefaultEmail(accountModified.getDefaultEmail());
					account.setUserName(accountModified.getUserName());
					account.setStatus(accountModified.getStatus());
					return accountRepository.save(account);
				})
				.orElseGet(() -> {
					return accountRepository.save(accountModified);
		});
	}
	
	// Permet de supprimer un compte par son ID
	@DeleteMapping("/account/{id}")
	public String deleteAccount(@PathVariable Long id) {
		Account account = accountRepository.findById(id).orElseThrow();
		accountRepository.delete(account);
		return null;
	}
}
